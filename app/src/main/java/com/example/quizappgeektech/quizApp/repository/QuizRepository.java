package com.example.quizappgeektech.quizApp.repository;


import com.example.quizappgeektech.quizApp.interfaces.IQuizQuestionsService;

public class QuizRepository implements IQuizQuestionsService {

    private IQuizQuestionsService questionsService;

    public QuizRepository(IQuizQuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Override
    public void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty) {
    }
}
