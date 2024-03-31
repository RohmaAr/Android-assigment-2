package com.example.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(ArrayList<Restaurant> rest) {
        this.restaurants = rest;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.restaurantview, parent, false);
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.tvName.setText(restaurants.get(position).getName());
        holder.tvAbout.setText(restaurants.get(position).getDesc());
        holder.tvPhone.setText(restaurants.get(position).getPhone());
        holder.tvLoc.setText(restaurants.get(position).getLoc());
        holder.tvRatings.setText(restaurants.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvPhone,tvLoc,tvAbout,tvRatings;
        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvLoc=itemView.findViewById(R.id.tvlocation);
            tvPhone=itemView.findViewById(R.id.tvnumber);
            tvAbout=itemView.findViewById(R.id.tvabout);
            tvRatings=itemView.findViewById(R.id.ratings);
        }
    }
}
