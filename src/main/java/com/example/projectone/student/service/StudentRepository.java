package com.example.projectone.student.service;

import com.example.projectone.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("SELECT s from Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email);//parameter should be what e need in query "?"
    @Transactional //this annotation is necessary, can also call setters
    @Modifying
    @Query("UPDATE Student s set s.name=?2,s.email=?3 where s.id =?1")
    void updateStudentById(Integer studentId, String name, String email);

}
