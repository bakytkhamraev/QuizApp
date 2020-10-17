package com.example.quizappgeektech.ui.interfaces;

public interface IBaseCallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable th);
}
