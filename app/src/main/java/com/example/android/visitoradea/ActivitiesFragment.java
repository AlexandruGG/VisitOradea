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
public class ActivitiesFragment extends Fragment {

    public ActivitiesFragment() {
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

        attractionList.add(new Attraction(this.getString(R.string.activities_state_theatre_name), R.drawable.activities_state_theatre,
                this.getString(R.string.activities_state_theatre_description),
                this.getString(R.string.activities_state_theatre_address), this.getString(R.string.activities_state_theatre_telephone),
                this.getString(R.string.activities_state_theatre_website)));

        attractionList.add(new Attraction(this.getString(R.string.activities_nymphaea_aquapark_name), R.drawable.activities_nymphaea_aquapark,
                this.getString(R.string.activities_nymphaea_aquapark_description),
                this.getString(R.string.activities_nymphaea_aquapark_address), this.getString(R.string.activities_nymphaea_aquapark_telephone),
                this.getString(R.string.activities_nymphaea_aquapark_website)));

        return attractionList;
    }
}
