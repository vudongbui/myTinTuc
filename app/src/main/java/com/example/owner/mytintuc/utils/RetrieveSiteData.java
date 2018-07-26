package com.example.owner.mytintuc.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.OkHttpClient;

/**
 * Created by Owner on 6/19/2018.
 */

public class RetrieveSiteData extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
        StringBuilder builder = new StringBuilder(100000);

//        for (String url : urls) {
//            OkHttpClient client = new OkHttpClient();
//            HttpGet httpGet = new HttpGet(url);
//            try {
//                HttpResponse execute = client.execute(httpGet);
//                InputStream content = execute.getEntity().getContent();
//
//                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
//                String s = "";
//                while ((s = buffer.readLine()) != null) {
//                    builder.append(s);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return builder.toString();
    }

    @Override
    protected void onPostExecute(String result) {

    }
}