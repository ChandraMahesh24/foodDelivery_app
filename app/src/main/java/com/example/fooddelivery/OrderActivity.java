package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.fooddelivery.Adapters.OrderAdapters;
import com.example.fooddelivery.Models.MainModels;
import com.example.fooddelivery.Models.OrderModal;
import com.example.fooddelivery.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dBHelper helper= new dBHelper(this);
        ArrayList<OrderModal>list=helper.getOrders();

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.orderRecylerView.setLayoutManager(layoutManager);
//        ArrayList<OrderModal>list=new ArrayList<>();
        OrderAdapters adapters = new OrderAdapters(list, this);
        binding.orderRecylerView.setAdapter(adapters);

//        list1.add(new OrderModal(R.drawable.chicken_served_with_onions_chili_sauce,"Chicken chili","200","00001"));
//        list1.add(new OrderModal(R.drawable.chicken_skewers_with_slices_sweet_peppers_dill,"Chicken dill","340","00002"));
//        list1.add(new OrderModal(R.drawable.closeup_shot_deliciously_prepared_chicken_served_with_onions_chili_sauce,"Chicken chili","230","00003"));
//        list1.add(new OrderModal(R.drawable.delicious_chicken,"Chicken","2340","00004"));
//        list1.add(new OrderModal(R.drawable.delicious_fish,"Fish","280","00005"));
//        list1.add(new OrderModal(R.drawable.delicious_fries,"FRENCH FRIES","260","00006"));
//        list1.add(new OrderModal(R.drawable.curry_with_chicken_onions_indian_food_asian_cuisine,"Curry chicken","239","00007"));
//        list1.add(new OrderModal(R.drawable.delicious_vegan_salad_plate_stained_white_surface,"Salad","150","00008"));
//        list1.add(new OrderModal(R.drawable.hands_holding_shish_kebab_with_colorful_bell_peppers,"Shish Kebab","350","00009"));
//        list1.add(new OrderModal(R.drawable.indian,"Indian","450","00010"));
//        list1.add(new OrderModal(R.drawable.meat_cutlets_with_salad_bread,"meat cutlets","320","00011"));
//        list1.add(new OrderModal(R.drawable.paneer,"Paneer","300","00012"));
//        list1.add(new OrderModal(R.drawable.pasata,"Pasta","290","00013"));
//        list1.add(new OrderModal(R.drawable.wepik_export,"Pasta","322","00014"));
//        list1.add(new OrderModal(R.drawable.wepik_export_vag,"Pasta","220","00015"));
//        list1.add(new OrderModal(R.drawable.pasata,"Pasta","210","00016"));

      //  StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
       // binding.orderRecylerView.setLayoutManager(staggeredGridLayoutManager);
    }
}