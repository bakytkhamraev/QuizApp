package com.example.quizappgeektech.ui.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.quizappgeektech.R;
import com.example.quizappgeektech.ui.model.CategoryModel;
import com.example.quizappgeektech.ui.model.TriviaCategory;
import com.example.quizappgeektech.ui.presentation.question.QuestionActivity;
import com.example.quizappgeektech.util.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView counter;
    private AppCompatSeekBar seekBar;
    private AppCompatSpinner spinnerCat, spinnerDif;
    private Button start_btn;
    private Integer category_id, amount;
    private String categoryName, difficultyL;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        counter = view.findViewById(R.id.seek_bar_counter);
        seekBar = view.findViewById(R.id.main_fr_seekBar);
        seekBar.setMax(10);
        spinnerCat = view.findViewById(R.id.main_category_spinner);
        spinnerDif = view.findViewById(R.id.main_difficulty_spinner);
        start_btn = view.findViewById(R.id.main_start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra(Config.KEY_CATEGORY, category_id);
                intent.putExtra(Config.KEY_NAME, categoryName);
                intent.putExtra(Config.KEY_DIFFICULTY, difficultyL);
                intent.putExtra(Config.KEY_AMOUNT, amount);
                startActivity(intent);
            }
        });
        setDifficulty();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getCategory();
        onProgressChange();

        mViewModel.categoryLiveData.observe(getActivity(), new Observer<CategoryModel>() {
            @Override
            public void onChanged(CategoryModel categoryModel) {
                List<TriviaCategory> trivia_categories = categoryModel.getTrivia_categories();
                List<String> list = new ArrayList<>();
                for (TriviaCategory trivia_categorys : trivia_categories) {
                    list.add(trivia_categorys.getName());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_dropdown_item, list);
                    spinnerCat.setAdapter(adapter);
                    spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            category_id = categoryModel.getTrivia_categories().get(i).getId();
                            categoryName = categoryModel.getTrivia_categories().get(i).getName();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
        });


    }

    public void setDifficulty() {
        List<String> difficulty = new ArrayList<>();
        difficulty.add("Any difficulty");
        difficulty.add("easy");
        difficulty.add("medium");
        difficulty.add("hard");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, difficulty);
        spinnerDif.setAdapter(adapter);
        spinnerDif.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                difficultyL = difficulty.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onProgressChange() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                counter.setText(String.valueOf(i));
                amount = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
