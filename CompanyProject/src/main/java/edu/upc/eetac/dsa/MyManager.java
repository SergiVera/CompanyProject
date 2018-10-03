package edu.upc.eetac.dsa;

import java.util.*;
import java.util.List;
import java.util.LinkedList;



public abstract class MyManager implements CompanyManager {
    protected HashMap<String,Company> hashMapCompany = new HashMap<String, Company>();
    protected List<Employee> listAllEmployee = new LinkedList<Employee>();


    public void addCompany(String companyName, String description){
        //poner las compañias en un HashMap
        Company c = new Company(companyName, description);
        hashMapCompany.put(companyName,c);

    }
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws MyException{
        //poner en una lista para cada compañia
        //log.info()
        Employee e = new Employee(name,username,birthday,salary,companyName);


        Company company = hashMapCompany.get(companyName);
        if (company == null) throw new MyException();
        else {
            List<Employee> l = company.getListEmployee();
            l.add(e);
            hashMapCompany.get(companyName).setListEmployee(l);
            listAllEmployee.add(e);
        }
    }
    public List<Employee> findAllEmployeesOrderedByName(){
        //return List
        List<Employee> l = new LinkedList<Employee>();
        for(Employee emp:listAllEmployee){
            l.add(emp);
        }
        Collections.sort(l,new SortbyName());

        return l;
    }
    public List<Employee> findAllEmployeesOrderedBySalary(){

        List<Employee> l = new LinkedList<Employee>();
        for(Employee emp:listAllEmployee){
            l.add(emp);
        }
        Collections.sort(l,new SortbySalary());
        return l;
    }
    public List<Employee> employees(String company){

        Company c = this.hashMapCompany.get(company);
        List<Employee> emp = c.getListEmployee();

        return emp;

    }
    public List<Company> findAllCompanies(){
        List<Company> l = new LinkedList<Company>();
        //recorremos el hashmap para encontrar las compañias y las ponemos en una list
        hashMapCompany.forEach((k,v) ->l.add(hashMapCompany.get(k)));
        return l;
    }
}



class SortbySalary implements Comparator<Employee> {
    // Used for sorting in ascending order of
    // Area number
    public int compare(Employee a, Employee b)
    {
        double comp = a.getSalary()-b.getSalary();
        return (int)comp;
    }
}
class SortbyName implements Comparator<Employee> {
    // Used for sorting in ascending order of
    // Area number
    public int compare(Employee a, Employee b)
    {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}