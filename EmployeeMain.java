package com.java8.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        // Q1.Find out the count of male and female employees present in the
        // organization?
        // mathod1(employeeList);
        // Q2. Write a program to print the names of all departments in the
        // organization.
        // mathod2(employeeList);
        // Q3. Find the average age of Male and Female Employees.
        // mathod3(employeeList);
        // Q4. Get the Names of employees who joined after 2015.
        // method4(employeeList);
        // Q5. Count the number of employees in each department.
        // method5(employeeList);
        // Q6. Find out the average salary of each department.
        // method6(employeeList);
        // Q7. Find out the oldest employee, his/her age and department?
        // method7(employeeList);
        // Q8. Find out the average and total salary of the organization.
        method8(employeeList);
    }

    private static void method8(List<Employee> employeeList) {
        DoubleSummaryStatistics collect = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("avgSalary: " + collect.getAverage());
        System.out.println("totalSalary: = " + collect.getSum());
    }

    private static void method7(List<Employee> employeeList) {
        Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(employee);
        System.out.println(employee.getAge() + "/" + employee.getDepartment());

    }

    private static void method6(List<Employee> employeeList) {
        Map<String, Double> salavg = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(salavg);
    }

    private static void method5(List<Employee> employeeList) {
        Map<String, Long> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);
    }

    private static void method4(List<Employee> employeeList) {
        List<String> list = employeeList.stream().filter(dt -> dt.getYearOfJoining() > 2015)
                .map(dt -> dt.getName()).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void mathod3(List<Employee> employeeList) {
        Map<String, Double> avgAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAge);
    }

    private static void mathod2(List<Employee> employeeList) {
        List<String> depList = employeeList.stream().map(Employee::getDepartment).collect(Collectors.toList());
        System.out.println(depList);
    }

    private static void mathod1(List<Employee> employeeList) {
        Map<String, Long> gender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(gender);
    }
}
