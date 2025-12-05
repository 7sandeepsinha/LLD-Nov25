package advancedConcepts.steamsAndLambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //Given a list of numbers, take the even and  square them || FILTERING AND MAPPING
        List<Integer> evenSquares = l1.stream() //creates the stream
                .filter((n) ->  n % 2 == 0)   // filters odd and even numbers || intermediate
                .map((n) -> n*n) // squares the numbers || intermediate
                .toList(); // collecting stream to a list || terminal
        System.out.println(evenSquares);

        //Given a list of numbers, find their sum || REDUCTION
        int sum = l1.stream().reduce(0, (t,n) -> t + n);
        System.out.println(sum);

        List<Employee> employees = Arrays.asList(
                new Employee("Raju", 10000, "IT"),
                new Employee("Ashwin", 20000, "HR"),
                new Employee("Aditya", 25000, "IT"),
                new Employee("Taahaa", 17000, "HR"),
                new Employee("Arpit", 35000, "MANAGEMENT")
        );

        //Find the name of employees earning more than 18000
        List<String> empNames = employees.stream()
                .filter((emp) -> emp.salary > 18000)
                .map((emp) -> emp.name)
                .toList();
        System.out.println(empNames);

        //Create a map of employee department with any employee from that department || Map<String, String>
//        Map<String, String> deptMap = employees.stream()
//                .collect(Collectors.groupingBy(
//                        (emp) -> emp.dept,
//                        (emp) -> emp.name,
//                        (oldValue, newValue) -> oldValue
//                ));

        //Group the employee names by their departments || Map<String, List<String>> < IT, <E1, E2>>
        Map<String, List<String>> empDeptMap = employees.stream()
                .collect(Collectors.groupingBy(
                        (emp) -> emp.dept, // generating the key entry
                        Collectors.mapping((emp) -> emp.name, Collectors.toList())  // generating the value entry
                ));
        System.out.println(empDeptMap);

        //generating a flat map
        List<List<Integer>> nestedList = List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap( (list) -> list.stream() )
                .toList();
        System.out.println(flatList);










    }


    public void filter(int n){
        if(n%2 == 0){
            System.out.println("Keep N ");
        } else {
            System.out.println("Reject N ");
        }
    }

    public int map(int n){
        return n*n;
    }
}
/*
        Pass function as a parameter to another function

        Map<String, List<String>>
        "HR" -> [ "Ashwin", "Taahaa" ]

       Raju ->

       <    <IT, [Raju]


       >

       //Time - 9 mins - 10:03 PM
       //Given a list of integers, find the second largest distinct number using Streams.
       //Given a list of integers, count how many are prime numbers
       //Given a list of integers, return all values that occur more than once

 */
