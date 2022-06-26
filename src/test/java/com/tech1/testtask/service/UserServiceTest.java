package com.tech1.testtask.service;

import com.tech1.testtask.color.Color;
import com.tech1.testtask.models.Article;
import com.tech1.testtask.models.User;
import com.tech1.testtask.respository.ArticleRepository;
import com.tech1.testtask.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private UserService userService;

    @Mock
    private ArrayList<Article> articlesMock;

    @Test
    void usersOlderThan() {
        List<User> users = List.of(
                new User().setId(3L).setAge(33).setName("test3"));

        Mockito.when(userService.usersOlderThan(25))
                .thenReturn(users);

        User expected = new User().setId(3L).setAge(33).setName("test3");
        User actual = userService.usersOlderThan(25).get(0);

        assertEquals(expected, actual);
    }

    @Test
    void usersByArticleColor() {
        List<Article> articles = List.of(
                new Article().setUser(new User().setId(3L).setAge(33).setName("test3")).setColor(Color.DARK),
                new Article().setUser(new User().setId(2L).setAge(22).setName("test2")).setColor(Color.DARK));

        Mockito.when(articleRepository.findByColor("DARK"))
                .thenReturn(articles);

        Set<User> expected = Set.of(
                new User().setId(2L).setAge(22).setName("test2"),
                new User().setId(3L).setAge(33).setName("test3"));
        Set<User> actual = userService.usersByArticleColor(Color.DARK);

        assertEquals(expected, actual);
    }

    @Test
    void add() {
        User expectedUser = new User().setName("testName").setAge(20).setId(1L);

        Mockito.when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        User actualUser = userService.add(expectedUser);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void distinctUsers() {
        List <User> users = List.of(
                new User().setId(3L).setAge(33).setName("distinctName1")
                        .setArticles(articlesMock),
                new User().setId(2L).setAge(22).setName("distinctName2")
                        .setArticles(articlesMock),
                new User().setId(1L).setAge(11).setName("distinctName2")
                        .setArticles(articlesMock));

        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(articlesMock.size())
                .thenReturn(4)
                .thenReturn(4)
                .thenReturn(4);

        Set<String> expected = Set.of("distinctName1", "distinctName2");
        Set<String> actual =  userService.distinctUsers();

        assertEquals(expected, actual);
    }
}