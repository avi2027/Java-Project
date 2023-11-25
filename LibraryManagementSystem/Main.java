package LibraryManagementSystem;


import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register Member");
            System.out.println("2. Display All Members");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter library card number: ");
                    String libraryCardNumber = scanner.nextLine();
                    System.out.print("Enter member age: ");
                    int age = scanner.nextInt();
                    library.registerMember(name, libraryCardNumber, age);
                    break;
                case 2:
                    List<Member> allMembers = library.getAllMembers();
                    displayMembers(allMembers);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    private static void displayMembers(List<Member> members) {
        System.out.println("All Members:");
        if (members.isEmpty()) {
            System.out.println("---------------");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
}
