package com.example.quizappgeektech.quizApp.viewList;

import com.example.quizappgeektech.quizApp.models.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionModelRepository {

    public List<QuestionModel> getQuestionList() {

        List<QuestionModel> list = new ArrayList<>();
        list.add(new QuestionModel("Обладатель ЗМ 2010", "Месси", "Роналду", "Иньеста", "Хави", "Карлес", false));

        return list;
    }
}
