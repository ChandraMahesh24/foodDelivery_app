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

import com.example.fooddelivery.Models.MainModels;
import com.example.fooddelivery.Models.OrderModal;
import com.example.fooddelivery.OrderActivity;
import com.example.fooddelivery.R;

import java.util.ArrayList;

public class foodAdapters  extends  RecyclerView.Adapter<foodAdapters.viewHolder>{

    ArrayList<OrderModal> list;
    Context context;

    public foodAdapters(ArrayList<OrderModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    public void onBindViewHolder(@NonNull OrderAdapters.viewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModal models=list.get(position);
        holder.orderImage.setImageResource(models.getOrderImg());
        holder.soldItemName.setText(models.getSoldItemName());
        holder.orderNumber.setText(models.getOrderNumber());
        holder.price.setText(models.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView orderImage;
        TextView soldItemName,orderNumber,price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.orderImage);
            soldItemName= itemView.findViewById(R.id.orderItemName);
            orderNumber = itemView.findViewById(R.id.orderNumber);
            price = itemView.findViewById(R.id.price1);
        }
    }
}
