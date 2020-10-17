package com.example.quizappgeektech.quizApp.interfaces;

public interface IBaseCallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable th);
}
