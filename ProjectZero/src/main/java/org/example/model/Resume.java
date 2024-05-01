package org.example.model;

public class Resume {
    private int id;
    private String location;
    private String skillset1;
    private String skillset2;
    private String skillset3;

    public Resume(int id, String location, String skillset1, String skillset2, String skillset3) {
        this.location = location;
        this.skillset1 = skillset1;
        this.skillset2 = skillset2;
        this.skillset3 = skillset3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkillset1() {
        return skillset1;
    }

    public void setSkillset1(String skillset1) {
        this.skillset1 = skillset1;
    }

    public String getSkillset2() {
        return skillset2;
    }

    public void setSkillset2(String skillset2) {
        this.skillset2 = skillset2;
    }

    public String getSkillset3() {
        return skillset3;
    }

    public void setSkillset3(String skillset3) {
        this.skillset3 = skillset3;
    }
}
