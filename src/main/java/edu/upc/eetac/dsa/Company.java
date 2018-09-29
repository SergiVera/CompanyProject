package edu.upc.eetac.dsa;

import java.util.LinkedList;
import java.util.List;

public abstract class Company implements CompanyManager{

    //Attributes
    String companyName, description;

    //Constructor

    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }

    //Methods
    public void addCompany(String companyName, String description) {

    }
}
