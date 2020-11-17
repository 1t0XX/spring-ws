package com.geekbrains.spring.ws.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
