package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class ListEmployee {
    private List<Employee> employees;

    public ListEmployee() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void generate_sample_dataset()
    {
        Employee e1 = new Employee();
        e1.setEmail("john@gmail.com");
        e1.setUsername("johnny");
        e1.setPassword("12345678");
        e1.setName("Johnny");
        employees.add(e1);

        Employee e2 = new Employee();
        e1.setEmail("mark@gmail.com");
        e1.setUsername("urmark");
        e1.setPassword("9999");
        e1.setName("MarkLee");
        employees.add(e2);

        Employee e3 = new Employee();
        e1.setEmail("ten@gmail.com");
        e1.setUsername("tenlee");
        e1.setPassword("2702");
        e1.setName("TenLee");
        employees.add(e3);
    }
}
