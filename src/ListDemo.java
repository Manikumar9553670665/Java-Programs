import java.util.*;
class Student1 {
    int id;
    String name;
    double grade;

    Student1(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + grade + "}";
    }
}
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        System.out.println("Original list: " + numbers);
        numbers.remove(Integer.valueOf(5));
        System.out.println("After removing 5: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted list: " + numbers);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + ", Min: " + min);

        Collections.reverse(numbers);
        System.out.println("Reversed list: " + numbers);

        List<Student1> students = new ArrayList<>();
        students.add(new Student1(101, "Alice", 88.5));
        students.add(new Student1(102, "Bob", 91.2));
        students.add(new Student1(103, "Charlie", 79.8));

        System.out.println("\nList of Students:");
        for (Student1 s : students) {
            System.out.println(s);
        }
    }
}
