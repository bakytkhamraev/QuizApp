package com.example.quizappgeektech.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryModel {

    @SerializedName("trivia_categories")
    @Expose
    private List<TriviaCategory> trivia_categories = null;

    public List<TriviaCategory> getTrivia_categories() {
        return trivia_categories;
    }

    public void setTrivia_categories(List<TriviaCategory> trivia_categories) {
        this.trivia_categories = trivia_categories;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "trivia_categories=" + trivia_categories +
                '}';
    }
}
