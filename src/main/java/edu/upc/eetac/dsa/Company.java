package edu.upc.eetac.dsa;

import java.util.LinkedList;
import java.util.List;

public class Company{

    //Attributes
    String companyName, description;
    private List<Employee> employees;

    //Constructor

    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
        //Like we do always in a constructor, it's necessary implements all the attributes
        //Even though if it's a List(Any DataStructure)
        this.employees=new LinkedList<Employee>();
    }

    //Methods

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    //We have to return the employee list, because we want to clone the list in MyManager class
    //to have a copy of the employees to return the list in the method findAllEmployees*

    public List<Employee> employees() {
        return this.employees;
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }
}
