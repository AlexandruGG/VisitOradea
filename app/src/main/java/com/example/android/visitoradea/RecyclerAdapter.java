package com.example.android.visitoradea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * The RecyclerAdapter is used along with the RecyclerViewHolder to display the attraction cards
 * Sources used in building them:
 * https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern/
 * https://www.binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156
 */
public class RecyclerAdapter extends RecyclerView.Adapter {

    private List<Attraction> attractionList;
    private Context recyclerContext;

    public RecyclerAdapter(Context context, List<Attraction> attractionList) {
        recyclerContext = context;
        this.attractionList = attractionList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((RecyclerViewHolder) holder).bindData(recyclerContext, attractionList.get(position));
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.card_item;
    }
}
