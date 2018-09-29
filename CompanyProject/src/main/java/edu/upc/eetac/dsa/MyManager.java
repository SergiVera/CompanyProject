package edu.upc.eetac.dsa;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class MyManager implements CompanyManager {
    public void addCompany(String companyName, String description){
        //poner las compañias en un HashMap
    }
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws MyException{
        //poner en una lista para cada compañia
    }
    public List<Employee> findAllEmployeesOrderedByName(){
        //return List
        List<Employee> l = new LinkedList<Employee>();
        return l;
    }
    public List<Employee> findAllEmployeesOrderedBySalary(){
        List<Employee> l = new LinkedList<Employee>();
        return l;
    }
    public List<Employee> employees(String company){
        List<Employee> l = new LinkedList<Employee>();
        return l;
    }
    public List<Company> findAllCompanies(){
        List<Company> l = new LinkedList<Company>();
        return l;
    }
}
