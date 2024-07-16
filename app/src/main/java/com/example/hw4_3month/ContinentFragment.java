package com.example.hw4_3month;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hw4_3month.databinding.FragmentContinentBinding;
import java.util.ArrayList;
import java.util.List;

public class ContinentFragment extends Fragment {
    private FragmentContinentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        List<Continents> continents = new ArrayList<>();
        continents.add(new Continents("South America", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/2048px-South_America_%28orthographic_projection%29.svg.png"));
        continents.add(new Continents("North America", "https://static.wikia.nocookie.net/walkingwith/images/7/71/1024px-Location_North_America.svg.png/revision/latest/scale-to-width-down/1024?cb=20150603145610"));
        continents.add(new Continents("Eurasia", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Eurasia_%28orthographic_projection%29.svg/420px-Eurasia_%28orthographic_projection%29.svg.png"));
        continents.add(new Continents("Australia", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Australia-New_Guinea_%28orthographic_projection%29.svg/300px-Australia-New_Guinea_%28orthographic_projection%29.svg.png"));
        continents.add(new Continents("Antarctica", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Antarctica_%28orthographic_projection%29.svg/420px-Antarctica_%28orthographic_projection%29.svg.png"));
        continents.add(new Continents("Africa", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/800px-Africa_%28orthographic_projection%29.svg.png"));

        ContinentAdapter adapter = new ContinentAdapter(continents, continent -> {
            Bundle bundle = new Bundle();
            bundle.putString("continentName", continent.getName());
            CountriesFragment countryFragment = new CountriesFragment();
            countryFragment.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, countryFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvContinents.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvContinents.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
