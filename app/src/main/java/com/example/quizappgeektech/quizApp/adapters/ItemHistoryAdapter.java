package com.example.quizappgeektech.quizApp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizappgeektech.R;
import com.example.quizappgeektech.databinding.ItemHistoryBinding;

public class ItemHistoryAdapter extends RecyclerView.Adapter<ItemHistoryAdapter.HistoryHolder> {

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHistoryBinding binding = DataBindingUtil
                .bind(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_history, parent, false));
        return new HistoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(ItemHistoryBinding binding) {
            super(binding.getRoot());
        }
    }
}
