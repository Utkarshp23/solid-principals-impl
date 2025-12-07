package com.solid.quick_shop.d2d;

import java.util.ArrayList;
import java.util.List;

public final class Department {
    private final long id;
    private final String name;
    private final List<String> employeeNames;

    public Department(long id, String name, List<String> employeeNames){
        this.id = id;
        this.name= name;
        this.employeeNames = List.copyOf(employeeNames);
    }

    public long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }

    public List<String> getEmployeeNames(){
        return employeeNames;
    }


    public static void main(String[] args) {
        List<String> employees = new ArrayList<>(List.of("Utkarsh","Rushiraj","Akshay","Vaibhav"));
        long id1 = 1;
        String deptName1 = "IT";
        
        Department dept = new Department(id1,deptName1,employees);

        System.out.println("First View:");
        System.out.println("dept:"+dept.getId()+" | "+dept.getName()+" | "+dept.getEmployeeNames());

        id1 = 2;
        deptName1 = "Finance";
        employees.add("Rahul");

        System.out.println("Second View:");
        System.out.println("dept:"+dept.getId()+" | "+dept.getName()+" | "+dept.getEmployeeNames());

        System.out.println("Third View:");
        dept.getEmployeeNames().add("Rakesh");
        System.out.println("dept:"+dept.getId()+" | "+dept.getName()+" | "+dept.getEmployeeNames());

        
    }
}
