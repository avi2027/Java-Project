package PatientManagementSystem;
public class Patient {
    public String id;
    public String name;
    public String number;
    public boolean isDischarge;
    public Patient(String id, String name, String number, boolean isDischarge) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.isDischarge = isDischarge;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public boolean isDischarge() {
        return isDischarge;
    }
    public void setDischarge(boolean isDischarge) {
        this.isDischarge = isDischarge;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", isDischarge=" + isDischarge +
                '}';
    }
}

