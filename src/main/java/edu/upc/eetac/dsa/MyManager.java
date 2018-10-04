package edu.upc.eetac.dsa;

import java.util.*;


public  class MyManager implements CompanyManager {

    //Initialize the linkedlist of employees
    private List<Employee> employees = new LinkedList<Employee>();

    //Initialize the hashmap(key: integer; value: Company) of companies
    private HashMap<String, Company> companies = new HashMap<String, Company>();

    //Add a company
    public void addCompany(String companyName, String description) {
        companies.put(companyName, new Company(companyName, description));
    }

    //Add an employee(We have to add the paramaters in order by type. In my case I've ordered first Strings, then Dates and finally doubles)
    //This method has to throw an Exception for one reason: if the Employee that we want to add, its company doesn't exist
    //in the HashMap, it has to throw an Exception, saying that the company doesn't exist. If the company exist,
    //we will add an Employee normally.
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws CompanyNotFoundException {
        //First we have to obtain the value of the especified key, which is the companyName. If the value is null, we have to throw an exception
        Company theCompany = this.companies.get(companyName);
        if (theCompany==null) throw new CompanyNotFoundException();

        //If it isn't null, we have to add it
        Employee e = new Employee(name, username, companyName, birthday, salary);
        this.employees.add(e);
        theCompany.addEmployee(e);
    }

    //Find all employees in the linkedlist and show them ordered by Name(Ascending or descending)
    public List<Employee> findAllEmployeesOrderedByName(){
        //We want to create a copy of the actual list of Employees, because it will be better not to modify the list.
        List<Employee> ret = new LinkedList<Employee>();
        ret.addAll(this.employees);
        //This method sort, by default sort the strings in ascending order. We don't have to create an especific function to order these names
        Collections.sort(ret);

        return ret;
    }

    //Find all employees in the linkedlist and show them ordered by salaray(Ascending or descending)
    public List<Employee> findAllEmployeesOrderedBySalary() {
        //Again we will create a copy of the list
        List<Employee> ret = new LinkedList<Employee>();
        ret.addAll(this.employees);

        //As we did in figures, we have to tell to the sort method, which criteria has to apply
        Collections.sort(ret, new Comparator<Employee>() {
            //Function to compare the salary
            public int compare(Employee o1, Employee o2) {
                return (int)(o1.getSalary()-o2.getSalary());
            }
        });

        return ret;
    }

    //Show all the employees in the linkedlist given a company name
    public List<Employee> employees(String company) throws CompanyNotFoundException{
        List<Employee> employees=null;

        //We want theCompany value, given a company entered by the user
        Company theCompany = this.companies.get(company);
        if (theCompany!=null) {
            employees = theCompany.employees();
        }
        else throw new CompanyNotFoundException();

        return employees;
    }

    //Show all the companies in the hashmap
    public List<Company> findAllCompanies() {
        //We have to cast the value
        List<Company> c = new LinkedList<Company>();

        //By default they will add the values in alphabetical order
        c.addAll(this.companies.values());

        return c;
    }
}
