//package com.example.owner.mytintuc.utils;
//
///**
// * Created by Owner on 6/2/2018.
// */
//
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.support.v7.widget.RecyclerView;
//import android.widget.Toast;
//
//import com.example.owner.mytintuc.RSSParser;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//
///**
// * Created by chaut on 3/27/2018.
// */
//
//public class LoadData extends AsyncTask<Void, Void, Object> {
//    Context context;
//    String urlAddress;
//    RecyclerView recyclerView;
//
//    // ProgressDialog pd;
//
//    public LoadData(Context context, String urlAddress, RecyclerView recyclerView) {
//        this.context = context;
//        this.urlAddress = urlAddress;
//        this.recyclerView = recyclerView;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        //  pd=new ProgressDialog(c);
//        //   pd.setTitle("Fetch Article");
//        //  pd.setMessage("Fetching...Please wait");
//        //  pd.show();
//    }
//
//    @Override
//    protected Object doInBackground(Void... params) {
//        return downloadData();
//    }
//
//    @Override
//    protected void onPostExecute(Object data) {
//        super.onPostExecute(data);
//
//        // pd.dismiss();
//
//        if(data.toString().startsWith("Error"))
//        {
//            Toast.makeText(context, data.toString(), Toast.LENGTH_SHORT).show();
//        }else {
//            //PARSE
//            new RSSParser(context, (InputStream) data,recyclerView).execute();
//        }
//    }
//    private Object downloadData()
//    {
//        Object connection=com.example.owner.mytintuc.Connector.connect(urlAddress);
//        if(connection.toString().startsWith("Error"))
//        {
//            return connection.toString();
//        }
//
//        try
//        {
//            HttpURLConnection con= (HttpURLConnection) connection;
//            int responseCode=con.getResponseCode();
//
//            if(responseCode==con.HTTP_OK)
//            {
//                InputStream is=new BufferedInputStream(con.getInputStream());
//                return is;
//            }
//
//            return com.example.owner.mytintuc.ErrorTracker.RESPONSE_EROR+con.getResponseMessage();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return com.example.owner.mytintuc.ErrorTracker.IO_EROR;
//        }
//    }
//}