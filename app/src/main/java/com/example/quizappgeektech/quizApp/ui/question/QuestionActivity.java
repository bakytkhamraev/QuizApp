package com.example.quizappgeektech.quizApp.ui.question;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizappgeektech.R;
import com.example.quizappgeektech.quizApp.adapters.ItemQuestionAdapter;
import com.example.quizappgeektech.quizApp.interfaces.OnItemClicked;
import com.example.quizappgeektech.quizApp.models.QuizModel;
import com.example.quizappgeektech.quizApp.models.ResultQuiz;
import com.example.quizappgeektech.quizApp.ui.result.ResultActivity;
import com.example.quizappgeektech.quizApp.Config;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private ItemQuestionAdapter adapter;
    private RecyclerView recyclerView;
    private List<ResultQuiz> list;
    public MutableLiveData<Integer> liveData = new MutableLiveData<>();
    private ProgressBar progressBar;
    private TextView categoryTV, back, progressStart, getProgressEnd;
    private Integer amount;
    private Integer answerRight = 0;
    private Integer category_id;
    private Integer count = 1;
    private String categoryName;
    private String difficulty;
    private QuestionViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        viewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        progressBar = findViewById(R.id.quest_progress);
        recyclerView = findViewById(R.id.question);
        categoryTV = findViewById(R.id.quest_category);
        back = findViewById(R.id.quest_back);
        progressStart = findViewById(R.id.quest_progressStart);
        getProgressEnd = findViewById(R.id.quest_progressEnd);
        intentGet();
        backPressed();
        if (difficulty.equals("Any difficulty")) {
            getData(amount, category_id, null);
        }
        getData(amount, category_id, difficulty);

    }

    public void getData(Integer amount, Integer category, String difficulty) {
        Log.d("ololo", "getData");
        viewModel.getQuestions(amount, category, difficulty);
        viewModel.quizModelLiveData.observe(this, new Observer<QuizModel>() {
            @Override
            public void onChanged(QuizModel model) {
                list = model.getResults();
                Log.d("ololo", "getData + list" + list.size());
                adapter = new ItemQuestionAdapter(list, new OnItemClicked() {
                    @Override
                    public void onItemClick() {
                        if (liveData.getValue() == null) {
                            liveData.setValue(0);
                        }
                        new CountDownTimer(500, 500) {
                            @Override
                            public void onTick(long l) {
                            }

                            @Override
                            public void onFinish() {
                                if (liveData.getValue() == (list.size() - 1)) {
                                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                                    intent.putExtra(Config.KEY_CATEGORY, categoryName);
                                    intent.putExtra(Config.KEY_DIFFICULTY, difficulty);
                                    intent.putExtra(Config.KEY_ANSWER, answerRight);
                                    intent.putExtra(Config.KEY_AMOUNT, amount);
                                    startActivity(intent);

                                } else {
                                    liveData.setValue(liveData.getValue() + 1);
                                    recyclerView.scrollToPosition(liveData.getValue());
                                    count++;
                                    progressBar.setProgress(count);
                                    progressStart.setText(liveData.getValue() + "");
                                }
                            }
                        }.start();
                    }

                    @Override
                    public void isAnswerTry(Boolean b) {
                        if (b) {
                            answerRight++;
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public void intentGet() {
        Intent intent = getIntent();
        category_id = intent.getIntExtra(Config.KEY_CATEGORY, 9);
        categoryName = intent.getStringExtra(Config.KEY_NAME);
        difficulty = intent.getStringExtra(Config.KEY_DIFFICULTY);
        amount = intent.getIntExtra(Config.KEY_AMOUNT, 0);
        categoryTV.setText(intent.getStringExtra(Config.KEY_NAME));
        progressBar.setMax(amount);
        getProgressEnd.setText(amount + "");
    }

    public void backPressed() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                progressBar.setProgress(count);
                liveData.setValue(liveData.getValue() - 1);
                recyclerView.scrollToPosition(liveData.getValue());

            }
        });
    }


}
