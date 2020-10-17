package com.example.quizappgeektech.quizApp.presentation.question;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizappgeektech.quizApp.App;
import com.example.quizappgeektech.quizApp.data.QuizAppService;
import com.example.quizappgeektech.quizApp.models.QuizModel;

public class QuestionViewModel extends ViewModel {
    public MutableLiveData<QuizModel> quizModelLiveData = new MutableLiveData<>();

    public void getQuestions(Integer amount, Integer category, String difficulty) {
        App.appService.getQuestions(new QuizAppService.QuizModelCallback() {
            @Override
            public void onSuccess(QuizModel model) {
                quizModelLiveData.setValue(model);
            }

            @Override
            public void onFailure(Throwable th) {

            }
        }, amount, category, difficulty);
    }
}
