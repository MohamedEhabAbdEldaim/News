package com.midooabdaim.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.news.R;
import com.midooabdaim.news.data.model.NewsModel.Article;
import com.midooabdaim.news.data.model.NewsModel.News;
import com.midooabdaim.news.databinding.ItemViewNewsBinding;
import com.midooabdaim.news.ui.activity.MainActivity;
import com.midooabdaim.news.ui.fragment.NewsDetailsFragment;
import com.midooabdaim.news.ui.fragment.dataNewsForCountry.ViewNewsDataFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.news.helper.HelperMethod.onLoadImageFromUrl;
import static com.midooabdaim.news.helper.HelperMethod.replaceFragment;


public class ViewNewsAdapter extends RecyclerView.Adapter<ViewNewsAdapter.ViewHolder> {
    private Context context;
    private List<Article> newsList = new ArrayList<>();

    public ViewNewsAdapter(Context context) {
        this.context = context;

    }

    public void setNewsList(List<Article> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewNewsBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_view_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewNewsAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        onLoadImageFromUrl(holder.itemViewNewsBinding.itemViewNewsImvNewsImage,
                newsList.get(position).getUrlToImage(), context);

        holder.itemViewNewsBinding.itemViewNewsTxtNewsTittle.setText(newsList.get(position).getTitle());


    }

    private void setAction(ViewHolder holder, final int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
                newsDetailsFragment.article = newsList.get(position);
                replaceFragment(((MainActivity) context).getSupportFragmentManager(), R.id.main_Activity_frame_layout_id, newsDetailsFragment);
            }
        });

    }


    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemViewNewsBinding itemViewNewsBinding;
        private View view;

        public ViewHolder(ItemViewNewsBinding binding) {
            super(binding.getRoot());
            view = binding.getRoot();
            itemViewNewsBinding = binding;
        }
    }
}
