package com.hexagon.student.service.dto;

public class SchoolDTO {

    private int id;
    private String schoolName;
    private String location;
    private String principalName;

    public SchoolDTO() {}

    public SchoolDTO(int id, String schoolName, String location, String principalName) {
        this.id = id;
        this.schoolName = schoolName;
        this.location = location;
        this.principalName = principalName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPrincipalName() { return principalName; }
    public void setPrincipalName(String principalName) { this.principalName = principalName; }
}
