package com.walmart.orderstreamerapplication.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.walmart.orderstreamerapplication.R;

import java.io.IOException;
import java.io.InputStream;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = new Intent(this, LoadDataActivity.class);
        startActivity(intent);


    }

}
