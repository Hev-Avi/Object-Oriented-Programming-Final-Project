# I. Brief Project Overview 

Ecogrow: a java console program that facilitates tree donation system. Ecogrow allows users to select tree, location, and to make a donation while having an organized record of donation for admin panel review. This project integrates core Object-Oriented-Programming Principles.

# II. Explanation of how OOP principles were applied

**Encapsulation**:

  - **Private:**
    - The `Donation` class encapsulates fields liike `donorName`, `donorEmail`, `donorPhone`, `location`, and `amount` by making them private. While `Admin` class encapsulates the `adminAccessCode` field by making it private.

  - **Public:**
      - Getter methods like `getAmount` and `getTreeName` in the `Donation` class provide controlled access to the private fields. While in the `Admin` class is `verifyAccess` method which restricts access to the `adminAccessCode` field by providing a way to verify the access code externally.
   
**Inheritance:**
   - The `Tree`class serves as the base class which provide common attributes and methods. such as `treename` and `description`, and `showDetailsForDonation` and `showDetailsForSelection`.

**Polymorphism**
  - Polymorphism demostraded through the `showDetailsForDonation` and `showDetailsForSelection` in the `Tree` class. Which can be overridden or extended in subclasses. 

**Abstraction**
  - The `Tree` class abstracts the details of the tree by exposing methods like `showDetailForTree` and `showDetailsForSelection`. Also `Donation` class abstracts donation details such as donor information, tree selection, location, and amount. `Admin` class where it abstract the admin operations, like verifying access codes and viewing donations.

# SDG and its integration into the project

 **SDG 15: Life on Land**
  - EcoGrow focuses on Sustainable Development Goal (SDG) 15, which emphasizes "Life on Land." This system facilitates tree planting donations by allowing users to select from various tree species, each with detailed descriptions, and choose specific locations where the trees are needed. By providing these options, EcoGrow ensures that donors can contribute to planting the right tree in the right place, maximizing its positive impact on the ecosystem. Additionally, the system aims to raise awareness and encourage others to participate, demonstrating how even small contributions can have a significant and positive effect on our planet’s ecosystems.

# IV. Instructions for Running the Program
  1. Open the folder *`Eco Grow java`*
  2. Open the file named *`EcoGrow.java` or `EcoGrow`*
  3. Press *`CTRL + ALT + N`* for the program to run.
    
