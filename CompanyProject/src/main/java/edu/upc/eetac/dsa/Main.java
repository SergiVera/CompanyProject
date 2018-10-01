package edu.upc.eetac.dsa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // write your code here
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Company c = new Company();
        c.addCompany("UPC", "EETAC");
        c.addCompany("UPC2", "EETAC");
        c.addCompany("UPC3", "EETAC");
        try {
            c.addEmployee("name1", "name", new Date("18/01/1994"), 400, "UPC");

            c.addEmployee("name2", "name", new Date("18/01/1994"), 400, "UPC");

            c.addEmployee("name3", "name", new Date("18/01/1994"), 400, "UPC");

        } catch (MyException exc) {
            System.err.println("error al añadir employee");
        }


        for (Map.Entry<Integer, Company> entry : c.hashMapCompany.entrySet()) {
            Company c1 = entry.getValue();
            List<Employee> l1 = c1.getListEmployee();
                for (Employee e : l1) {
                    System.out.println("Name: " + e.getName() + "   Company:" + e.getCompanyName());
                }
            }


        }
    }

