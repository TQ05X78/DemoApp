package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.demoapp.adapter.BestSellingAdapter;
import com.example.demoapp.adapter.ExclusiveAdapter;
import com.example.demoapp.adapter.GroceriesAdapter;
import com.example.demoapp.adapter.SliderAdapterExample;
import com.example.demoapp.model.BestSelling;
import com.example.demoapp.model.ExclusiveOffer;
import com.example.demoapp.model.Groceries;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView exclusiveRec, bestSellingRec, groceriesRec;
    List<ExclusiveOffer> exclusiveOfferList;
    ExclusiveAdapter exclusiveAdapter;

    List<BestSelling> bestSellingList;
    BestSellingAdapter bestSellingAdapter;


    List<Groceries> groceriesList;
    GroceriesAdapter groceriesAdapter;


    SliderView sliderView;
    int[] images = {R.drawable.slide1,
                   R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5};
    private SliderAdapterExample adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exclusiveRec = findViewById(R.id.rec_exclusive);
        bestSellingRec = findViewById(R.id.best_selling_rec);
        groceriesRec = findViewById(R.id.grocery_rec);

        getSupportActionBar().hide();

        sliderView = findViewById(R.id.imageSlider);


        SliderAdapterExample sliderAdapterExample = new SliderAdapterExample(images);

        sliderView.setSliderAdapter(sliderAdapterExample);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        exclusiveOfferList = new ArrayList<>();
        exclusiveOfferList.add(new ExclusiveOffer("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg1));
        exclusiveOfferList.add(new ExclusiveOffer("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg2));
        exclusiveOfferList.add(new ExclusiveOffer("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg4));
        exclusiveOfferList.add(new ExclusiveOffer("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg5));

        setExclusiveOffer(exclusiveOfferList);



        bestSellingList = new ArrayList<>();
        bestSellingList.add(new BestSelling("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veggg));

        bestSellingList.add(new BestSelling("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg2));
        bestSellingList.add(new BestSelling("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg4));
        bestSellingList.add(new BestSelling("fruit","$4.99","7pcs, Priceg",R.drawable.ic_baseline_add_24,R.drawable.veg5));

        setBestSelling(bestSellingList);



        groceriesList = new ArrayList<>();
        groceriesList.add(new Groceries(R.drawable.slide5));
        groceriesList.add(new Groceries(R.drawable.slide3));

        setGroceries(groceriesList);





    }

    private void setGroceries(List<Groceries> dataL) {

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        groceriesRec.setLayoutManager(layoutManager);
        groceriesAdapter =new GroceriesAdapter(this,dataL);
        groceriesRec.setAdapter(groceriesAdapter);

    }

    private void setBestSelling(List<BestSelling> dataList2) {


        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        bestSellingRec.setLayoutManager(layoutManager);
        bestSellingAdapter =new BestSellingAdapter(this,dataList2);
        bestSellingRec.setAdapter(bestSellingAdapter);

    }

    private void setExclusiveOffer(List<ExclusiveOffer> dataList) {

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        exclusiveRec.setLayoutManager(layoutManager);
        exclusiveAdapter =new ExclusiveAdapter(this,dataList);
        exclusiveRec.setAdapter(exclusiveAdapter);



    }


}



