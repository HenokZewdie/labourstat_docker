package com.restapi.laborstats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Tests {
    public static void main(String[] args) {
        List<Employee> response = getEmployees();
        //Compare by firstName then by lastName. If we don't use "thenComparing", it will maintain insertion (Zhopra then Tesfaye)
        List<Employee> employeeList = response.parallelStream().sorted(Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName)).collect(Collectors.toList());
        employeeList.forEach(a->System.out.println(a.getFirstName().concat(" ").concat(a.getLastName())));
        //employeeList.stream().forEach(a->System.out.println(a.getFirstName().concat(" ").concat(a.getLastName())));

        Integer maxAge = response.stream()
                .map(Employee::getAge).collect(Collectors.toList())
                .stream()
                .max(Integer::compareTo).orElse(-1);
        System.out.println(maxAge);



    }
    private static List<Employee> getEmployees(){
        List<Employee> employees  = new ArrayList<>();
        employees.add(new Employee(6,"Yash", "Zhopra", 25));
        employees.add(new Employee(11,"Yash", "Tesfaye", 35));
        employees.add(new Employee(2,"Aman", "Sharma", 28));
        employees.add(new Employee(3,"Aakash", "Yaadav", 52));
        employees.add(new Employee(5,"David", "Kameron", 19));
        employees.add(new Employee(4,"James", "Hedge", 72));
        employees.add(new Employee(8,"Balaji", "Subbu", 88));
        employees.add(new Employee(7,"Karan", "Johar", 59));
        employees.add(new Employee(1,"Lokesh", "Gupta", 32));
        employees.add(new Employee(9,"Vishu", "Bissi", 33));
        employees.add(new Employee(10,"Lokesh", "Ramachandran", 60));
        return employees;
    }
}
