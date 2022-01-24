package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MealRateDialog.SaveRateListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChangeRateButton();

    }

    @Override
    public void didFinishMealRateDialog (int selectedRate) {
        TextView rating = findViewById(R.id.ratingShow);
        rating.setText (selectedRate + " stars");
    }

    private void initChangeRateButton() {
        Button changeRate = findViewById (R.id.changeRate);
        changeRate.setOnClickListener (new View.OnClickListener() {

            public void onClick (View view) {
                FragmentManager fm = getSupportFragmentManager();
                MealRateDialog mealRateDialog = new MealRateDialog();
                mealRateDialog.show(fm,"MealRate");
            }
        });
    }


}