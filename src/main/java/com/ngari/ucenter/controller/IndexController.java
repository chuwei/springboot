package com.ngari.ucenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by win on 2019/8/18.
 */
@Controller

public class IndexController {
    @RequestMapping("/")
    public  String index(ModelMap map){
        map.addAttribute("message","hello");
        return "index";
    }

}
