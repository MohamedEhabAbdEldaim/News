package com.midooabdaim.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.news.R;
import com.midooabdaim.news.data.model.Country;
import com.midooabdaim.news.databinding.ItemCountryBinding;
import com.midooabdaim.news.ui.activity.MainActivity;
import com.midooabdaim.news.ui.fragment.dataNewsForCountry.ViewNewsDataFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.news.helper.HelperMethod.replaceFragment;


public class ViewCountryAdapter extends RecyclerView.Adapter<ViewCountryAdapter.ViewHolder> {
    private Context context;
    private List<Country> countryList = new ArrayList<>();


    public ViewCountryAdapter(Context context) {
        this.context = context;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        ItemCountryBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_country, parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewCountryAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.itemCountryBinding.itemCountryImvCountryImage.setImageResource(countryList.get(position).getImage());
        holder.itemCountryBinding.itemCountryTxtCountryName.setText(countryList.get(position).getCountryName());

    }

    private void setAction(final ViewHolder holder, final int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewNewsDataFragment newsDataFragment = new ViewNewsDataFragment();
                newsDataFragment.countryAbbreviation = countryList.get(position).getCountryAbbreviation();
                replaceFragment(((MainActivity) context).getSupportFragmentManager(), R.id.main_Activity_frame_layout_id, newsDataFragment);
            }
        });

    }


    @Override
    public int getItemCount() {
        if (countryList == null)
            return 0;
        return countryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCountryBinding itemCountryBinding;
        private View view;

        public ViewHolder(ItemCountryBinding binding) {
            super(binding.getRoot());
            view = binding.getRoot();
            itemCountryBinding = binding;
        }
    }
}
