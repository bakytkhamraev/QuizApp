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
                    binding.oneAnswer.setEnabled(false);
                    binding.twoAnswer.setEnabled(false);
                    binding.threeAnswer.setEnabled(false);
                    binding.fourAnswer.setEnabled(false);
                }
            });

            binding.oneAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.oneAnswer.getText() + "";
                    isTryAnswer(s, answerTrue, binding.oneAnswer);
                    listener.onItemClick();
                    binding.oneAnswer.setEnabled(false);
                    binding.twoAnswer.setEnabled(false);
                    binding.threeAnswer.setEnabled(false);
                    binding.fourAnswer.setEnabled(false);


                }
            });
            binding.twoAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.twoAnswer.getText() + "";
                    isTryAnswer(s, answerTrue, binding.twoAnswer);
                    listener.onItemClick();
                    binding.oneAnswer.setEnabled(false);
                    binding.twoAnswer.setEnabled(false);
                    binding.threeAnswer.setEnabled(false);
                    binding.fourAnswer.setEnabled(false);

                }
            });
            binding.threeAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.threeAnswer.getText() + "";
                    isTryAnswer(s, answerTrue, binding.threeAnswer);
                    listener.onItemClick();
                    binding.oneAnswer.setEnabled(false);
                    binding.twoAnswer.setEnabled(false);
                    binding.threeAnswer.setEnabled(false);
                    binding.fourAnswer.setEnabled(false);
                }
            });
            binding.fourAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.fourAnswer.getText() + "";
                    isTryAnswer(s, answerTrue, binding.fourAnswer);
                    listener.onItemClick();
                    binding.oneAnswer.setEnabled(false);
                    binding.twoAnswer.setEnabled(false);
                    binding.threeAnswer.setEnabled(false);
                    binding.fourAnswer.setEnabled(false);


                }
            });
        }

        public void onBind(ResultQuiz model) {
            answerTrue = model.getCorrect_answer();
            binding.questTitleTv.setText(model.getQuestion());
            binding.oneAnswer.setEnabled(true);
            binding.twoAnswer.setEnabled(true);
            binding.threeAnswer.setEnabled(true);
            binding.fourAnswer.setEnabled(true);
            binding.oneAnswer.setBackgroundResource(R.drawable.answer);
            binding.twoAnswer.setBackgroundResource(R.drawable.answer);
            binding.threeAnswer.setBackgroundResource(R.drawable.answer);
            binding.fourAnswer.setBackgroundResource(R.drawable.answer);
            if (model.getIncorrect_answers().size() == 1) {
                binding.twoAnswer.setVisibility(View.GONE);
                binding.fourAnswer.setVisibility(View.GONE);
                binding.oneAnswer.setText(model.getCorrect_answer());
                binding.threeAnswer.setText(model.getIncorrect_answers().get(0));

            } else {
                List<String> answers = model.getIncorrect_answers();
                answers.add(model.getCorrect_answer());
                Collections.shuffle(answers);
                binding.oneAnswer.setText(answers.get(0));
                binding.twoAnswer.setText(answers.get(1));
                binding.threeAnswer.setText(answers.get(2));
                binding.fourAnswer.setText(answers.get(3));
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
