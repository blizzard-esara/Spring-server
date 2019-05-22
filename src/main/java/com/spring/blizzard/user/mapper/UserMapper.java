package com.spring.blizzard.user.mapper;

import com.spring.blizzard.user.dto.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    public List<Map<String, Object>> loginUserCheck(String id, String pw) throws Exception;
    public int signUp(User user) throws Exception;
    public int checkId(String id) throws Exception;
    public List<Map<String, Object>> initalCheck(String id) throws Exception;
    public int insertEggChoise(String id, String monster) throws Exception;
    public String mainMosterImageURL(String id, String mainMonster) throws Exception;
    public int updateItemPrice(Map<String, Object> map) throws Exception;
    public int addItem(String id, String item) throws Exception;

    public List<Map<String, Object>> getlockMonsterUrl() throws Exception;
    public List<Map<String, Object>> getUnLockUserMonster(String id) throws Exception;

    public List<Map<String, Object>> monsterCount(String id) throws Exception;

    public int modifyUser(String id, String email, String phone) throws Exception;
}
