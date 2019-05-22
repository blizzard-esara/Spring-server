package com.spring.blizzard.user.controller;

import com.spring.blizzard.user.dto.Explanation;
import com.spring.blizzard.user.dto.Quiz;
import com.spring.blizzard.user.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ContentsController {

    @Autowired
    ContentsService contentsService;

    @RequestMapping("/getQuizList")
    public @ResponseBody List<Quiz> getQuizList (HttpServletRequest request) throws Exception {
        return contentsService.getQuizList(request);
    }

    @RequestMapping("/explanationShow")
    public @ResponseBody Explanation explanationShow (HttpServletRequest request) throws Exception {
        return contentsService.explanationShow(request);
    }

    @RequestMapping("/explanationList")
    public @ResponseBody List<Explanation> explanationList(HttpServletRequest request) throws Exception {
        return contentsService.explanationList(request);
    }
}
