package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imageView, back;
    TextView productNmae, quanity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().hide();

        Intent i =getIntent();
        String name = i.getStringExtra("name");
        String price = i.getStringExtra("price");
        int image = i.getIntExtra("image",R.drawable.carrot);
        productNmae = findViewById(R.id.productName);
        quanity = findViewById(R.id.quantity);
        imageView = findViewById(R.id.imgProduct);
        back = findViewById(R.id.imgBack);

        imageView.setImageResource(image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProductDetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}