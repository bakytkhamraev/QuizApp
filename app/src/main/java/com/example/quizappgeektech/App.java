package com.example.quizappgeektech;

import android.app.Application;

import com.example.quizappgeektech.ui.data.network.QuizAppService;
import com.example.quizappgeektech.ui.repository.QuizRepository;

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
