package com.chuwei.controller;

import com.chuwei.common.utils.RandomUtils;
import com.chuwei.model.User;
import com.chuwei.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by win on 2019/8/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/getUser")
    public String getUser(ModelMap map) {
        UserService userService = new UserService();
        User user = userService.createRandomUser();
        String idcard = RandomUtils.getRandomID();
        map.addAttribute("user",user);
        map.addAttribute("idcard",idcard);
        return "user/getUser";
    }
}
