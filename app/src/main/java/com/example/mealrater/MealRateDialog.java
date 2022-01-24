package com.example.mealrater;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Rating;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RatingBar;

import java.util.Calendar;

public class MealRateDialog extends DialogFragment {
    int rating;

    public interface SaveRateListener {
        void didFinishMealRateDialog(int selectedRate);
    }

    public MealRateDialog() {
        // Empty constructor required for DialogFragment
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        final View view = inflater.inflate(R.layout.rate_meal, container);

        getDialog().setTitle("Rate the Dish");


        final RatingBar rb = view.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rate, boolean b) {
                ratingBar.setRating(rate);
                rating = (int)(ratingBar.getRating());
            }

        });
        Button saveButton = view.findViewById(R.id.saveRate);
        saveButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                saveItem(rating);

            }
        });
        return view;

    }
    private void saveItem(int selectedRate) {
        SaveRateListener activity = (SaveRateListener) getActivity();
        activity.didFinishMealRateDialog (selectedRate);
        getDialog().dismiss();


    }

}





