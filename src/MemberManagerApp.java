import java.util.*;


class Member {
    protected int id;
    protected String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Member ID: " + id + ", Name: " + name);
    }

    public int getId() {
        return id;
    }
}

class GraduateMember extends Member {
    private String researchTopic;

    public GraduateMember(int id, String name, String researchTopic) {
        super(id, name);
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayInfo() {
        System.out.println("Graduate ID: " + id + ", Name: " + name + ", Research: " + researchTopic);
    }
}

public class MemberManagerApp {
    static List<Member> members = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Member Manager ---");
            System.out.println("1. Add Member");
            System.out.println("2. Add Graduate Member");
            System.out.println("3. List Members");
            System.out.println("4. Remove Member");
            System.out.println("5. Search by ID");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addMember();
                    case 2 -> addGraduateMember();
                    case 3 -> listMembers();
                    case 4 -> removeMember();
                    case 5 -> searchMember();
                    case 6 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private static void addMember() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            members.add(new Member(id, name));
            System.out.println("Member added.");
        } catch (Exception e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    private static void addGraduateMember() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter research topic: ");
            String research = scanner.nextLine();

            members.add(new GraduateMember(id, name, research));
            System.out.println("Graduate member added.");
        } catch (Exception e) {
            System.out.println("Error adding graduate member: " + e.getMessage());
        }
    }

    private static void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
        } else {
            for (Member m : members) {
                m.displayInfo();
            }
        }
    }

    private static void removeMember() {
        try {
            System.out.print("Enter ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean removed = members.removeIf(m -> m.getId() == id);

            if (removed) {
                System.out.println("Member removed.");
            } else {
                System.out.println("Member with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID input.");
        }
    }

    private static void searchMember() {
        try {
            System.out.print("Enter ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean found = false;

            for (Member m : members) {
                if (m.getId() == id) {
                    m.displayInfo();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Member not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}
