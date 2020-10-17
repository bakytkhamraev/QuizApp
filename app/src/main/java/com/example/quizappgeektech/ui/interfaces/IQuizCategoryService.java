package com.example.quizappgeektech.ui.interfaces;

import com.example.quizappgeektech.ui.model.CategoryModel;

public interface IQuizCategoryService {

    void getCategory(CategoryCallback callback);

    interface CategoryCallback extends IBaseCallback<CategoryModel> {
        @Override
        void onSuccess(CategoryModel result);

        @Override
        void onFailure(Throwable th);
    }
}
