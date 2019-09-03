package com.ngari.ucenter.controller;

import com.ngari.ucenter.common.utils.RandomUtils;
import com.ngari.ucenter.model.User;
import com.ngari.ucenter.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by win on 2019/8/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    @RequestMapping(value ="/hello",method = RequestMethod.POST)
    public String hello(@RequestParam String name) {
        return "hello " + name + "，this is first messge";
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
