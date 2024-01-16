package com.example.projectone.student.service;

import com.example.projectone.student.Student;
import com.example.projectone.student.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
           throw new IllegalStateException("Student already exists ");
        }
        studentRepository.save(student);

    }

    public void deleteStudentById(Integer studentId) {
        boolean exists= studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "Student Id:" + studentId + " doesn't exists");
        }
        studentRepository.deleteById(studentId);

    }

    public void updateStudentById(Integer studentId, String studentName, String studentEmail) {
        boolean exists =studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("No student record present to update");

        }
        studentRepository.updateStudentById(studentId,studentName,studentEmail);
    }
}

