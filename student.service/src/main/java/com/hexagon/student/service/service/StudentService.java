package com.hexagon.student.service.service;

import com.hexagon.student.service.dto.SchoolDTO;
import com.hexagon.student.service.dto.StudentResponseDTO;
import com.hexagon.student.service.entity.Student;
import com.hexagon.student.service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    public StudentResponseDTO fetchStudentById(String id) {
        Student student = studentRepository.findById(id).orElseThrow();
        SchoolDTO school = restTemplate.getForObject(
                "http://SCHOOL-SERVICE/school/" + student.getSchoolId(),
                SchoolDTO.class
        );
        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(student.getId());
        response.setStudentName(student.getStudentName());
        response.setAge(student.getAge());
        response.setSchool(school);
        return response;
    }
}
