package com.hexagon.student.service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String studentName;
    private int age;
    private int schoolId;

    public Student() {}

    public Student(String id, String studentName, int age, int schoolId) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.schoolId = schoolId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getSchoolId() { return schoolId; }
    public void setSchoolId(int schoolId) { this.schoolId = schoolId; }
}
