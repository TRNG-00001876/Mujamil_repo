package org.example.model;

public class UserRegister
{
    private int id;
    private String name;
    private String gmail;
    private String password;

    public UserRegister(int id,String name,String gmail,String password)
    {
        this.id=id;
        this.name=name;
        this.gmail=gmail;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail()
    {
        return gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
