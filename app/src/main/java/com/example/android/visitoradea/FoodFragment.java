package com.example.android.visitoradea;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final RecyclerAdapter adapter = new RecyclerAdapter(getContext(), generateAttractionList());

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    public List<Attraction> generateAttractionList() {
        List<Attraction> attractionList = new ArrayList<>();

        attractionList.add(new Attraction(this.getString(R.string.food_rivo_name), R.drawable.food_rivo,
                this.getString(R.string.food_rivo_description),
                this.getString(R.string.food_rivo_address), this.getString(R.string.food_rivo_telephone),
                this.getString(R.string.food_rivo_website)));

        attractionList.add(new Attraction(this.getString(R.string.food_corsarul_name), R.drawable.food_corsarul,
                this.getString(R.string.food_corsarul_description),
                this.getString(R.string.food_corsarul_address), this.getString(R.string.food_corsarul_telephone),
                this.getString(R.string.food_corsarul_website)));

        attractionList.add(new Attraction(this.getString(R.string.food_ristretto_name), R.drawable.food_ristretto,
                this.getString(R.string.food_ristretto_description),
                this.getString(R.string.food_ristretto_address), this.getString(R.string.food_ristretto_telephone),
                this.getString(R.string.food_ristretto_website)));

        return attractionList;
    }
}
