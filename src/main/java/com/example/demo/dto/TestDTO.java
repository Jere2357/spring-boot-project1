package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data               //providing getters and setters for every constructor
@AllArgsConstructor
public class TestDTO {
    private String name;
    private int age;
    private LocalDate birthDate;
}
