package com.hmproductions.planetsdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MercuryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
