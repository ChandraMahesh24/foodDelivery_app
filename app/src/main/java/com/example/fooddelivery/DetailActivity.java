package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fooddelivery.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    private int itemCount = 1;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image=getIntent().getIntExtra("image",0);
        price= Integer.parseInt(getIntent().getStringExtra("price"));
        final String name= getIntent().getStringExtra("name");
        final String Description= getIntent().getStringExtra("Description");


        binding.detailImage.setImageResource(image);
        binding.priceDetail.setText(String.format("%d",price));
        binding.foodName.setText(name);
        binding.detailDescription.setText(Description);

        dBHelper helper= new dBHelper(this);
        binding.insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemCount == 0) {
                    Toast.makeText(DetailActivity.this, "Please add an item", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (binding.nameBox.getText().toString().isEmpty()) {
                    binding.nameBox.setError("Required");
                } else if (binding.phoneBox.getText().toString().isEmpty()) {
                    binding.phoneBox.setError("Required");
                } else {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            Description,
                            Integer.parseInt(binding.itemCount.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "data success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.subtract.setOnClickListener(v -> {
            if (itemCount>1) {
                itemCount--;
                updateText();
            }
        });

        binding.addItem.setOnClickListener(v -> {
            itemCount++;
            updateText();
        });

    }

    private void updateText() {
        binding.itemCount.setText(itemCount+"");

        binding.priceDetail.setText(price*itemCount+"");
    }

}