# **SmartShare \- Console Application**

1. # **OVERVIEW**

   

Smartshare is a digital platform designed to empower students by providing equitable access to  
essential gadgets and resources needed for academic success. With the increasing reliance on  
technology for learning, SmartShare addresses the challenges many students face in acquiring  
expensive educational tools that they can borrow such as laptops, tablets, scientific calculators, etc. It  
fosters collaboration, resource-sharing, and equitable access to learning tools, empowering  students  
to overcome barriers and excel in their education.

## **II. Application of Object-Oriented Programming Principles**

### **1\. Encapsulation**

* **Implementation**: Each class encapsulates related data and behaviors, ensuring that the internal state of objects is accessible only through well-defined methods.  
  * Example: The User class encapsulates user details, such as name, email, school, and phone number, accessible through getter methods.

### **2\. Inheritance**

* **Implementation**: Inheritance can be extended in the future to define specialized user roles (e.g, administrators) or advanced item types.  
  * Example: Though not yet implemented, the design anticipates potential subclassing of **Item** or **User**.

### **3\. Polymorphism**

* **Implementation**: Polymorphism is used where methods like **getName**() or **isAvailable**() can be overridden in subclasses for customized behavior if extended.  
  * Example: Polymorphic designs enable different item categories or user types to behave differently.

### **4\. Abstraction**

* Implementation: Complex logic, such as borrowing penalties and item availability, is abstracted into separate methods and classes, hiding unnecessary details from the main program logic.  
  * Example: The **calculatePenalty**() method abstracts penalty computation logic.

## **Sustainable Development Goal \#4: Quality Education**

Focuses on ensuring equitable, inclusive and quality education for all. Promoting lifelong learning opportunities in which education is recognized as a key driver for reducing poverty, improving health, innovation, and advancing economic growth.

### **Integration of SDG 4 into SmartShare Project**

The **SmartShare Project** contributes directly to SDG 4 by facilitating access to essential educational tools, such as electronic gadgets, that are vital for modern learning. Here's how it aligns with SDG 4:

1. **Bridging the Digital Divide**  
   * The project ensures that students and learners have access to necessary gadgets   
   * This helps reduce inequalities in education by making technology more accessible to all.  
2. **Enhancing Learning Opportunities**  
   * Gadgets provided through the project support online learning, research, and assignments, thereby improving educational outcomes.  
   * Students can borrow tools for specific periods, allowing them to participate in digital or technology-enhanced learning activities.  
3. **Promoting Equitable Access**  
   * By offering a borrowing system, the project eliminates the financial burden of purchasing expensive devices for students who may only need them temporarily.  
   * It democratizes access to technology, ensuring that education is not hindered by economic disparities.  
4.  **Fostering Responsibility and Shared Learning**  
   * Through the borrowing system, users develop a sense of responsibility and community sharing, aligning with the broader values of SDG 4\.  
   * Encouraging responsible gadget usage ensures that more individuals can benefit from these tools over time.

### 

   

   ## 

   ## 

   ## **IV. Instructions for Running the Program**

   ### **1\. Prerequisites**

* **Java Development Kit (JDK):** Ensure that the latest version of the JDK is installed on your system.  
* **Integrated Development Environment (IDE):** A Java IDE like IntelliJ IDEA, Eclipse, or VS Code is recommended for running the program.

  ### **2\. Project Structure**

The project consists of the following files:

* **SmartShare.java**: Main application file.  
* **User.java**: Manages user details.  
* **Item.java**: Represents individual gadgets.  
* **BorrowRecord.java**: Tracks borrowing and returning transactions.

  ### **3\. Setup**

1. Clone or download the project files into a single directory.  
2. Open the directory in your preferred Java IDE.  
3. Ensure all files are in the same package or adjust the package structure accordingly.

   ### **4\. Running the Program**

1. Compile all .java files.  
2. Run the SmartShare.java file as the main program.  
3. Follow the on-screen menu prompts to register, borrow, view history, or return gadgets.

   ### **5\. Example Workflow**

1. **Register a User:**    
   * Enter your name, email, school, and phone number when prompted.  
2. **List Available Gadgets:**  
   * View a list of gadgets that are currently available for borrowing. Below are the gadgets that the user will see that are available:  
   * 1\. Laptop  
   * 2\. Tablet  
   * 3\. Scientific Calculator  
   * 4\. USB Flash Drive  
   * 5\. Power Bank  
   * 6\. Charger  
   * 7\. Printer  
       
3. **Borrow a Gadget:**  
   * Select a gadget, specify the borrowing duration, and confirm your action. You can choose your duration that will range from 1 day and the maximum is 30 days.  
4. **View Borrowing History:**  
   * Allows users to view their past borrowing records, including penalties or how much fine they will pay, depending on how long it takes for them to return the borrowed item.  
5. **Return a Gadget:**  
   * Select a borrowed item to return and view any applicable penalties.  
   * Late returns incur a penalty of **₱50** per day, with a maximum penalty of **₱1000**.  
   * Ensure accurate email input for tracking borrowing history.

   ###  6\.  **Exit**

* Exits the program.


  

