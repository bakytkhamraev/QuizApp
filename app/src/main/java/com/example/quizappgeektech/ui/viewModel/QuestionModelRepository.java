package com.example.quizappgeektech.ui.viewModel;

import com.example.quizappgeektech.ui.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionModelRepository {

    public List<QuestionModel> getQuestionList() {

        List<QuestionModel> list = new ArrayList<>();
        list.add(new QuestionModel("Обладатель ЗМ 2010", "Месси", "Роналду", "Иньеста", "Хави", "Карлес", false));

        return list;
    }
}
