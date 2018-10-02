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
public class ParksFragment extends Fragment {

    public ParksFragment() {
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

        attractionList.add(new Attraction(this.getString(R.string.park_1_december_name),
                R.drawable.park_1_december, this.getString(R.string.park_1_december_description),
                this.getString(R.string.park_1_december_address)));

        attractionList.add(new Attraction(this.getString(R.string.park_cris_river_meadow_name),
                R.drawable.park_cris_river_meadow, this.getString(R.string.park_cris_river_meadow_description),
                this.getString(R.string.park_cris_river_meadow_address)));

        attractionList.add(new Attraction(this.getString(R.string.park_oradea_zoo_name),
                R.drawable.park_zoo, this.getString(R.string.park_oradea_zoo_description),
                this.getString(R.string.park_oradea_zoo_address), this.getString(R.string.park_oradea_zoo_telephone),
                this.getString(R.string.park_oradea_zoo_website)));

        return attractionList;
    }
}
