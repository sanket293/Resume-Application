package com.sanketvagadiya.Constants;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetOnlineData extends AsyncTask<Void, Void, JSONObject> {

    String url = "";
    String jsonStr;

    JSONObject jsonObject;

    public GetOnlineData(String url) {
        this.url = url;
    }


    @Override
    protected JSONObject doInBackground(Void... voids) {

        try {
            URL url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            jsonStr = reader.readLine();

            jsonObject = new JSONObject(jsonStr);
            Log.e("jsonObj GetOnlineData", "." + jsonObject.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
