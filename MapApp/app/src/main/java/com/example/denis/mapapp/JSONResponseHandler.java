package com.example.denis.mapapp;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONResponseHandler implements ResponseHandler<List<String>> {

    private static final String MAIN_TAG = "main";
    private static final String TEMPERATURE_TAG = "temp";
    private static final String PRESSURE_TAG = "pressure";
    private static final String HUMIDITY_TAG = "humidity";
    private static final String TEMP_MIN_TAG = "temp_min";
    private static final String TEMP_MAX_TAG = "temp_max";


    @Override
    public List<String> handleResponse(HttpResponse response)
            throws ClientProtocolException, IOException {
        List<String> result = new ArrayList<String>();
        String JSONResponse = new BasicResponseHandler()
                .handleResponse(response);
        try {

            // Get top-level JSON Object - a Map
            JSONObject responseObject = (JSONObject) new JSONTokener(
                    JSONResponse).nextValue();

            Log.d("",responseObject.toString());



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}