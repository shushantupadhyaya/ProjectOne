package com.example.projectone.student.controller;

import com.example.projectone.student.Student;
import com.example.projectone.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
// equates to => private StudentService studentService = new StudentService();
// two ways to apply crud methods for a controller


    //GET

//    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents(){
        return studentService.getStudents();
    }



    //POST

//    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public void addNewStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }



    //DELETE

//    @DeleteMapping(path = "{studentId}")
    @RequestMapping(path="{studentId}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("studentId") Integer studentId)
    {
        studentService.deleteStudentById(studentId);
    }



    //PUT (update)

//    @PutMapping(path = "{studentId}")
    @RequestMapping(path = "{studentId}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                              @RequestParam(value = "studentName",required = false) String studentName,
                              @RequestParam(value = "studentEmail",required = false) String studentEmail)
    {
        studentService.updateStudentById(studentId,studentName,studentEmail);
    }
}
