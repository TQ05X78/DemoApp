package com.example.demoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.ProductDetailActivity;
import com.example.demoapp.R;
import com.example.demoapp.model.ExclusiveOffer;

import java.util.List;

public class ExclusiveAdapter extends RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder> {

    Context context;
    List<ExclusiveOffer> exclusiveOfferList;


    public ExclusiveAdapter(Context context, List<ExclusiveOffer> exclusiveOfferList) {
        this.context = context;
        this.exclusiveOfferList = exclusiveOfferList;
    }

    @NonNull
    @Override
    public ExclusiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exclusive_offer,parent,false);
        return new ExclusiveViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ExclusiveViewHolder holder,  int position) {

        holder.name.setText(exclusiveOfferList.get(position).getName());
        holder.price.setText(exclusiveOfferList.get(position).getPrice());
        holder.unit.setImageResource(exclusiveOfferList.get(position).getUnit());
        holder.quantity.setText(exclusiveOfferList.get(position).getQuantity());
        holder.imageView.setImageResource(exclusiveOfferList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, ProductDetailActivity.class);
                i.putExtra("name",exclusiveOfferList.get(position).getName());
                i.putExtra("price",exclusiveOfferList.get(position).getPrice());
                i.putExtra("image",exclusiveOfferList.get(position).getImageUrl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exclusiveOfferList.size();
    }

    public class ExclusiveViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, unit;
        TextView price, quantity,  name;

        public ExclusiveViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage_expand);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            unit = itemView.findViewById(R.id.addItem);

        }
    }
}







