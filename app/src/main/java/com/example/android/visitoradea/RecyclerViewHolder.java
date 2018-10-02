package com.example.android.visitoradea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The RecyclerViewHolder is used along with the RecyclerAdapter to display the attraction cards
 * Sources used in building them:
 * https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern/
 * https://www.binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView attractionImageView;
    private TextView attractionTextView;
    private TextView addressTextView;

    public RecyclerViewHolder(final View itemView) {
        super(itemView);
        attractionImageView = itemView.findViewById(R.id.image_card);
        attractionTextView = itemView.findViewById(R.id.text_card_title);
        addressTextView = itemView.findViewById(R.id.text_card_address);
    }

    public void bindData(final Context context, final Attraction clickedAttraction) {
        attractionImageView.setImageResource(clickedAttraction.getAttractionImage());
        attractionTextView.setText(clickedAttraction.getAttractionName());
        addressTextView.setText(clickedAttraction.getAttractionAddress());

        // Set up an intent that opens the AttractionDetailActivity
        final Intent detailsIntent = new Intent(context, AttractionDetailActivity.class);

        // Prepare a bundle with all the necessary information to display
        Bundle attractionBundle = new Bundle();
        attractionBundle.putInt("IMAGE", clickedAttraction.getAttractionImage());
        attractionBundle.putBoolean("HAS_TELEPHONE", clickedAttraction.hasTelephone());
        attractionBundle.putBoolean("HAS_WEBSITE", clickedAttraction.hasWebsite());
        attractionBundle.putString("NAME", clickedAttraction.getAttractionName());
        attractionBundle.putString("DESCRIPTION", clickedAttraction.getAttractionDescription());
        attractionBundle.putString("ADDRESS", clickedAttraction.getAttractionAddress());
        attractionBundle.putString("TELEPHONE", clickedAttraction.getAttractionTelephone());
        attractionBundle.putString("WEBSITE", clickedAttraction.getAttractionWebsite());

        detailsIntent.putExtras(attractionBundle);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                context.startActivity(detailsIntent);

            }
        });

    }

}