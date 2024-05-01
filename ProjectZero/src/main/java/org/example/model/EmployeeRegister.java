package org.example.model;

public class EmployeeRegister {
    private int id;
    private String companyName;
    private String gmail;
    private String password;

    public EmployeeRegister(int id, String companyName, String gmail, String password) {
        this.id = id;
        this.companyName = companyName;
        this.gmail = gmail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
