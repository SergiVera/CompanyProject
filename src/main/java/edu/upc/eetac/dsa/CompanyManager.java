package edu.upc.eetac.dsa;

import java.util.Date;
import java.util.List;

//We use an interface because we want the methods in another class
public interface CompanyManager{

    //Because it's an interface, we can only declare the methods.
    //By definition interface implements signatures not implementations of its methods
    public void addCompany(String companyName, String description);
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws CompanyNotFoundException;
    public List<Employee> findAllEmployeesOrderedByName();
    public List<Employee> findAllEmployeesOrderedBySalary();
    public List<Employee> employees(String company) throws CompanyNotFoundException;
    public List<Company> findAllCompanies();

}
