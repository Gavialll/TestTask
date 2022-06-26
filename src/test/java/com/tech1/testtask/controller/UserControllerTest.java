package com.tech1.testtask.controller;

import com.tech1.testtask.color.exception.ColorNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void usersByArticleColor_Throw_ColorNotFound() {
        assertThrows(ColorNotFoundException.class, ()-> {
            userController.usersByArticleColor("unknown color");
        });
    }
}