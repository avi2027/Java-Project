package EmplyeeManagementSystem;
import java.util.*;

// Abstract class representing an Employee
abstract class Employee {
    protected String name;
    protected int ID;
    protected String position;
    protected String email;
    protected String address;

    public Employee(String name, int ID, String position, String email, String address) {
        this.name = name;
        this.ID = ID;
        this.position = position;
        this.email = email;
        this.address = address;
    }

    // Abstract method to display employee details
    public abstract void displayDetails();

    // Getters and setters for employee fields (omitted for brevity)
}

// Admin class inheriting from Employee
class Admin extends Employee {
    public Admin(String name, int ID, String position, String email, String address) {
        super(name, ID, position, email, address);
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}

// Regular class inheriting from Employee
class Regular extends Employee {
    public Regular(String name, int ID, String position, String email, String address) {
        super(name, ID, position, email, address);
    }

    @Override
    public void displayDetails() {
        System.out.println("Regular Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}

// EmployeeManagementSystem class handling employee operations
class EmployeeManagementSystem {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add an employee
    public void addEmployee() {
        System.out.println("Enter Employee Type (Admin/Regular):");
        String type = scanner.nextLine();
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter Position:");
        String position = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        Employee employee;
        if (type.equalsIgnoreCase("Admin")) {
            employee = new Admin(name, ID, position, email, address);
        } else if (type.equalsIgnoreCase("Regular")) {
            employee = new Regular(name, ID, position, email, address);
        } else {
            System.out.println("Invalid employee type.");
            return;
        }

        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Method to view employee details
    public void viewEmployeeDetails() {
        System.out.println("Enter Employee ID:");
        int ID = scanner.nextInt();

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.ID == ID) {
                emp.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with ID: " + ID);
        }
    }

    // Method to remove an employee
    public void removeEmployee() {
        System.out.println("Enter Employee ID to remove:");
        int ID = scanner.nextInt();

        boolean removed = employees.removeIf(emp -> emp.ID == ID);
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found with ID: " + ID);
        }
    }

    // Method to update employee information (be Name, position, email, or address)
    public void updateEmployeeInfo() {
        System.out.println("Enter Employee ID to update:");
        int ID = scanner.nextInt();

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.ID == ID) {
                System.out.println("Enter updated Name:");
                emp.name = scanner.next();
                System.out.println("Enter updated Position:");
                emp.position = scanner.next();
                System.out.println("Enter updated Email:");
                emp.email = scanner.next();
                System.out.println("Enter updated Address:");
                emp.address = scanner.next();

                System.out.println("Employee information updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with ID: " + ID);
        }
    }

    // Method to exit the portal
    public void exitPortal() {
        System.out.println("Exiting Employee Portal. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    // Method to display menu options
    public void displayMenu() {
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("\tWeclome to the Employee Query");
            System.out.println("-------------------------------------");
            System.out.println("1. Add an Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Remove an Employee");
            System.out.println("4. Update Employee Info");
            System.out.println("5. Exit From The System");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetails();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    updateEmployeeInfo();
                    break;
                case 5:
                    exitPortal();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to start the system
    public void run() {
        displayMenu();
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.run();
    }
}
