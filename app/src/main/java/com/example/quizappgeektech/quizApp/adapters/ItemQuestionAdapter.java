package com.example.quizappgeektech.quizApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.quizappgeektech.R;
import com.example.quizappgeektech.databinding.ItemQuestionBinding;
import com.example.quizappgeektech.quizApp.interfaces.OnItemClicked;
import com.example.quizappgeektech.quizApp.models.ResultQuiz;

import java.util.Collections;
import java.util.List;

public class ItemQuestionAdapter extends RecyclerView.Adapter<ItemQuestionAdapter.QuestionsHolder> {
    private List<ResultQuiz> list;
    private OnItemClicked listener;

    public ItemQuestionAdapter(List<ResultQuiz> list, OnItemClicked listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemQuestionBinding binding = DataBindingUtil.
                bind(LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_question, parent, false));
        return new QuestionsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class QuestionsHolder extends RecyclerView.ViewHolder {
        private ItemQuestionBinding binding;
        private String answerTrue;

        public QuestionsHolder(ItemQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.questSkipBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);
                }
            });

            binding.questAnswer1Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer1Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer1Tv);
                    listener.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);


                }
            });
            binding.questAnswer2Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer2Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer2Tv);
                    listener.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);

                }
            });
            binding.questAnswer3Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer3Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer3Tv);
                    listener.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);
                }
            });
            binding.questAnswer4Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer4Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer4Tv);
                    listener.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);


                }
            });
        }

        public void onBind(ResultQuiz model) {
            answerTrue = model.getCorrect_answer();
            binding.questTitleTv.setText(model.getQuestion());
            binding.questAnswer1Tv.setEnabled(true);
            binding.questAnswer2Tv.setEnabled(true);
            binding.questAnswer3Tv.setEnabled(true);
            binding.questAnswer4Tv.setEnabled(true);
            binding.questAnswer1Tv.setBackgroundResource(R.drawable.answer);
            binding.questAnswer2Tv.setBackgroundResource(R.drawable.answer);
            binding.questAnswer3Tv.setBackgroundResource(R.drawable.answer);
            binding.questAnswer4Tv.setBackgroundResource(R.drawable.answer);
            if (model.getIncorrect_answers().size() == 1) {
                binding.questAnswer2Tv.setVisibility(View.GONE);
                binding.questAnswer4Tv.setVisibility(View.GONE);
                binding.questAnswer1Tv.setText(model.getCorrect_answer());
                binding.questAnswer3Tv.setText(model.getIncorrect_answers().get(0));

            } else {
                List<String> answers = model.getIncorrect_answers();
                answers.add(model.getCorrect_answer());
                Collections.shuffle(answers);
                binding.questAnswer1Tv.setText(answers.get(0));
                binding.questAnswer2Tv.setText(answers.get(1));
                binding.questAnswer3Tv.setText(answers.get(2));
                binding.questAnswer4Tv.setText(answers.get(3));
            }
        }

        public void isTryAnswer(String answer, String tryAnswer, TextView textView) {

            if (answer.contains(tryAnswer)) {
                textView.setBackgroundResource(R.color.colorAccent);
                listener.isAnswerTry(true);
                YoYo.with(Techniques.RotateIn).duration(700).repeat(5).playOn(textView);
            } else {
                textView.setBackgroundResource(R.color.colorRed);
                listener.isAnswerTry(false);
                YoYo.with(Techniques.Bounce).duration(700).repeat(5).playOn(textView);
            }
        }
    }
}
