package com.philip.jeopardy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JeopardyService extends HttpServlet {
    private QuestionRepository questionRepository;


    public JeopardyService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput;
        userInput = req.getParameter("searchName");

        if(userInput != null){
            String result = questionRepository.getQuestion(userInput);
            resp.getWriter().println(result);
        }else {
            for (String questions : questionRepository.getJeopardyQuestions()) {
                resp.getWriter().println(questions);
            }
        }
    }
}
