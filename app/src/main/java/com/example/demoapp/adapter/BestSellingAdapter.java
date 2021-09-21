package com.example.demoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.BestSellingDetailActivity;
import com.example.demoapp.ProductDetailActivity;
import com.example.demoapp.R;
import com.example.demoapp.model.BestSelling;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.BestSellingViewHolder> {

    Context context;
    List<BestSelling> bestSellingList;

    public BestSellingAdapter(Context context, List<BestSelling> bestSellingList) {
        this.context = context;
        this.bestSellingList = bestSellingList;
    }

    @NonNull
    @Override
    public BestSellingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_selling,parent,false);
        return new BestSellingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellingViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.name.setText(bestSellingList.get(position).getName());
        holder.price.setText(bestSellingList.get(position).getPrice());
        holder.unit.setImageResource(bestSellingList.get(position).getUnit());
        holder.quantity.setText(bestSellingList.get(position).getQuantity());
        holder.imageView.setImageResource(bestSellingList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, BestSellingDetailActivity.class);
                i.putExtra("name",bestSellingList.get(position).getName());
                i.putExtra("price",bestSellingList.get(position).getPrice());
                i.putExtra("image",bestSellingList.get(position).getImageUrl());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return bestSellingList.size();
    }

    public class BestSellingViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, unit;
        TextView price, quantity,  name;

        public BestSellingViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.itemImage_expand);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            unit = itemView.findViewById(R.id.addItem);
        }
    }
}
