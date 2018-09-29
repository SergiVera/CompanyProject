package edu.upc.eetac.dsa;

import java.util.Date;

public abstract class Employee implements CompanyManager{

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
}
