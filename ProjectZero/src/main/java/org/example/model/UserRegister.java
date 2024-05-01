package org.example.model;

public class UserRegister
{
    private String name;
    private String gmail;
    private String password;

    public UserRegister(String name,String gmail,String password)
    {
        this.name=name;
        this.gmail=gmail;
        this.password=password;
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
