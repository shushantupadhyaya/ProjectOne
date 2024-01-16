/*
To add data in Student table in postgres.
*/
package com.example.projectone.student;

import com.example.projectone.student.service.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student shushant = new Student(
                    "Shushant",
                    "shushant@gmail.com",
                    LocalDate.of(2001, OCTOBER, 27));

            Student rakesh = new Student(
                    "Rakesh",
                    "rakesh@gmail.com",
                    LocalDate.of(2001, MARCH, 22));

            repository.saveAll(List.of(shushant,rakesh));

        };
    }
}
