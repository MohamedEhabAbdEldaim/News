package com.midooabdaim.news.ui.fragment.viewCountery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midooabdaim.news.R;
import com.midooabdaim.news.adapter.ViewCountryAdapter;
import com.midooabdaim.news.data.model.Country;
import com.midooabdaim.news.databinding.FragmentCountryviewBinding;
import com.midooabdaim.news.ui.fragment.BaseFragment;

import java.util.List;


public class CountryViewFragment extends BaseFragment {
    FragmentCountryviewBinding binding;
    ViewModelToViewCountry viewModelToViewCountry;
    private LinearLayoutManager linearLayoutManager;
    private ViewCountryAdapter viewCountryAdapter;
    private List<Country> countryList;

    public CountryViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_countryview, container, false);
        //return inflater.inflate(R.layout.fragment_countryview, container, false);
        View view = binding.getRoot();
        viewModelToViewCountry = ViewModelProviders.of(getActivity()).get(ViewModelToViewCountry.class);
        binding.setLifecycleOwner(getActivity());
        initRecyclerView();
        viewModelToViewCountry.getListLiveData().observe(getActivity(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                viewCountryAdapter.setCountryList(countries);
            }
        });

        return view;

    }

    void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.fragmentCountryViewRcvId.setLayoutManager(linearLayoutManager);
        viewCountryAdapter = new ViewCountryAdapter(getActivity());
        binding.fragmentCountryViewRcvId.setAdapter(viewCountryAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        intialFragment();
    }

    @Override
    public void BackPressed() {
        getActivity().finish();
    }
}