import java.util.*;

public class MapExamples {
    public static void main(String[] args) {

        Map<String, Integer> employeeSalaries = new HashMap<>();

        employeeSalaries.put("Alice", 70000);
        employeeSalaries.put("Bob", 85000);
        employeeSalaries.put("Charlie", 60000);
        employeeSalaries.put("Diana", 95000);

        System.out.println("=== HashMap Output (Unordered) ===");


        for (Map.Entry<String, Integer> entry : employeeSalaries.entrySet()) {
            System.out.println(entry.getKey() + " earns $" + entry.getValue());
        }

        System.out.println("\nUsing keySet():");
        for (String name : employeeSalaries.keySet()) {
            System.out.println(name + " earns $" + employeeSalaries.get(name));
        }

        System.out.println("\nUsing lambda:");
        employeeSalaries.forEach((name, salary) ->
                System.out.println(name + " earns $" + salary)
        );


        TreeMap<String, Integer> sortedSalaries = new TreeMap<>(employeeSalaries);

        System.out.println("\n=== TreeMap Output (Sorted by Employee Name) ===");
        for (Map.Entry<String, Integer> entry : sortedSalaries.entrySet()) {
            System.out.println(entry.getKey() + " earns $" + entry.getValue());
        }
    }
}
