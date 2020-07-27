package com.midooabdaim.news.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.midooabdaim.news.R;
import com.midooabdaim.news.data.model.NewsModel.Article;
import com.midooabdaim.news.databinding.FragmentNewsDetailsBinding;
import com.midooabdaim.news.ui.fragment.BaseFragment;

import static com.midooabdaim.news.helper.HelperMethod.customToast;
import static com.midooabdaim.news.helper.HelperMethod.onLoadImageFromUrl;


public class NewsDetailsFragment extends BaseFragment {
    FragmentNewsDetailsBinding binding;
    public Article article;

    public NewsDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        // return inflater.inflate(R.layout.fragment_news_details, container, false);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_details, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(getActivity());
        setView();
        return view;
    }

    private void setView() {
        onLoadImageFromUrl(binding.fragmentNewsDetailsImvNewsImage, article.getUrlToImage(), getActivity());
        binding.fragmentNewsDetailsTxtNewsTittle.setText(article.getTitle());
        binding.fragmentNewsDetailsTxtNewsPublishedAt.setText("publishedAt : " + article.getPublishedAt());
        binding.fragmentNewsDetailsTxtNewsAuthor.setText("Author : " + article.getAuthor());
        binding.fragmentNewsDetailsTxtNewsDescription.setText("Description : " + article.getDescription());
        binding.fragmentNewsDetailsTxtNewsContent.setText("Content : " + article.getContent());
        binding.fragmentNewsDetailsTxtNewsShowSource.setText("Source" + article.getSource().getName());
        binding.fragmentNewsDetailsTxtShowUrl.setText("URL : " + article.getUrl());
        binding.fragmentNewsDetailsTxtShowUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(article.getUrl());
            }
        });

    }

    public void openWebPage(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                getActivity().startActivity(intent);
            }
        } catch (Exception e) {
            customToast(getActivity(), e.getMessage(), true);
        }

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