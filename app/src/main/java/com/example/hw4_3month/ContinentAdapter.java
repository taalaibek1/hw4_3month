package com.example.hw4_3month;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.hw4_3month.databinding.ItemContinentBinding;
import java.util.List;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {
    private List<Continents> continents;
    private OnContinentClickListener listener;
    public ContinentAdapter(List<Continents> continents, OnContinentClickListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    @Override
    public ContinentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemContinentBinding binding = ItemContinentBinding.inflate(inflater, parent, false);
        return new ContinentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ContinentViewHolder holder, int position) {
        Continents continent = continents.get(position);
        holder.binding.tvName.setText(continent.getName());

        Glide.with(holder.binding.getRoot().getContext())
                .load(continent.getFlag())
                .into(holder.binding.ivFlag);

        holder.binding.getRoot().setOnClickListener(v -> listener.OnContinentClick(continent));
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    public static class ContinentViewHolder extends RecyclerView.ViewHolder {
        private final ItemContinentBinding binding;

        public ContinentViewHolder(ItemContinentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnContinentClickListener {
        void OnContinentClick(Continents continent);
    }
}
