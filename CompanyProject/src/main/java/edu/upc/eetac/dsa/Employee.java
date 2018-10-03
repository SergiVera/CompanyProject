package edu.upc.eetac.dsa;

import java.util.Date;
import java.util.List;

public class Employee{
    private String name;
    private String username;
    private Date birthday;
    private double salary;
    private String companyName;

    public Employee(String name, String username, Date birthday, double salary, String companyName) {
        this.name = name;
        this.username = username;
        this.birthday = birthday;
        this.salary = salary;
        this.companyName = companyName;
    }

    public Employee(){}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
