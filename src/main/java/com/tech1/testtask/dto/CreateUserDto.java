package com.tech1.testtask.dto;

import lombok.Getter;

@Getter
public class CreateUserDto {
    private String name;
    private Integer age;

    public CreateUserDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
