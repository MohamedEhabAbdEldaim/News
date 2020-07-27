package com.midooabdaim.news.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {
    private Context context;
    // private List<ResturantData> restaurantDataList = new ArrayList<>();


  /*  public homeResterentRecyclreAdapter(Context context, List<ResturantData> restaurantDataList) {
        this.context = context;
        this.restaurantDataList = restaurantDataList;
    }
*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       /* ItemResterentsBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_resterents, parent, false);

        return new ViewHolder(binding);*/
        return null;
    }

    @Override
    public void onBindViewHolder(EmptyAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
       /* onLoadImageFromUrl(holder.itemResterentsBinding.itemResterentsImageViewRestaurant, restaurantDataList.get(position).getPhotoUrl(), context);
        holder.itemResterentsBinding.itemResterentsTvRestaurantName.setText(restaurantDataList.get(position).getName());
        holder.itemResterentsBinding.itemResterentsRatingBarRestaurant.setRating(restaurantDataList.get(position).getRate());
        holder.itemResterentsBinding.itemResterentsTvLimitToDelivery.setText(context.getString(R.string.limitstodelivery) + " : " + restaurantDataList.get(position).getMinimumCharger());
        holder.itemResterentsBinding.itemResterentsTvDeliveryCost.setText(context.getString(R.string.dliverycost) + " : " + restaurantDataList.get(position).getDeliveryCost());
        if (restaurantDataList.get(position).getAvailability().equals("open")) {
            holder.itemResterentsBinding.itemResterentsIvAvailable.setImageResource(R.drawable.ic_check_circle_green_24dp);
        } else {
            holder.itemResterentsBinding.itemResterentsIvAvailable.setImageResource(R.drawable.ic_check_circle_red_24dp);
        }

        holder.itemResterentsBinding.itemResterentTvRestaurantAvailable.setText(restaurantDataList.get(position).getAvailability());

*/
    }

    private void setAction(ViewHolder holder, final int position) {
       /* holder.itemResterentsBinding.itemResterentsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESTERENT_NAME = restaurantDataList.get(position).getName();
                RESTERENT_ID = restaurantDataList.get(position).getId();
                replaceFragment(((homeActivity) context).getSupportFragmentManager(), R.id.home_activity_fl_fragment, new resterentDaitalsFragment());
            }
        });*/

    }


    @Override
    public int getItemCount() {
//        return restaurantDataList.size();
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        //      private ItemResterentsBinding itemResterentsBinding;
       /* public ViewHolder(ItemResterentsBinding binding) {
            super(binding.getRoot());
            itemResterentsBinding = binding;
        }*/
    }
}
