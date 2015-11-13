package com.walmart.orderstreamerapplication.activities;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.walmart.orderstreamerapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class LoadDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        String s =  readJSONFromAsset();
        parseJSON(s);

    }



    //1. Read JSON input data from Asset directory
    public String readJSONFromAsset() {
        String json = null;

        try {
            InputStream is = getAssets().open("1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.v("ORDER JSON=", json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    //2. Parse JSON
    public void parseJSON(String inputStr) {
        try {
            JSONObject jsonObject = new JSONObject(inputStr);
            JSONObject orderObject= jsonObject.getJSONObject("TSOrder");
            //Log.v("Order=", orderObject.toString());
            String storeNo = orderObject.getJSONObject("RecordInfo").getString("StoreNo");
            String orderTotal = orderObject.getJSONObject("OrderInfo").getString("OrderTotal");
            String orderNumber = orderObject.getJSONObject("OrderInfo").getString("OrderNumber");
            String scheduleTimeSlot = orderObject.getJSONObject("OrderInfo").getString("ScheduleTimeSlot");
            String postCode = orderObject.getJSONObject("CustomerInfo").getJSONObject("CustomerAddress").getString("PostCode");


            Log.v("OrderData=>", String.format("StoreNo=%s  OrderTotal=%s OrderNumber=%s Slot=%s PostCode=%s\n",
            storeNo, orderTotal, orderNumber, scheduleTimeSlot, postCode
            ));



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
