package edu.upc.eetac.dsa;

import java.util.Date;
import java.util.List;

public interface CompanyManager {

    //Method addCompany
    public void addCompany(String companyName, String description);
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws MyException;
    public List<Employee> findAllEmployeesOrderedByName();
    public List<Employee> findAllEmployeesOrderedBySalary();
    public List<Employee> employees(String company);
    public List<Company> findAllCompanies();

}
