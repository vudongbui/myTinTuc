package com.example.owner.mytintuc;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Owner on 6/16/2018.
 */

//public class HTMLPageDownloader extends AsyncTask<Void, Void, String> {
//    public static interface HTMLPageDownloaderListener {
//        public abstract void completionCallBack(String html);
//    }
//    public HTMLPageDownloaderListener listener;
//    public String link;
//    public HTMLPageDownloader (String aLink, HTMLPageDownloaderListener aListener) {
//        listener = aListener;
//        link = aLink;
//    }
////
//    @Override
//    protected String doInBackground(Void... params) {
//        // TODO Auto-generated method stub
////        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet(link);
//        String html = "";
//        try {
//            HttpResponse response = client.execute(request);
//            InputStream in;
//            in = response.getEntity().getContent();
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(in));
//            StringBuilder str = new StringBuilder();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                str.append(line);
//            }
//            in.close();
//            html = str.toString();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return html;
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        // TODO Auto-generated method stub
//        super.onPostExecute(result);
//        if (!isCancelled()) {
//            listener.completionCallBack(result);
//        }
//    }
//}