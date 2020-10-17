package com.example.quizappgeektech.ui.presentation.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.quizappgeektech.MainActivity;
import com.example.quizappgeektech.R;
import com.example.quizappgeektech.util.Config;

public class ResultActivity extends AppCompatActivity {
    private ResultViewModel mViewModel;
    private Button buttonFinish;
    private TextView category, difficulty, allResult, rightAns, incorrectAns;
    private Integer rightAnswer;
    private Integer allQuestion;
    private Double procent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        buttonFinish = findViewById(R.id.resultFinish);
        category = findViewById(R.id.resultCardCategory);
        difficulty = findViewById(R.id.difficultySet);
        rightAns = findViewById(R.id.r_correct_answer_left);
        incorrectAns = findViewById(R.id.r_correct_answer_right);
        allResult = findViewById(R.id.result_set);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        category.setText(intent.getStringExtra(Config.KEY_CATEGORY));
        difficulty.setText(intent.getStringExtra(Config.KEY_DIFFICULTY));
        rightAnswer = intent.getIntExtra(Config.KEY_ANSWER, 0);
        allQuestion = intent.getIntExtra(Config.KEY_AMOUNT, 0);

        procent = (double) rightAnswer / allQuestion;
        int n = (int) (procent * 100);
        allResult.setText(String.valueOf(n) + "%");
        rightAns.setText(String.valueOf(rightAnswer));
        incorrectAns.setText(String.valueOf(allQuestion));


    }
}
