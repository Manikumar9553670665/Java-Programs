class Person{
    protected String name;
    protected int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
class Employee extends Person{
    private String jobTitle;
    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Job Title: " + jobTitle);
    }
}
class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Major: " + major);
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Employee emp = new Employee("Mani", 26, "Software Engineer");
        Student stu = new Student("kevin", 20, "Computer Science");

        emp.displayDetails();
        System.out.println();
        stu.displayDetails();
    }
}
