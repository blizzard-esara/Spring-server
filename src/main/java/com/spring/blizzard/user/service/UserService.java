package com.spring.blizzard.user.service;

import com.spring.blizzard.user.dto.User;
import com.spring.blizzard.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<Map<String, Object>> loginUser (HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        return userMapper.loginUserCheck(id, pw);
    }

    public boolean checkId(HttpServletRequest request) throws Exception {
        boolean result = false;
        String id = request.getParameter("id");
        if(userMapper.checkId(id) == 0) {
            result = true;
        }

        return result;
    }
    public List<Map<String, Object>> initalCheck(HttpServletRequest request) throws Exception {

        String id = request.getParameter("id");
        return userMapper.initalCheck(id);

    }

    public boolean signUp(HttpServletRequest request) throws Exception {
        boolean result = false;
        System.out.println(request.getParameter("phone").toString());
        User user = new User(request.getParameter("id"),
                                request.getParameter("pw"),
                                request.getParameter("phone"),
                                request.getParameter("gender"),
                                Integer.parseInt(request.getParameter("age")),
                                        request.getParameter("email"),
                                        Integer.parseInt(request.getParameter("subscription")));

        int dbResult = userMapper.signUp(user);

        if(dbResult == 1) result = true;

        return result;
    }


    public boolean eggChoise(HttpServletRequest request) throws Exception {
        boolean result = false;
        String id = request.getParameter("id");
        String monster =request.getParameter("monster");

        if(userMapper.insertEggChoise(id, monster) == 1) {
            result = true;
        }

        return result;
    }


    public String mainMonsterImageURL(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String mainMonster = request.getParameter("mainMonster");
        return userMapper.mainMosterImageURL(id, mainMonster);

    }

    public List<Map<String, Object>> buyItem(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String item = request.getParameter("item");
        int price = Integer.parseInt(request.getParameter("price"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("price",price);

        userMapper.updateItemPrice(map);
        userMapper.insertEggChoise(id, item);

        return userMapper.initalCheck(id);
    }
}
