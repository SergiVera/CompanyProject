package edu.upc.eetac.dsa;

import java.util.*;
import java.util.List;
import java.util.LinkedList;


public abstract class MyManager implements CompanyManager {
    protected HashMap<Integer,Company> hashMapCompany = new HashMap<Integer, Company>();
    protected List<Employee> listEmployee = new LinkedList<Employee>();


    public void addCompany(String companyName, String description){
        //poner las compañias en un HashMap
        Company c = new Company(companyName, description);
        this.hashMapCompany.put(MathUtils.GenerateRandom(5,100),c);
    }
    public void addEmployee(String name, String username, Date birthday, double salary, String companyName) throws MyException{
        //poner en una lista para cada compañia
        Employee e = new Employee(name,username,birthday,salary,companyName);

        for (Map.Entry<Integer, Company> entry : this.hashMapCompany.entrySet()) {
            if(companyName.equals(this.hashMapCompany.get(entry.getKey()).getCompanyName())){
                List<Employee> l = this.hashMapCompany.get(entry.getKey()).getListEmployee();
                l.add(e);
                Company c = this.hashMapCompany.get(entry.getKey());
                c.setListEmployee(l);
                this.hashMapCompany.remove(entry.getKey());
                this.hashMapCompany.put(entry.getKey(),c);
            }
            //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
        if(companyName==null) throw new MyException();

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

class MathUtils{
    public static int GenerateRandom(int min,int max){
        return min + (int)((Math.random() * ((max - min) + 1)));
    }
}