package com.midooabdaim.news.ui.fragment.dataNewsForCountry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midooabdaim.news.R;
import com.midooabdaim.news.adapter.SpinnerAdpter;
import com.midooabdaim.news.adapter.ViewCountryAdapter;
import com.midooabdaim.news.adapter.ViewNewsAdapter;
import com.midooabdaim.news.data.model.Category;
import com.midooabdaim.news.data.model.NewsModel.Article;
import com.midooabdaim.news.databinding.FragmentViewNewsBinding;
import com.midooabdaim.news.helper.OnEndLess;
import com.midooabdaim.news.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.news.helper.Constant.apiKey;


public class ViewNewsDataFragment extends BaseFragment {

    FragmentViewNewsBinding binding;
    public String countryAbbreviation;
    private LinearLayoutManager linearLayoutManager;
    ViewModelToViewNews viewModelToViewNews;
    ViewNewsAdapter viewNewsAdapter;
    private SpinnerAdpter adpterCategory;
    private List<Article> articleList = new ArrayList<>();
    private OnEndLess onEndLess;

    public ViewNewsDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //  return inflater.inflate(R.layout.fragment_view_news, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_news, container, false);
        View view = binding.getRoot();
        viewModelToViewNews = ViewModelProviders.of(getActivity()).get(ViewModelToViewNews.class);
        binding.setLifecycleOwner(getActivity());
        initRecyclerView();
        viewModelToViewNews.getArticleMutableLiveData().observe(getActivity(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                articleList.addAll(articles);
                viewNewsAdapter.setNewsList(articleList);
            }
        });

        viewModelToViewNews.getCategoryMutableLiveData().observe(getActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                adpterCategory.setData(categories, getString(R.string.selectCategory));
            }
        });

        return view;
    }

    void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.fragmentViewNewsRcvId.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= viewModelToViewNews.max) {
                    if (viewModelToViewNews.max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        viewModelToViewNews.setArticleMutableLiveData(apiKey, countryAbbreviation, current_page);

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        binding.fragmentViewNewsRcvId.addOnScrollListener(onEndLess);
        viewNewsAdapter = new ViewNewsAdapter(getActivity());
        binding.fragmentViewNewsRcvId.setAdapter(viewNewsAdapter);

        articleList = new ArrayList<>();
        viewModelToViewNews.setArticleMutableLiveData(apiKey, countryAbbreviation, 1);


        // spinner
        adpterCategory = new SpinnerAdpter(getActivity());
        binding.fragmentViewNewsSpinnerCategory.setAdapter(adpterCategory);
        binding.fragmentViewNewsSpinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    viewModelToViewNews.Filter = true;
                    viewModelToViewNews.categoryValue = adpterCategory.list.get(adpterCategory.itemselected).getName();
                    articleList = new ArrayList<>();
                    viewModelToViewNews.setArticleMutableLiveData(apiKey, countryAbbreviation, 1);                    viewModelToViewNews.setArticleMutableLiveData(apiKey, countryAbbreviation, 1);
                } else {
                    viewModelToViewNews.Filter = false;
                    articleList = new ArrayList<>();
                    viewModelToViewNews.setArticleMutableLiveData(apiKey, countryAbbreviation, 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        intialFragment();
    }


    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}