package com.example.hw4_3month;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw4_3month.databinding.FragmentCountriesBinding;

import java.util.ArrayList;
import java.util.List;


public class CountriesFragment extends Fragment {

    private FragmentCountriesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCountriesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        String continentName = getArguments().getString("continentName");

        List <Countries> countries = new ArrayList<>();

        if (continentName.equals("South America")){
            countries.add(new Countries("Brazil", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1200px-Flag_of_Brazil.svg.png"));
            countries.add(new Countries("Argentina", "https://upload.wikimedia.org/wikipedia/commons/1/1a/Flag_of_Argentina.svg"));
            countries.add(new Countries("Chile", "https://upload.wikimedia.org/wikipedia/commons/7/78/Flag_of_Chile.svg"));
            countries.add(new Countries("Colombia", "https://upload.wikimedia.org/wikipedia/commons/2/21/Flag_of_Colombia.svg"));
            countries.add(new Countries("Peru", "https://upload.wikimedia.org/wikipedia/commons/c/cf/Flag_of_Peru.svg"));
        }else if (continentName.equals("North America")) {
            countries.add(new Countries("USA", "https://upload.wikimedia.org/wikipedia/commons/a/a4/Flag_of_the_United_States.svg"));
            countries.add(new Countries("Canada", "https://upload.wikimedia.org/wikipedia/commons/d/d9/Flag_of_Canada.svg"));
            countries.add(new Countries("Mexico", "https://upload.wikimedia.org/wikipedia/commons/f/fc/Flag_of_Mexico.svg"));
            countries.add(new Countries("Cuba", "https://upload.wikimedia.org/wikipedia/commons/b/bd/Flag_of_Cuba.svg"));
            countries.add(new Countries("Jamaica", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Flag_of_Jamaica.svg"));
        } else if (continentName.equals("Eurasia")) {
            countries.add(new Countries("Russia", "https://upload.wikimedia.org/wikipedia/en/f/f3/Flag_of_Russia.svg"));
            countries.add(new Countries("Turkey", "https://upload.wikimedia.org/wikipedia/commons/b/b4/Flag_of_Turkey.svg"));
            countries.add(new Countries("Kazakhstan", "https://upload.wikimedia.org/wikipedia/commons/d/d3/Flag_of_Kazakhstan.svg"));
            countries.add(new Countries("Ukraine", "https://upload.wikimedia.org/wikipedia/commons/4/49/Flag_of_Ukraine.svg"));
            countries.add(new Countries("Belarus", "https://upload.wikimedia.org/wikipedia/commons/8/85/Flag_of_Belarus.svg"));
        }else if (continentName.equals("Antarctica")) {
            countries.add(new Countries("No Country available", ""));
        } else if (continentName.equals("Australia")) {
            countries.add(new Countries("No Country available", ""));
        } else if (continentName.equals("Africa")) {
            countries.add(new Countries("Nigeria", "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg"));
            countries.add(new Countries("South Africa", "https://upload.wikimedia.org/wikipedia/commons/a/af/Flag_of_South_Africa.svg"));
            countries.add(new Countries("Egypt", "https://upload.wikimedia.org/wikipedia/commons/f/fe/Flag_of_Egypt.svg"));
            countries.add(new Countries("Kenya", "https://upload.wikimedia.org/wikipedia/commons/4/49/Flag_of_Kenya.svg"));
            countries.add(new Countries("Ghana", "https://upload.wikimedia.org/wikipedia/commons/1/19/Flag_of_Ghana.svg"));




    }
        CountriesAdapter adapter = new CountriesAdapter(countries);
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCountries.setAdapter(adapter);

        return view;
    }
}