package PatientManagementSystem;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PatientManagement patientManagement = new PatientManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Discharge Patient");
            System.out.println("4. Display Undischarged Patients");
            System.out.println("5. Display Discharged Patients");
            System.out.println("6. Display All Patients");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient number: ");
                    String number = scanner.nextLine();
                    System.out.print("Is the patient discharged? (true/false): ");
                    boolean isDischarge = scanner.nextBoolean();


                    patientManagement.registerPatient(id, name, number, isDischarge);
                    System.out.println("Patient registered successfully.");
                    break;
                case 2:
                    System.out.println("Enter patient ID or phone number:");
                    String idOrPhoneNumber = scanner.nextLine();
                    Patient patient = patientManagement.searchPatient(idOrPhoneNumber);
                    if (patient != null) {
                        System.out.println("Patient found:");
                        System.out.println(patient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                case 3:
                    System.out.print("Enter patient ID or number to discharge: ");
                    String dischargeIdOrNumber = scanner.nextLine();
                    patientManagement.dischargePatient(dischargeIdOrNumber);
                    break;
                case 4:
                    List<Patient> undischargedPatients = patientManagement.getUndischargedPatients();
                    displayPatients("Undischarged Patients", undischargedPatients);
                    break;


                case 5:
                    List<Patient> dischargedPatients =patientManagement.getDischargedPatients();
                    displayPatients("Discharged Patients", dischargedPatients);
                    break;
                case 6:
                    List<Patient> allPatients = patientManagement.getAllPatients();
                    displayPatients("All Patients", allPatients);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    private static void displayPatients(String title, List<Patient> patients) {
        System.out.println(title);
        if (patients.isEmpty()) {
            System.out.println("No patients to display.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

