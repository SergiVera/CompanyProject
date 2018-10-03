package edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import static org.junit.Assert.*;

public class CompanyTest {

    final static Logger logger = Logger.getLogger(CompanyTest.class);
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCompanyName() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Company c = new Company();
            c.addCompany("UPC", "EETAC");
            c.addCompany("UPC2", "EETAC");
            c.addCompany("UPC3", "EETAC");

            try {
                c.addEmployee("EDU", "name", new Date("18/01/1994"), 1100, "UPC");

                c.addEmployee("TONI", "name", new Date("18/01/1994"), 800, "UPC2");

                c.addEmployee("CARLOS", "name", new Date("18/01/1994"), 10000, "UPC3");

            } catch (MyException exc) {
                System.err.println("error al añadir employee");
            }

            System.out.println("Employees in UPC company");
            List<Employee> l0 = c.employees("UPC");
            for(Employee emp:l0){
                System.out.println("- "+emp.getName());
            }

            System.out.println("Employees ordered by Name");
            List<Employee> l = c.findAllEmployeesOrderedByName();
            for(Employee emp:l){
                System.out.println(emp.getName());
            }
            System.out.println("Employees ordered by Salary");
            List<Employee> l2 = c.findAllEmployeesOrderedBySalary();
            for(Employee emp:l2){
                System.out.println(emp.getName() +"  has a salary of : "+ emp.getSalary());
            }
            System.out.println("Companies");
            List<Company> l3 = c.findAllCompanies();
            for(Company com:l3){
                System.out.println("Name:"+com.getCompanyName()+" Description: "+com.getDescription());
            }
        }catch(Exception e){
            logger.error("something went wrong",e);
        }

    }
}