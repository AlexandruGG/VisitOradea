package com.example.android.visitoradea;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link AttractionAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Attraction} objects.
 */
public class AttractionAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context FragmentContext;

    /**
     * Create a new {@link AttractionAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */

    public AttractionAdapter(Context context, FragmentManager fm) {
        super(fm);
        FragmentContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LandmarksFragment();
            case 1:
                return new ParksFragment();
            case 2:
                return new FoodFragment();
            default:
                return new ActivitiesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Return the title of the tab.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return FragmentContext.getResources().getString(R.string.attraction_landmarks);
            case 1:
                return FragmentContext.getResources().getString(R.string.attraction_parks);
            case 2:
                return FragmentContext.getResources().getString(R.string.attraction_food);
            default:
                return FragmentContext.getResources().getString(R.string.attraction_activities);
        }
    }
}
