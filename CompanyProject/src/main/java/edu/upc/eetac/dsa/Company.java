package edu.upc.eetac.dsa;

import java.util.LinkedList;
import java.util.List;

public class Company extends MyManager {
    private String companyName;
    private String description;
    private List<Employee> listEmployee = new LinkedList<Employee>();

    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }
    public Company(){}

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
}
