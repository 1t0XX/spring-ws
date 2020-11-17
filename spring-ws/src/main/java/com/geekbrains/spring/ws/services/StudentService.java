package com.geekbrains.spring.ws.services;

import com.geekbrains.spring.ws.entities.StudentEntity;
import com.geekbrains.spring.ws.repositories.StudentRepository;
import com.geekbrains.spring.ws.soap.students.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private static final Function<StudentEntity, Student> functionEntityToSoap = se -> {
        Student s = new Student();
        s.setId(se.getId());
        s.setName(se.getName());
        s.setAge(se.getAge());
        return s;
    };

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Student getByName(String name) {
        return studentRepository.findByName(name).map(functionEntityToSoap).get();
    }
}
