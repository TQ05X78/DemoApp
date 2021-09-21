package com.example.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.model.Groceries;

import java.util.List;

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesAdapter.GroseriesViewHolder> {

    Context context;
    List<Groceries> groceriesList;

    public GroceriesAdapter(Context context, List<Groceries> groceriesList) {
        this.context = context;
        this.groceriesList = groceriesList;
    }

    @NonNull
    @Override
    public GroseriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.groceries,parent,false);
        return new GroseriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroseriesViewHolder holder, int position) {

        holder.imageView.setImageResource(groceriesList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return groceriesList.size();
    }

    public class GroseriesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public GroseriesViewHolder(@NonNull View itemView) {
            super(itemView);

          imageView = itemView.findViewById(R.id.groceriesImage);


        }
    }
}
