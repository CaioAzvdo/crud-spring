package com.projeto.crud_spring.controller;

import com.projeto.crud_spring.model.Course;
import com.projeto.crud_spring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor

public class CoursesController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }
    @Bean
    CommandLineRunner initDatabase(){
        return args -> {
            courseRepository.deleteAll();
            Course C = new Course();
            C.setName("Java");
            C.setCategoria("Back-end");

            courseRepository.save(C);
        };
    }
}
