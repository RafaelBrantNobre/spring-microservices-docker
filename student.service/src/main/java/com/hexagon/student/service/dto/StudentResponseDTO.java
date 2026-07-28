package com.hexagon.student.service.dto;

public class StudentResponseDTO {

    private String id;
    private String studentName;
    private int age;
    private SchoolDTO school;

    public StudentResponseDTO() {}

    public StudentResponseDTO(String id, String studentName, int age, SchoolDTO school) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.school = school;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public SchoolDTO getSchool() { return school; }
    public void setSchool(SchoolDTO school) { this.school = school; }
}
