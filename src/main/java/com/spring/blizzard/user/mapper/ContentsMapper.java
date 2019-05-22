package com.spring.blizzard.user.mapper;

import com.spring.blizzard.user.dto.Explanation;
import com.spring.blizzard.user.dto.Quiz;

import java.util.List;
import java.util.Map;

public interface ContentsMapper {


    public List<Map<String, Object>> unlockExplanationList(String id) throws Exception;
    public List<Explanation> explanationList() throws Exception;
    public List<Map<String, Object>> getAttr (int col) throws Exception;

    public List<Quiz> getQuizList(Map<String, Object> map) throws Exception;
    public List<Quiz> getQuizListInit(String theme, String level) throws Exception;
    public int getQuizAttrSize(int col) throws Exception;
    public List<Map<String, Object>> getQuestionAttr(int col) throws Exception;

    public void insertSolve(String id, String col) throws Exception;
    public List<Explanation> explanationShow(int col) throws Exception;

}
