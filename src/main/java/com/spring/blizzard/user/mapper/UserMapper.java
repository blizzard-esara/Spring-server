package com.spring.blizzard.user.mapper;

import com.spring.blizzard.user.dto.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    public List<Map<String, Object>> loginUserCheck(String id, String pw) throws Exception;
    public int signUp(User user) throws Exception;
    public int checkId(String id) throws Exception;
    public int initalCheck(String id) throws Exception;
    public int insertEggChoise(String id, String monster) throws Exception;
}
