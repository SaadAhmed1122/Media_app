package com.example.media_app;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.media_app.model.model_rec_one;

import java.util.ArrayList;
import java.util.List;

public class HomeFrag extends Fragment {
    private RecyclerView horizontal_recycler_view;
    private ArrayList<model_rec_one> horizontalList;
    private adaptor_recyler_one horizontalAdapter;
    Context context;

    public HomeFrag(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Slider Image
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModel = new ArrayList<>();
        slideModel.add(new SlideModel(R.drawable.drama2));
        slideModel.add(new SlideModel(R.drawable.drama));
        slideModel.add(new SlideModel(R.drawable.baba_jani));
        imageSlider.setImageList(slideModel,true);

        // First Recycler View
        horizontal_recycler_view= (RecyclerView) view.findViewById(R.id.horizental_recy_view);
        horizontalList = new ArrayList<model_rec_one>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            horizontalList.add(new model_rec_one(
                    MyData.nameArray[i],
                    MyData.drawableArray[i]
            ));
        }
        horizontalAdapter=new adaptor_recyler_one(horizontalList);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        return view;

    }
}