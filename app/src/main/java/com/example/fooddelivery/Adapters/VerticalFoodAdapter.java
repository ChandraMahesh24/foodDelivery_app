package com.example.fooddelivery.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.DetailActivity;
import com.example.fooddelivery.MainActivity;
import com.example.fooddelivery.Models.MainModels;
import com.example.fooddelivery.Models.OrderModal;
import com.example.fooddelivery.R;

import java.util.ArrayList;

 public class VerticalFoodAdapter extends RecyclerView.Adapter<com.example.fooddelivery.Adapters.MainAdapters.viewHolder>{
        //public  class  MainAdapters extends  RecyclerView.Adapter<RecyclerView.Adapter.viewHolder>{
        ArrayList<MainModels> list;
        Context context;

        public VerticalFoodAdapter(ArrayList<MainModels> list, MainActivity mainActivity) {
            this.list=list;
            this.context=mainActivity;
        }

        @NonNull
        @Override
        public com.example.fooddelivery.Adapters.MainAdapters.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.vertical_food,parent,false);
            return new com.example.fooddelivery.Adapters.MainAdapters.viewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.fooddelivery.Adapters.MainAdapters.viewHolder holder, int position) {
            final MainModels models=list.get(position);
            holder.foodImage.setImageResource(models.getImage());
            holder.mainName.setText(models.getName());
            holder.price.setText(models.getPrice());
            holder.description.setText(models.getDescription());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, DetailActivity.class);
                    intent.putExtra("image",models.getImage());
                    intent.putExtra("price",models.getPrice());
                    intent.putExtra("name",models.getName());
                    intent.putExtra("Description",models.getDescription());
                    context.startActivity(intent);
                }
            });
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
        public static class viewHolder extends RecyclerView.ViewHolder{

            ImageView foodImage;
            TextView mainName ,price, description;
            public viewHolder(@NonNull View itemView) {
                super(itemView);
                foodImage = itemView.findViewById(R.id.imageView);
                mainName = itemView.findViewById(R.id.name);
                price = itemView.findViewById(R.id.price);
                description = itemView.findViewById(R.id.description);
            }
        }
        public void filterData(ArrayList<MainModels> filteredList) {
            list = filteredList;
            notifyDataSetChanged();
        }
    }