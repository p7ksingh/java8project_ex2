package com.java8.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
}
