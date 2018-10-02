package com.example.android.visitoradea;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandmarksFragment extends Fragment {

    public LandmarksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final RecyclerAdapter adapter = new RecyclerAdapter(getContext(), generateAttractionList());

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    public List<Attraction> generateAttractionList() {
        List<Attraction> attractionList = new ArrayList<>();

        attractionList.add(new Attraction(this.getString(R.string.landmark_black_eagle_name), R.drawable.black_eagle_palace,
                this.getString(R.string.landmark_black_eagle_description),
                this.getString(R.string.landmark_black_eagle_address), this.getString(R.string.landmark_black_eagle_telephone),
                this.getString(R.string.landmark_black_eagle_website)));

        attractionList.add(new Attraction(this.getString(R.string.landmark_oradea_fortress_name), R.drawable.oradea_fortress,
                this.getString(R.string.landmark_oradea_fortress_description),
                this.getString(R.string.landmark_oradea_fortress_address), this.getString(R.string.landmark_oradea_fortress_telephone),
                this.getString(R.string.landmark_oradea_fortress_website)));

        attractionList.add(new Attraction(this.getString(R.string.landmark_zion_synagogue_name), R.drawable.zion_synagogue,
                this.getString(R.string.landmark_zion_synagogue_description),
                this.getString(R.string.landmark_zion_synagogue_address), this.getString(R.string.landmark_zion_synagogue_telephone),
                this.getString(R.string.landmark_zion_synagogue_website)));

        attractionList.add(new Attraction(this.getString(R.string.landmark_sztarill_palace_name), R.drawable.sztarill_palace,
                this.getString(R.string.landmark_sztarill_palace_description),
                this.getString(R.string.landmark_sztarill_palace_address), this.getString(R.string.landmark_sztarill_palace_telephone),
                this.getString(R.string.landmark_sztarill_palace_website)));

        return attractionList;
    }
}
