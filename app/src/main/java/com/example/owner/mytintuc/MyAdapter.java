package com.example.owner.mytintuc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Owner on 5/22/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private static final String TAG = "link";
    public static final String LINK = "LINK";
    Context c;
    ArrayList<Article> articles;

    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Article article=articles.get(position);

        String title=article.getTitle();
        final String desc=article.getDescription();
        final String link = article.getLink();
        String date=article.getDate();
        String imageUrl=article.getImageUrl();

       // Log.d(TAG, "onBindViewHolder: "+imageUrl);
        holder.titleTxt.setText(title);
//        holder.desctxt.setText(desc.substring(0,130));
        holder.dateTxt.setText(date);
        Picasso.get().load(imageUrl).into(holder.img);
//        Picasso.with(c).load(R.drawable.health96).into(holder.img);
       // holder.img.setImageResource(R.mipmap.dantrivn);
//        holder.ivdown.setImageResource(R.drawable.ic_file_download_black_24dp);
//        holder.ivdown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: " + "down.....");
//                String html = "";
//                try {
//                    getHtml(link,html);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Log.d(TAG, "onClick: "+html.charAt(10));
//                Ion.with(c.getApplicationContext()).
//                        load(link)
//                        .asString()
//                        .setCallback(new FutureCallback<String>()
//                        {
//                            @Override
//                            public void onCompleted(Exception e, String result) {
//                                int s = result.lastIndexOf("user_id")+9;
//                                 String st = result.substring(s,s+5);
//                                 Log.e("USERID",st); //something
//
//                                Log.d(TAG, "onCompleted: "+result);
//                                WebView webView = null;
////                                webView.loadData(result, "text/html", "UTF-8");
////                                webView.loadD();
//
//                            }
//                        });
//            }
//        });
        holder.titleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String str = "";
                //DownHTML.getContents(link,str);
                Log.d(TAG, "onClick:String"+ LINK );
                //Toast.makeText(c, str, Toast.LENGTH_LONG).show();
                Log.d(TAG, "onClick:Link" + link);
                ArrIndex.linkHTML = link;
                HtmlCode htmlCode = new HtmlCode();
                Intent intent = new Intent(c, WebViewActivity.class);
                intent.putExtra(LINK, link);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

//    public static String getHtml(String url,String linkDown) throws IOException {
//        // Build and set timeout values for the request.
//        URLConnection connection = (new URL(url)).openConnection();
//        connection.setConnectTimeout(5000);
//        connection.setReadTimeout(5000);
//        connection.connect();
//
//        // Read and store the result line by line then return the entire string.
//        InputStream in = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        StringBuilder html = new StringBuilder();
//        for (String line; (line = reader.readLine()) != null; ) {
//            html.append(line);
//        }
//        in.close();
//
//        linkDown = html.toString();
//
//        return linkDown;
//    }
}