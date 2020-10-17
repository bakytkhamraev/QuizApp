package com.example.quizappgeektech.quizApp.ui.fragments.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.quizappgeektech.R;
import com.example.quizappgeektech.databinding.HistoryFragmentBinding;
import com.example.quizappgeektech.quizApp.adapters.ItemHistoryAdapter;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private HistoryFragmentBinding binding;
    private ItemHistoryAdapter adapter;


    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        adapter = new ItemHistoryAdapter();
        binding.historyRv.setAdapter(adapter);
    }

}
