import java.util.*;
import java.util.stream.Collectors;


public class EmployeesExample {


    public static void main(String []args)
    {

        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        //filter the employees that have salary> 900 euros and live in Skopje
        //show them grouped by their working position

        //Exercise 1 --Find a number of employees that live in Bitola and have salary greater than 800e
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Exercise 1 --Find a number of employees that live in Bitola and have salary greater than 800euro.\n");

        Map<String,List<Employee>> map=employeeList.stream()
            .filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800)
            .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println(map.entrySet()
            .stream()
            .map(entry->entry.getKey()+" - "+entry.getValue().toString())
            .collect(Collectors.joining("\n","","\n")));

        long numEmp = employeeList.stream().filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800).count(); //you can use this also //.collect(Collectors.toList()).size();

        System.out.println("Result:------\n");
        System.out.println("The number of workers who live in Bitola and have salary grater than 800 euros is: " + numEmp );
        System.out.println("\n");
        System.out.println("\n");


        //Exercise 2 --Calculate the sum of the salaries of all employees who live in Skopje.
        System.out.println("Exercise 2 --Calculate the sum of the salaries of all employees who live in Skopje.\n");
        Map<String,List<Employee>> mapSk=employeeList.stream()
                .filter(employee -> employee.getCity().equals("Skopje"))
                .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println(mapSk.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));

        int salary = employeeList.stream().filter(employee -> employee.getCity().equals("Skopje")).map(employee -> employee.getSalary()).collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Result:------\n");
        System.out.println("The sum of salary from employees who live in Skopje is: " + salary );
        System.out.println("\n");
        System.out.println("\n");

        //Exercise 3 --Show the employees sorted by salaries in ascending order.

        System.out.println("Exercise 3 --Show the employees sorted by salaries in ascending order.\n");

        Map<String,List<Employee>> mapEmp=employeeList.stream().sorted((o1, o2) -> o1.getSalary()>o2.getSalary()? 1:-1)
                .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println("Result:------\n");

        System.out.println(mapEmp.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));

        System.out.println("\n");
        System.out.println("\n");


        //Exercise 4 --Find the employee who lives in Skopje and has the largest salary. (bonus question)

        System.out.println("Exercise 4 --Find the employee who lives in Skopje and has the largest salary. (bonus question)\n");

        System.out.println(mapSk.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));

        Employee emp = employeeList.stream().filter(employee -> employee.getCity().equals("Skopje")).max((o1, o2) -> o1.getSalary()>o2.getSalary()?1:-1).get();

        System.out.println("Result:------\n");

        System.out.println(emp.toString());


    }
}

