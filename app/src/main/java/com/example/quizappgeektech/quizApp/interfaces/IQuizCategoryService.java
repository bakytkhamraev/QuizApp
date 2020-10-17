package com.example.quizappgeektech.quizApp.interfaces;

import com.example.quizappgeektech.quizApp.models.CategoryModel;

public interface IQuizCategoryService {

    void getCategory(CategoryCallback callback);

    interface CategoryCallback extends IBaseCallback<CategoryModel> {
        @Override
        void onSuccess(CategoryModel result);

        @Override
        void onFailure(Throwable th);
    }
}
