package com.philip.jeopardy;

public class App {
    public static void main(String[] args) {
        QuestionRepository questionRepository = new QuestionRepository("jeopardy.csv");
        JeopardyService jeopardyService = new JeopardyService(questionRepository);
        JeopardyServer jeopardyServer = new JeopardyServer(jeopardyService);
    }
}
