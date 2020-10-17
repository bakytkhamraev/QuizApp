package com.example.quizappgeektech.ui.fragment.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizappgeektech.App;
import com.example.quizappgeektech.ui.data.network.QuizAppService;
import com.example.quizappgeektech.ui.model.CategoryModel;


public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<CategoryModel> categoryLiveData = new MutableLiveData<>();

    public void plusPress() {
        if (mutableLiveData.getValue() == null) {
            mutableLiveData.setValue(0);
        }
        mutableLiveData.setValue(mutableLiveData.getValue() + 1);
    }

    public void minusPressed() {
        if (mutableLiveData.getValue() == null) {
            mutableLiveData.setValue(0);
        }
        mutableLiveData.setValue(mutableLiveData.getValue() - 1);
    }

    public void getCategory() {
        App.appService.getCategories(new QuizAppService.QuizApiCallback() {
            @Override
            public void onSuccess(CategoryModel categoryModel) {

                categoryLiveData.setValue(categoryModel);
            }

            @Override
            public void onFailure(Throwable th) {

            }
        });
    }

}
