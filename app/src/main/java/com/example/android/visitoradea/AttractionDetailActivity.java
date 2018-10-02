package com.example.android.visitoradea;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AttractionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_details);

        ImageView attractionImage;
        TextView attractionName;
        TextView attractionDescription;
        TextView attractionAddress;
        TextView attractionTelephone;
        TextView attractionWebsite;
        LinearLayout telephoneLayout;
        LinearLayout websiteLayout;

        // Initializing UI elements
        attractionImage = findViewById(R.id.image_attraction_detail_view);
        attractionName = findViewById(R.id.text_attraction_title);
        attractionDescription = findViewById(R.id.text_attraction_description);
        attractionAddress = findViewById(R.id.text_attraction_address);
        attractionTelephone = findViewById(R.id.text_attraction_telephone);
        attractionWebsite = findViewById(R.id.text_attraction_website);
        telephoneLayout = findViewById(R.id.layout_attraction_telephone);
        websiteLayout = findViewById(R.id.layout_attraction_website);

        // Get bundle with intent extras (info to be displayed about the attraction)
        final Bundle detailsBundle = getIntent().getExtras();
        attractionImage.setImageResource(detailsBundle.getInt("IMAGE", 0));
        attractionName.setText(detailsBundle.getString("NAME"));
        attractionDescription.setText(detailsBundle.getString("DESCRIPTION"));
        attractionAddress.setText(detailsBundle.getString("ADDRESS"));

        // Some attractions, like parks, might not have a telephone and website. Therefore, views are hidden
        if (detailsBundle.getBoolean("HAS_TELEPHONE")) {
            attractionTelephone.setText(detailsBundle.getString("TELEPHONE"));
        } else telephoneLayout.setVisibility(View.GONE);

        if (detailsBundle.getBoolean("HAS_WEBSITE")) {
            attractionWebsite.setText(detailsBundle.getString("WEBSITE"));
        } else websiteLayout.setVisibility(View.GONE);

        // The two lines of code below set the color for the address TextView and underline it
        // Credit1: https://android--code.blogspot.co.uk/2015/05/android-textview-underline.html
        // Credit2: https://stackoverflow.com/questions/8472349/how-to-set-text-color-to-a-text-view-programmatically
        attractionAddress.setTextColor(Color.parseColor("#009688"));
        attractionAddress.setPaintFlags(attractionAddress.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Setting an click listener for the address (opens map app if the user clicks on it)
        attractionAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = String.format("geo:0,0?q= %s", detailsBundle.getString("ADDRESS"));
                Uri mapUri = Uri.parse(address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}