package com.example.quizappgeektech.ui.presentation.question;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizappgeektech.App;
import com.example.quizappgeektech.ui.data.network.QuizAppService;
import com.example.quizappgeektech.ui.model.QuizModel;

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
