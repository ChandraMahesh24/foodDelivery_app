package com.example.fooddelivery;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.fooddelivery.Adapters.MainAdapters;
import com.example.fooddelivery.Adapters.VerticalFoodAdapter;
import com.example.fooddelivery.Models.MainModels;
import com.example.fooddelivery.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private RecyclerView offerRecyclerView , bestSellerRecyclerView , foodRecyclerView , bestSellerRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);


        // image silder
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
            // imageList.add(new SlideModel("String Url" or R.drawable))
            // imageList.add(new SlideModel("String Url" or R.drawable, "title")) You can add title
        imageList.add(new SlideModel(R.drawable.off, "\uD83C\uDF89\uD83C\uDF7D️ Savor the Delights! Enjoy 25% off on your first order with code TASTEFUL25 \uD83C\uDF54\uD83C\uDF55", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.offer1, " \uD83C\uDF55\uD83E\uDD57 Family Feast Deal! 20% OFF on Orders Over $50! \uD83C\uDF5D\uD83E\uDD58", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.offer2, "\uD83D\uDD25\uD83C\uDF2E Taco Tuesday Fiesta! Buy 2 Tacos, Get 1 FREE! \uD83C\uDF89\uD83C\uDF2F",ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        // vertical image
        ArrayList<MainModels> list = new ArrayList<>();
        list.add(new MainModels(R.drawable.chicken_served_with_onions_chili_sauce, "Chicken chili", "200", "chicken served with onions chili sauce"));
        list.add(new MainModels(R.drawable.chicken_skewers_with_slices_sweet_peppers_dill, "Chicken dill", "340", "chicken skewers with slices sweet peppers dill"));
        list.add(new MainModels(R.drawable.closeup_shot_deliciously_prepared_chicken_served_with_onions_chili_sauce, "Chicken chili", "230", "closeup shot deliciously prepared chicken served with onions chili sauce"));
        list.add(new MainModels(R.drawable.delicious_chicken, "Chicken", "2340", "Delicious_chicken"));
        list.add(new MainModels(R.drawable.delicious_fish, "Fish", "280", "delicious_fish"));
        list.add(new MainModels(R.drawable.delicious_fries, "FRENCH FRIES", "260", "MASALA FRENCH FRIES"));
        list.add(new MainModels(R.drawable.curry_with_chicken_onions_indian_food_asian_cuisine, "Curry chicken", "239", "curry with chicken onions indian food asian cuisine"));
        list.add(new MainModels(R.drawable.delicious_vegan_salad_plate_stained_white_surface, "Salad", "150", "delicious vegan salad plate stained white surface"));
        list.add(new MainModels(R.drawable.hands_holding_shish_kebab_with_colorful_bell_peppers, "Shish Kebab", "350", "hands holding shish kebab with colorful bell peppers"));
        list.add(new MainModels(R.drawable.indian, "Indian", "450", "indian"));
        list.add(new MainModels(R.drawable.meat_cutlets_with_salad_bread, "meat cutlets", "320", "meat cutlets with salad bread"));
        list.add(new MainModels(R.drawable.paneer, "Paneer", "300", "Paneer"));
        list.add(new MainModels(R.drawable.pasata, "Pasta", "290", "pasta with tomato sauce"));
        list.add(new MainModels(R.drawable.wepik_export, "Pasta", "322", "pasta with tomato sauce"));
        list.add(new MainModels(R.drawable.wepik_export_vag, "Pasta", "220", "pasta with tomato sauce"));
        list.add(new MainModels(R.drawable.pasata, "Pasta", "210", "pasta with tomato sauce"));
        MainAdapters adapter = new MainAdapters(list, this);
        binding.recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);

        //horizontal image
        ArrayList<MainModels> list2 = new ArrayList<>();
        list2.add(new MainModels(R.drawable.chicken_served_with_onions_chili_sauce, "Chicken chili", "200", "chicken served with onions chili sauce"));
        list2.add(new MainModels(R.drawable.chicken_skewers_with_slices_sweet_peppers_dill, "Chicken dill", "340", "chicken skewers with slices sweet peppers dill"));
        list2.add(new MainModels(R.drawable.closeup_shot_deliciously_prepared_chicken_served_with_onions_chili_sauce, "Chicken chili", "230", "closeup shot deliciously prepared chicken served with onions chili sauce"));
        list2.add(new MainModels(R.drawable.delicious_chicken, "Chicken", "2340", "Delicious_chicken"));
        list2.add(new MainModels(R.drawable.delicious_fish, "Fish", "280", "delicious_fish"));
        list2.add(new MainModels(R.drawable.delicious_fries, "FRENCH FRIES", "260", "MASALA FRENCH FRIES"));
        list2.add(new MainModels(R.drawable.curry_with_chicken_onions_indian_food_asian_cuisine, "Curry chicken", "239", "curry with chicken onions indian food asian cuisine"));
        list2.add(new MainModels(R.drawable.delicious_vegan_salad_plate_stained_white_surface, "Salad", "150", "delicious vegan salad plate stained white surface"));
        list2.add(new MainModels(R.drawable.hands_holding_shish_kebab_with_colorful_bell_peppers, "Shish Kebab", "350", "hands holding shish kebab with colorful bell peppers"));
        list2.add(new MainModels(R.drawable.indian, "Indian", "450", "indian"));
        list2.add(new MainModels(R.drawable.meat_cutlets_with_salad_bread, "meat cutlets", "320", "meat cutlets with salad bread"));
        list2.add(new MainModels(R.drawable.paneer, "Paneer", "300", "Paneer"));
        list2.add(new MainModels(R.drawable.pasata, "Pasta", "290", "pasta with tomato sauce"));
        list2.add(new MainModels(R.drawable.wepik_export, "Pasta", "322", "pasta with tomato sauce"));
        list2.add(new MainModels(R.drawable.wepik_export_vag, "Pasta", "220", "pasta with tomato sauce"));
        list2.add(new MainModels(R.drawable.pasata, "Pasta", "210", "pasta with tomato sauce"));
        VerticalFoodAdapter adapter2 = new VerticalFoodAdapter(list2, this);
        binding.recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        binding.recyclerView2.setLayoutManager(layoutManager2);

        Button myOrderButton = findViewById(R.id.my_order_button);
        myOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });


        binding.searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<MainModels> filteredList = new ArrayList<>();

                if (binding.searchView.getText().length()>0) {
                    for(int i=0; i<list.size(); i++) {
                        if (list.get(i).getName().toLowerCase().contains(binding.searchView.getText().toString().toLowerCase())) {
                            filteredList.add(list.get(i));
                        }
                    }

                    adapter.filterData(filteredList);
                } else {
                    adapter.filterData(list);
                }
            }
        });

    }

}



