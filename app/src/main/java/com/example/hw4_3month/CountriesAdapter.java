package com.example.hw4_3month;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw4_3month.databinding.ItemCountryBinding;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    public CountriesAdapter(List<Countries> countries) {
        this.countries = countries;
    }

    private List<Countries> countries;

    @NonNull
    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCountryBinding binding = ItemCountryBinding.inflate(inflater, parent, false);
        return new CountriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountriesViewHolder holder, int position) {
        Countries country = countries.get(position);
        holder.binding.tvCountry.setText(country.getName());

        Glide.with(holder.binding.getRoot().getContext())
                .load(country.getFlag())
                .into(holder.binding.ivCountry);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class CountriesViewHolder extends RecyclerView.ViewHolder {

        private final ItemCountryBinding binding;

        public CountriesViewHolder(@NonNull ItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
