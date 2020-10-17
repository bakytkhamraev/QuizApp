package com.example.quizappgeektech.quizApp.interfaces;


import com.example.quizappgeektech.quizApp.models.QuizModel;

public interface IQuizQuestionsService {

    void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty);

    interface QuestionsCallback extends IBaseCallback<QuizModel> {
        @Override
        void onSuccess(QuizModel model);

        @Override
        void onFailure(Throwable th);
    }
}
