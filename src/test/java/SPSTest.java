import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SPSTest {


    @Test
    public void testMap() {
        List<Integer> myList = new ArrayList<>();

        myList.add(1);
        myList.add(5);


        //define a type that we want to create
        List<String> myString = myList.stream()
                .map(x -> x.toString())
                .collect(Collectors.toList());

        List<String> expectedList = new ArrayList<>();

        expectedList.add("1");
        expectedList.add("5");

        assertNotEquals(myList, myString);
        assertEquals(expectedList, myString);
    }


    //static methods are not requiring an Object underneath
    // dont make Junit tests static

    @Test
    public void testFilter() {

//        List<Integer> mylist2 = new ArrayList<>();

        List<Integer> myList = Arrays.asList(1, 2, 3);

        List<Integer> filtered = myList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

//        List<Integer> expected = new ArrayList<>();

        List<Integer> expected = Arrays.asList(2);

        assertEquals(expected, filtered);

    }



    public List<Integer> fibonacci(Integer a, List<Integer> fibList) {

//        List<Integer> fibList = new ArrayList<>();

        // 0,1,1,2,3,5,8

        if (a == 0) {
            return fibList;
        } else if (a > 0 && fibList.size() == 0) {
            fibList.add(0, 0);
            a -= 1;
            fibonacci(a, fibList);
        } else if (a > 0 && fibList.size() == 1) {
            fibList.add(1, 1);
            a -= 1;
            fibonacci(a, fibList);
        } else {
            fibList.add(fibList.get(fibList.size() - 1) + fibList.get(fibList.size() - 2));
            a -= 1;
            fibonacci(a, fibList);
        }

        return fibList;

    }


    @Test
    public void testFib() {

        List<Integer> fibList = new ArrayList<>();

        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3);
        List<Integer> expected2 = Arrays.asList(0, 1, 1, 2);


        assertEquals(expected, fibonacci(5, fibList));

    }


    public static List<Person> createPersonsFromEmployees(List<Employee> employees) {

        List<Person> newPersons = employees.stream()
                .filter(Objects::nonNull)
                .map(e -> new Person(e.getFirstName(), e.getLastName(), e.getEmail()))
                .collect(Collectors.toList());

        System.out.println(newPersons.toString());
        return newPersons;
    }


    @Test
    public void mapObject() {


        List<Employee> employees = new ArrayList<>();

        Employee dave = new Employee("David", "Jones", 23, "224", "hello", 230.00);
        Employee Joe = new Employee("Joe", "Joe", 40, "34", "what", 240.00);
        Employee Matt = new Employee("Matt", "Matt", 89, "4", "you", 250.00);
        Employee Karen = new Employee("Karen", "Karen", 21, "5", "want", 260.00);

        employees.add(dave);
        employees.add(Joe);
        employees.add(Matt);
        employees.add(Karen);

        List<Person> expected = new ArrayList<>();

        Person dave1 = new Person("David", "Jones", "hello");
        Person Joe1 = new Person("Joe", "Joe", "what");
        Person Matt1 = new Person("Matt", "Matt", "you");
        Person Karen1 = new Person("Karen", "Karen", "want");

        expected.add(dave1);
        expected.add(Joe1);
        expected.add(Matt1);
        expected.add(Karen1);

        System.out.println(expected.toString());
        assertEquals(expected.toString(), createPersonsFromEmployees(employees).toString());
//        Assert.assertArrayEquals(expected.toArray(), createPersonsFromEmployees(employees).toArray());


    }

    public static List<Employee> filteredEmployees(List<Employee> employee) {

        List<Employee> filteredEmployeeList = employee.stream()
                //filter takes a predicate
                .filter(x -> x.getAge() >= 30)
                .collect(Collectors.toList());

        System.out.println(filteredEmployeeList.toString());
        return filteredEmployeeList;
    }

    @Test
    public void filterObject() {

        List<Employee> employees = new ArrayList<>();

        Employee dave = new Employee("David", "Jones", 23, "224", "hello", 230.00);
        Employee Joe = new Employee("Joe", "Joe", 40, "34", "what", 240.00);
        Employee Matt = new Employee("Matt", "Matt", 89, "4", "you", 250.00);
        Employee Karen = new Employee("Karen", "Karen", 21, "5", "want", 260.00);

        employees.add(dave);
        employees.add(Joe);
        employees.add(Matt);
        employees.add(Karen);

        List<Employee> expected = new ArrayList<>();
        expected.add(Joe);
        expected.add(Matt);

        assertEquals(expected.toString(), filteredEmployees(employees).toString());



    }


}