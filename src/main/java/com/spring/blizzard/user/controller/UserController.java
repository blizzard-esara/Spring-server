package com.spring.blizzard.user.controller;

import com.spring.blizzard.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginUser")
    public @ResponseBody List<Map<String, Object>> loginUser(HttpServletRequest request) throws Exception{
        return userService.loginUser(request);
    }

    @RequestMapping("/checkId")
    public @ResponseBody boolean checkId(HttpServletRequest request) throws Exception {
        return userService.checkId(request);
    }
    @RequestMapping("/initalCheck")
    public @ResponseBody List<Map<String, Object>>  initalCheck(HttpServletRequest request) throws Exception {
        return userService.initalCheck(request);
    }

    @RequestMapping("/signUp")
    public @ResponseBody boolean signUp(HttpServletRequest request) throws Exception {
        return userService.signUp(request);
    }

    @RequestMapping("/eggChoise")
    public @ResponseBody boolean eggChoise(HttpServletRequest request) throws Exception {
        return userService.eggChoise(request);
    }


    @RequestMapping("/mainMonsterImageURL")
    public @ResponseBody String mainMonsterImageURL(HttpServletRequest request) throws Exception {
        return userService.mainMonsterImageURL(request);
    }

    @RequestMapping("/buyItem")
    public @ResponseBody List<Map<String, Object>> buyItem(HttpServletRequest request) throws Exception {
        return userService.buyItem(request);
    }

    @RequestMapping("/monsterCollection")
    public @ResponseBody List<Map<String, Object>> monsterCollection(HttpServletRequest request) throws Exception {
        return userService.monsterCollection(request);
    }

    @RequestMapping("/monsterCount")
    public @ResponseBody List<Map<String, Object>> monsterCount(HttpServletRequest request) throws Exception {
        return userService.monsterCount(request);
    }

    @RequestMapping("/modifyUser")
    public @ResponseBody int modifyUser(HttpServletRequest request) throws Exception {
        return userService.modifyUser(request);
    }
}
