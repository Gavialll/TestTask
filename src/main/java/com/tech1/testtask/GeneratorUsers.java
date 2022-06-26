package com.tech1.testtask;

import com.tech1.testtask.color.Color;
import com.tech1.testtask.dto.CreateArticleDto;
import com.tech1.testtask.models.User;
import com.tech1.testtask.service.ArticleService;
import com.tech1.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!test") //Disabled this class, for test
@Service
public class GeneratorUsers implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Override
    public void run(String... args) {
        String[] names = {"Andrii", "Taras", "Pavlo", "Stepan", "Nazar"};
        Color[] colors = Color.values();

        for(int i = 0; i < random(5,10); i++) {
            User user = new User()
                        .setAge(random(6, 80))
                        .setName(names[random(0, names.length-1)]);

            user = userService.add(user);

            for(int j = 0; j < random(1,5); j++) {
                CreateArticleDto article = new CreateArticleDto(
                        user.getId(),
                        "text",
                        (colors[random(0, colors.length-1)]));

                articleService.add(article);
            }
        }
    }

    private Integer random(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
