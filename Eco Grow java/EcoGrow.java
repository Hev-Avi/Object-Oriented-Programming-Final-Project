import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

class Tree {
    protected String treeName;
    protected String description;

    public Tree(String treeName, String description) {
        this.treeName = treeName;
        this.description = description;
    }

    public void showDetailsForDonation() {
        System.out.println("Tree Name: " + treeName);
    }

    public void showDetailsForSelection() {
        System.out.println(treeName + ", " + description);
    }
}

class Donation {
    private String donorName;
    private String donorEmail;
    private String donorPhone;
    private Tree tree;
    private String location;
    private double amount;

    public Donation(String donorName, String donorEmail, String donorPhone, Tree tree, String location, double amount) {
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.donorPhone = donorPhone;
        this.tree = tree;
        this.location = location;
        this.amount = amount;
    }

    public void showDonationDetails() {
        DecimalFormat df = new DecimalFormat("0.00"); // Format to 2 decimal places
        System.out.println("Donor Name: " + donorName);
        System.out.println("Donor Email: " + donorEmail);
        System.out.println("Donor Phone: " + donorPhone);
        tree.showDetailsForDonation(); 
        System.out.println("Location: " + location);
        System.out.println("Amount Donated: P" + df.format(amount)); // Display with 2 decimal places
    }

    public double getAmount() {
        return amount;
    }

    public String getTreeName() {
        return tree.treeName;
    }
}

class Admin {
    private String adminAccessCode;

    public Admin(String adminAccessCode) {
        this.adminAccessCode = adminAccessCode;
    }

    public boolean verifyAccess(String inputCode) {
        return inputCode.equals(adminAccessCode);
    }

    public void viewDonations(List<Donation> donations) {
        if (donations.isEmpty()) {
            System.out.println("No donations yet.");
        } else {
            for (Donation donation : donations) {
                donation.showDonationDetails();
                System.out.println();
            }
        }
    }
}

public class EcoGrow {
    private static List<Tree> treeOptions = new ArrayList<>();
    private static List<String> locationOptions = new ArrayList<>();
    private static List<Donation> donationHistory = new ArrayList<>();

    static {
        treeOptions.add(new Tree("Narra", "A native tree known for its hardwood and strong presence"));
        treeOptions.add(new Tree("Mahogany", "A tall tree that provides valuable timber used in furniture."));
        treeOptions.add(new Tree("Bamboo", "A fast-growing tree known for its fast growth and useful wood."));
        treeOptions.add(new Tree("Mango", "A tropical fruit tree that produces sweet and juicy fruits."));
        treeOptions.add(new Tree("Acacia", "A tree that is known for its fast growth and useful wood."));
        treeOptions.add(new Tree("Pine", "An evergreen tree often planted in the forest"));
        treeOptions.add(new Tree("Coconut", "A tropical tree that produces coconuts used in various products."));
        treeOptions.add(new Tree("Jackfruit", "A tropical tree that produces large, sweet fruits."));
        treeOptions.add(new Tree("Santol", "A tropical tree producing sweet and tangy fruits."));
        treeOptions.add(new Tree("Banana", "A fruit-bearing tree that grows in tropical climates."));
       
        locationOptions.add("Manila");
        locationOptions.add("Cebu");
        locationOptions.add("Davao");
        locationOptions.add("Iloilo");
        locationOptions.add("Cagayan de Oro");
        locationOptions.add("Zamboanga");
        locationOptions.add("Dumaguete");
        locationOptions.add("Tacloban");
        locationOptions.add("Tagbilaran");
        locationOptions.add("Tarlac");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("ecogrow2003");
    
        while (true) {
            System.out.println("Welcome to EcoGrow Donation System");
            System.out.println("1. Donate");
            System.out.println("2. Admin Panel");
            System.out.println("3. Exit");
    
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println();
    
                switch (choice) {
                    case 1:
                        donate(scanner);
                        break;
                    case 2:
                        adminPanel(scanner, admin);
                        break;
                    case 3:
                        System.out.println("Thank you for using EcoGrow.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next(); 
            }
        }
    }
    

    private static void donate(Scanner scanner) {
        String donorName = promptForName(scanner);
        String donorEmail = promptForEmail(scanner);
        String donorPhone = promptForPhone(scanner);
        Tree selectedTree = promptForTree(scanner);
        String selectedLocation = promptForLocation(scanner);
        double donationAmount = promptForAmount(scanner);

        Donation donation = new Donation(donorName, donorEmail, donorPhone, selectedTree, selectedLocation, donationAmount);
        donationHistory.add(donation);
        System.out.println("Thank you for your donation!");
    }

    private static String promptForName(Scanner scanner) {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    private static String promptForEmail(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        }
        return email;
    }

    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private static String promptForPhone(Scanner scanner) {
        String phone;
        while (true) {
            System.out.print("Enter your phone number: ");
            phone = scanner.nextLine();
            if (phone.matches("\\d+")) { 
                break;
            } else {
                System.out.println("Invalid phone number. Please enter numbers only.");
            }
        }
        return phone;
    }

    private static Tree promptForTree(Scanner scanner) {
        int treeChoice;
        while (true) {
            System.out.println("\nSelect Tree:");
            for (int i = 0; i < treeOptions.size(); i++) {
                System.out.println((i + 1) + ". " + treeOptions.get(i).treeName + " - " + treeOptions.get(i).description);
            }
            System.out.print("Enter the number of your choice: ");
            if (scanner.hasNextInt()) {
                treeChoice = scanner.nextInt();
                scanner.nextLine(); 
                if (treeChoice > 0 && treeChoice <= treeOptions.size()) {
                    return treeOptions.get(treeChoice - 1);
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + treeOptions.size() + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }
    
    private static String promptForLocation(Scanner scanner) {
        int locationChoice;
        while (true) {
            System.out.println("\nSelect Location:");
            for (int i = 0; i < locationOptions.size(); i++) {
                System.out.println((i + 1) + ". " + locationOptions.get(i));
            }
            System.out.print("Enter the number of your choice: ");
            if (scanner.hasNextInt()) {
                locationChoice = scanner.nextInt();
                scanner.nextLine(); 
                if (locationChoice > 0 && locationChoice <= locationOptions.size()) {
                    return locationOptions.get(locationChoice - 1);
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + locationOptions.size() + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }
    
    private static double promptForAmount(Scanner scanner) {
        double amount;
        while (true) {
            System.out.print("Enter donation amount: P");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Donation amount must be greater than 0.");
                }
            } else {
                System.out.println("Invalid amount. Please enter a valid number.");
                scanner.next(); 
            }
        }
        return amount;
    }

    private static void adminPanel(Scanner scanner, Admin admin) {
        System.out.print("Enter admin access code: ");
        String accessCode = scanner.nextLine();

        if (admin.verifyAccess(accessCode)) {
            System.out.println("Access granted.");
            System.out.println("Viewing donation history...");
            admin.viewDonations(donationHistory);
        } else {
            System.out.println("Invalid access code.");
        }
    }
}
