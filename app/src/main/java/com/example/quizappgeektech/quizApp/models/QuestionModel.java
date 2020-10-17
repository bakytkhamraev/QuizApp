package com.example.quizappgeektech.quizApp.models;

public class QuestionModel {
    private String title;
    private String answerFirst;
    private String answerSecond;
    private String answerThird;
    private String answerFour;
    private String trueAnswer;
    private boolean isMulti;
    private boolean isRight;

    public QuestionModel() {
    }

    public QuestionModel(String title, String answer_first, String answer_second, String answer_third, String answer_four, String true_answer, boolean isMulti) {
        this.title = title;
        this.answerFirst = answer_first;
        this.answerSecond = answer_second;
        this.answerThird = answer_third;
        this.answerFour = answer_four;
        this.isMulti = isMulti;
        this.trueAnswer = true_answer;

    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public String getAnswerThird() {
        return answerThird;
    }

    public void setAnswerThird(String answerThird) {
        this.answerThird = answerThird;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }

    public String getTitle() {
        return title;
    }

    public boolean isMulti() {
        return isMulti;
    }

    public void setMulti(boolean multi) {
        isMulti = multi;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswerFirst() {
        return answerFirst;
    }

    public void setAnswerFirst(String answerFirst) {
        this.answerFirst = answerFirst;
    }

    public String getAnswerSecond() {
        return answerSecond;
    }

    public void setAnswerSecond(String answerSecond) {
        this.answerSecond = answerSecond;
    }
}
