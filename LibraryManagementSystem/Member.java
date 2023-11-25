package LibraryManagementSystem;

class Member {
    private String name;
    private String libraryCardNumber;
    private int age;
    public Member(String name, String libraryCardNumber, int age) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", libraryCardNumber='" + libraryCardNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
