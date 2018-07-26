package com.example.owner.mytintuc;

/**
 * Created by Owner on 5/22/2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static android.content.ContentValues.TAG;

public class RSSParser extends AsyncTask<Void, Void, Boolean> {
    Context c;
    InputStream is;
    RecyclerView rv;

    ProgressDialog pd;
    ArrayList<Article> articles = new ArrayList<>();



    public RSSParser(Context c, InputStream is, RecyclerView rv) {
        this.c = c;
        this.is = is;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseRSS();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if (isParsed) {
            //BIND
            rv.setAdapter(new MyAdapter(c, ArrIndex.articlesFinal));

        } else {
            Toast.makeText(c, "Unable To Parse", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseRSS() {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(is, null);
            int event = parser.getEventType();

            String tagValue = null;
            Boolean isSiteMeta = true;
//            articles.clear();
            Article article = new Article();

            int z = 0;
            do {


                String tagName = parser.getName();

                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")) {
                            article = new Article();
                            isSiteMeta = false;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        tagValue = parser.getText();

                        break;

                    case XmlPullParser.END_TAG:
                        if (!isSiteMeta) {
                            if (tagName.equalsIgnoreCase("title")) {
                                article.setTitle(tagValue);
                                Log.d(TAG, "parseRSStitle: "+tagValue);
                            } else if (tagName.equalsIgnoreCase("description")) {
                                ArrIndex.countVNexpress++;

                                String desc = tagValue;
                                //Log.d(TAG, "parseRSSdes: "+desc);
                                article.setDescription(desc.substring(desc.indexOf("/>") + 2));
                                Log.d(TAG, "parseRSSdes: "+desc);

//                                Pattern p = Pattern.compile()
                                //EXTRACT IMAGE FROM DESC
                                int st = desc.indexOf("src=");
                                int st2 = desc.indexOf("data-original=");
                                int fn = desc.indexOf("jpg");
                                Log.d(TAG, "parseRSS: stNfn"+st+" "+fn+" "+st2+" .."+ArrIndex.countVNexpress);
                                if (fn!=-1){
                                    String imageUrl;
                                    if (ArrIndex.countVNexpress>4&&ArrIndex.inVNE&&st2!=-1){
                                        imageUrl = desc.substring(st2 + 15,fn +3);
                                    } else {
                                        imageUrl = desc.substring(st + 5,fn +3);
                                    }

                                    Log.d(TAG, "parseRSS: Image "+ArrIndex.countVNexpress+".."+ArrIndex.inVNE+"...."+imageUrl);
                                    article.setImageUrl(imageUrl);
                                }

                            }else if (tagName.equalsIgnoreCase("link")){
                                article.setLink(tagValue);

                            } else if (tagName.equalsIgnoreCase("pubDate")) {
                                article.setDate(tagValue);
                            } else if (tagName.equalsIgnoreCase("image")){
                                article.setImageUrl(tagValue);
                                Log.d(TAG, "parseRSS: Image1 "+tagValue);
                            }
//                            ArrIndex.inVNE = false;

                        }

                        if (tagName.equalsIgnoreCase("item")) {
                            z++;

                            Random rd = new Random();
                            int a = rd.nextInt(z);
                            Log.d(TAG, "parseRSS:z "+z+" "+a);
                            ArrIndex.articlesFinal.add(article);
//                            Collections.shuffle(ArrIndex.articlesFinal);
                            isSiteMeta = true;
                        }

                        break;
                }

                event = parser.next();

            }
            while (event != XmlPullParser.END_DOCUMENT) ;

            return true;

        } catch(XmlPullParserException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}

