package com.example.quizappgeektech.quizApp;

import android.app.Application;

import com.example.quizappgeektech.quizApp.data.QuizAppService;
import com.example.quizappgeektech.quizApp.repository.QuizRepository;

public class App extends Application {

    public static QuizAppService appService;
    public static QuizRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        appService = new QuizAppService();
        repository = new QuizRepository(appService);

    }
}
