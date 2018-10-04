package edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;

public class CompanyeManagerTest {

    //Logger
    final static Logger log = Logger.getLogger(CompanyeManagerTest.class.getName());

    //We have to create and object of type CompanyManager, for then use its methods
    private CompanyManager cm;

    //Before the tests we have to add Employees and Companies
    @Before
    public void setUp() {
        //Because MyManager implements CompanyManager, we can create on top of cm, new MyManager
        this.cm = new MyManager();
        //Add companies
        this.cm.addCompany("UPC", "La UPC");
        this.cm.addCompany("SEAT", "SEAT MARTORELL");
        this.cm.addCompany("AMAZON", "Amazon BCN");

        //Because addEmployee can throw an exception, we may provide it with try and catch (in catch we will use log4j)
        try {
            this.cm.addEmployee("Sergi", null,null, 1500.56, "SEAT");
            this.cm.addEmployee("Meritxell", null,null, 5000, "SEAT");
            this.cm.addEmployee("Paula", null,null, 1400, "AMAZON");
            this.cm.addEmployee("Hector", null,null, 10000, "AMAZON");
            this.cm.addEmployee("Hector", null,null, 10000, "PP");

        }
        catch (CompanyNotFoundException e) {
            log.warn("El employee que ha intentado introducir trabaja en una empresa la cual no existe: " +e.getMessage());
        }
    }

    //When the test ends, it's properly to erase the contents added in @Before
    @After
    public void tearDown(){
        this.cm = null;
    }

    //We will verify if we add the employees properly (this time without an exception)
    @Test
    public void addEmployee(){
        try {
            //Create three new employees
            this.cm.addEmployee("Georgios", null,null, 1000, "SEAT");
            this.cm.addEmployee("Avdelas", null,null, 1000, "SEAT");
            this.cm.addEmployee("Laia", null,null, 1000, "AMAZON");
            this.cm.addEmployee("Laia", null,null, 1000, "AXX");


            List<Employee> employeeList=this.cm.employees("AMAZON");

            assertEquals(employeeList.get(0).getName(), "Paula");
            assertEquals(employeeList.get(1).getName(), "Hector");
            assertEquals(employeeList.get(2).getName(), "Laia");

            employeeList=this.cm.employees("SEAT");

            assertEquals(employeeList.get(0).getName(), "Sergi");
            assertEquals(employeeList.get(1).getName(), "Meritxell");
            assertEquals(employeeList.get(2).getName(), "Georgios");
            assertEquals(employeeList.get(3).getName(), "Avdelas");
        }
        catch (CompanyNotFoundException me) {
            log.warn("El employee que ha intentado introducir trabaja en una empresa la cual no existe: " +me.getMessage());
        }

    }

    //We will test the CompanyNotFoundException
    @Test (expected = CompanyNotFoundException.class)
    public void addEmployeeAndCompanyNotFound() throws CompanyNotFoundException {
        //We will throw an error, because the company "XXXXXXXXXX" doesn't exist
        this.cm.addEmployee("user!!!", null,null, 1000, "XXXXXXXXX");

    }

    //We will test if the Employees are ordered by name properly
    @Test
    public void findAllEmployeesOrderedByName(){
        List<Employee> esort = this.cm.findAllEmployeesOrderedByName();

        assertEquals(esort.get(0).name, "Hector");
        assertEquals(esort.get(1).name, "Meritxell");
        assertEquals(esort.get(2).name, "Paula");
        assertEquals(esort.get(3).name, "Sergi");
    }

    //We will test if the Employees are ordered by salary properly
    @Test
    public void findAllEmployeesOrderedBySalary(){
        List<Employee> esort = this.cm.findAllEmployeesOrderedBySalary();

        assertEquals(esort.get(0).salary, 1400, 0);
        assertEquals(esort.get(1).salary, 1500.56, 0);
        assertEquals(esort.get(2).salary, 5000, 0);
        assertEquals(esort.get(3).salary, 10000, 0);

    }

    //We will test if it return the all companies
    @Test
    public void findAllCompanies(){
        List<Company> allcompanies = this.cm.findAllCompanies();

        assertEquals(allcompanies.get(0).companyName, "AMAZON");
        assertEquals(allcompanies.get(1).companyName, "SEAT");
        assertEquals(allcompanies.get(2).companyName, "UPC");
    }

    //We will test if we obtain properly the employees that work on indicated company
    @Test
    public void employees(){
        List<Employee> e = this.cm.employees("SEAT");

        assertEquals(e.get(0).name, "Sergi");
        assertEquals(e.get(1).name, "Meritxell");
    }


}
