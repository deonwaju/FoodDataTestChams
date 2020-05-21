package com.deonolarewaju.foodapptest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deonolarewaju.foodapptest.R;
import com.deonolarewaju.foodapptest.Response.FoodDetailsResponseData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodDataAdapter extends RecyclerView.Adapter<FoodDataAdapter.MyViewHolder> {

    private List<FoodDetailsResponseData> foodList;
    private Context context;

    public FoodDataAdapter(List<FoodDetailsResponseData> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.food_details_activity, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FoodDetailsResponseData loginData = foodList.get(position);


        holder.txtFoodName.setText(loginData.getFoodName());
        holder.txtFoodPrice.setText(loginData.getAmount());
        holder.txtVendorname.setText(loginData.getVendorData().vendorName);

        if (!loginData.getFoodImage().imageUrl.isEmpty()) {
            Glide.with(context).asBitmap().load(loginData.getFoodImage().imageUrl).into(holder.imgFood);
        } else {
            Glide.with(context).asBitmap().load(R.drawable.ic_launcher_background).into(holder.imgFood);
        }


    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.food_name)
        TextView txtFoodName;
        @BindView(R.id.food_price)
        TextView txtFoodPrice;
        @BindView(R.id.food_img)
        ImageView imgFood;
        @BindView(R.id.vendor_name)
        TextView txtVendorname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
