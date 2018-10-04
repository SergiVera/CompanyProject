package edu.upc.eetac.dsa;

import java.util.Date;

//This class implements a Comparable of Employee, like we did in the previous exercise about Figures
//We need this Comparable to return allemployeesorderedbySalary and allemployeesorderedbyName
public class Employee implements Comparable<Employee>{

    //Attributes
    String name, username, companyName;
    Date birthday;
    double salary;

    //Constructor

    public Employee(String name, String username, String companyName, Date birthday, double salary) {
        this.name = name;
        this.username = username;
        this.companyName = companyName;
        this.birthday = birthday;
        this.salary = salary;
    }

    //Method
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

    //We have to implement this compareTo to return the name that we will use later in MyManager class
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
