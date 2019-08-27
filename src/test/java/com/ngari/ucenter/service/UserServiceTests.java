package com.ngari.ucenter.service;

import com.ngari.ucenter.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by win on 2019/8/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Test
    public void createRandomUserTest() {
        UserService service = new UserService();
        User user = service.createRandomUser();
        System.out.println(user.toString());
    }

}
