package PatientManagementSystem;

import java.util.ArrayList;
import java.util.List;
public class PatientManagement {
    private List<Patient> patients;
    public PatientManagement() {
        patients = new ArrayList<>();
    }
    public void registerPatient(String id, String name, String number, boolean isDischarge) {
        Patient newPatient = new Patient(id, name, number, isDischarge);
        patients.add(newPatient);
    }
    public Patient searchPatient(String idOrPhoneNumber) {
        for (Patient p : patients) {
            if (p.getId().equals(idOrPhoneNumber) || p.getNumber().equals(idOrPhoneNumber)) {
                return p;
            }
        }
        return null;
    }
    public void dischargePatient(String idOrPhoneNumber) {
        Patient patientToDischarge = searchPatient(idOrPhoneNumber);


        if (patientToDischarge != null) {
            patientToDischarge.setDischarge(true);
            System.out.println("Patient " + patientToDischarge.getName() + " has been discharged successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
    public List<Patient> getUndischargedPatients() {
        List<Patient> undischargedPatients = new ArrayList<>();
        for (Patient p : patients) {
            if (!p.isDischarge()) {
                undischargedPatients.add(p);
            }
        }
        return undischargedPatients;
    }
    public List<Patient> getDischargedPatients() {
        List<Patient> dischargedPatients = new ArrayList<>();
        for (Patient p : patients) {
            if (p.isDischarge()) {
                dischargedPatients.add(p);
            }
        }
        return dischargedPatients;
    }
    public List<Patient> getAllPatients() {
        return patients;
    }
}

