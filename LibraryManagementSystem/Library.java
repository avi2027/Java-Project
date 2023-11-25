package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
public class Library {
    private List<Member> members;
    public Library() {
        members = new ArrayList<>();
    }
    public void registerMember(String name, String libraryCardNumber, int age) {
        if (age >= 12) {
            Member newMember = new Member(name, libraryCardNumber, age);
            members.add(newMember);
            System.out.println("Successfully");
        } else {
            System.out.println("Sorry, :) Age boro hou");
        }
    }
    public List<Member> getAllMembers() {
        return members;
    }
}
