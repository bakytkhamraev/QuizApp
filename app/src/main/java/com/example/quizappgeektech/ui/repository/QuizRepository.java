package com.example.quizappgeektech.ui.repository;


import com.example.quizappgeektech.ui.interfaces.IQuizQuestionsService;

public class QuizRepository implements IQuizQuestionsService {

    private IQuizQuestionsService questionsService;

    public QuizRepository(IQuizQuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Override
    public void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty) {
    }
}
