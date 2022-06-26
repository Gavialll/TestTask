package com.tech1.testtask.dto;

import com.tech1.testtask.models.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseUserDto {
    private Long id;
    private String name;
    private Integer age;

    public ResponseUserDto() {
    }

    public ResponseUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public ResponseUserDto setId(Long id) {
        this.id = id;
        return ResponseUserDto.this;
    }

    public ResponseUserDto setName(String name) {
        this.name = name;
        return ResponseUserDto.this;
    }

    public ResponseUserDto setAge(Integer age) {
        this.age = age;
        return ResponseUserDto.this;
    }

    public static List<ResponseUserDto> mapFrom(List<User> userList){
        return userList.stream().map(user -> new ResponseUserDto()
                    .setAge(user.getAge())
                    .setId(user.getId())
                    .setName(user.getName()))
                .collect(Collectors.toList());
    }
}
