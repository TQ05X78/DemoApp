package com.example.demoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.demoapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.Holder> {

    int[] images;

    public SliderAdapterExample(int[] images){
        this.images = images;
    }


    @Override
    public SliderAdapterExample.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterExample.Holder viewHolder, int position) {
           viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);

        imageView = itemView.findViewById(R.id.image_view);

        }
    }
}