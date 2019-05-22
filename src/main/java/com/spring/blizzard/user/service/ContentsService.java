package com.spring.blizzard.user.service;


import com.spring.blizzard.user.dto.Explanation;
import com.spring.blizzard.user.dto.Quiz;
import com.spring.blizzard.user.mapper.ContentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContentsService {

    @Autowired
    ContentsMapper contentsMapper;

    public List<Quiz> getQuizList(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String theme = request.getParameter("theme");
        String level = request.getParameter("level");

        List<Integer> solveArr = new ArrayList<>();

        List<Quiz> quizlist;

        List<Map<String, Object>> solveList = contentsMapper.unlockExplanationList(id);
        if(solveList.size() >0) {
            for (int i = 0; i < solveList.size(); i++) {
                solveArr.add(Integer.parseInt(solveList.get(i).get("col").toString()));
            }
            HashMap<String, Object> maps = new HashMap<>();
            maps.put("theme", theme);
            maps.put("level", level);
            maps.put("list", solveArr);

            quizlist = contentsMapper.getQuizList(maps);
        } else {
            quizlist = contentsMapper.getQuizListInit(theme, level);
        }

        for(int i = 0 ; i<quizlist.size() ; i++) {
           Quiz quiz = (Quiz)quizlist.get(i);
           quiz.setAttrCnt(contentsMapper.getQuizAttrSize(quiz.getCol()));

           if(quiz.getAttrCnt() > 0) {

               List<String> urlArr = new ArrayList<String>();

               List<Map<String, Object>> source = contentsMapper.getQuestionAttr(quiz.getCol());

               for(int k = 0 ; k < source.size() ; k++) {
                   urlArr.add(source.get(k).get("url").toString());
               }

               if(source.size() > 0) quiz.setAttrType(source.get(0).get("type").toString());
               quiz.setUrl(urlArr);
           }

        }


        return quizlist;
    }

    public List<Explanation> explanationList(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");

        List<Map<String, Object>> unlockList = contentsMapper.unlockExplanationList(id);

        List<Explanation> explanation = contentsMapper.explanationList();

        for(int i = 0 ; i < unlockList.size() ; i++) {
            for(int j = 0 ; j < explanation.size() ; j++) {
                if((int)unlockList.get(i).get("col") == explanation.get(j).getCol()) {
                    Explanation tmpExplanation = explanation.get(j);

                    tmpExplanation.setSolve(true);
                    List<Map<String, Object>> source = contentsMapper.getAttr(tmpExplanation.getCol());
                    tmpExplanation.setAttrCnt(source.size());

                    List<String> urlArr = new ArrayList<String>();

                    if(source.size() > 0) tmpExplanation.setAttrType(source.get(0).get("type").toString());


                    for(int k = 0 ; k < source.size() ; k++) {
                        urlArr.add(source.get(k).get("url").toString());
                    }
                    tmpExplanation.setUrl(urlArr);
                    break;
                }
            }
        }
        return explanation;
    }

    public Explanation explanationShow (HttpServletRequest request) throws Exception{

        String id = request.getParameter("id");
        int col = Integer.parseInt(request.getParameter("col"));

        ArrayList<String> urlList = new ArrayList<>();

        contentsMapper.insertSolve(id, String.valueOf(col));

        List<Explanation> explanationList = contentsMapper.explanationShow(col);
        Explanation explanation = explanationList.get(0);
        List<Map<String, Object>> maps = contentsMapper.getAttr(col);

        explanation.setAttrCnt(maps.size());
        if(maps.size() > 0) {
            explanation.setAttrType(maps.get(0).get("type").toString());
        }
        for(int i = 0 ; i < maps.size() ; i++) {
            urlList.add(maps.get(i).get("url").toString());
        }
        explanation.setUrl(urlList);

        return explanation;
    }

}
