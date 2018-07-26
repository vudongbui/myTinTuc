package com.example.owner.mytintuc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    ListView listView;
    MyAdapter adapter;
    ArrayList<Article> arrNews;
    private static final String TAG = "tag";
    @BindView(R.id.iv_online)
    ImageView ivOnline;
    @BindView(R.id.iv_offline)
    ImageView ivOffline;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.ll_main)
    ConstraintLayout llMain;
    @BindView(R.id.cl_list)
    ConstraintLayout clList;


    private final String SHARED_PREFERENCES_NAME = "appTintuc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listView = (ListView) findViewById(R.id.lv_list);
        arrNews = new ArrayList<Article>();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("bao01", false);
        editor.putBoolean("bao02", false);
        editor.putBoolean("bao03", false);
        editor.putBoolean("bao04", false);
        editor.putBoolean("bao05", false);
        editor.putBoolean("bao06", false);
        editor.putBoolean("bao07", false);
        editor.putBoolean("bao08", false);
        editor.putBoolean("muc01", false);
        editor.putBoolean("muc01", false);
        editor.putBoolean("muc02", false);
        editor.putBoolean("muc03", false);
        editor.putBoolean("muc04", false);
        editor.putBoolean("muc05", false);
        editor.putBoolean("muc06", false);
        editor.putBoolean("muc07", false);
        editor.putBoolean("muc08", false);
        editor.putBoolean("firstOpen", true);

        if (sharedPreferences.getBoolean("firstOpen",true)){
            editor.putBoolean("firstOpen",false);
        }

//        if (ArrIndex.firstOpen) {
//            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//            startActivity(intent);
//            finish();
//
//        }
        ivOnline.setAlpha(160);
//        loadListData();
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra("link", arrNews.get(position).link);
//                startActivity(intent);
//            }
//        });
    }



//    public void loadListData() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //vnexpress
//                if (ArrIndex.arrWeb[0] == 1) {
//                    if (ArrIndex.arrMenu[0] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
//                    } else if (ArrIndex.arrMenu[1] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/the-gioi.rss");
//                    } else if (ArrIndex.arrMenu[2] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/the-thao.rss");
//                    } else if (ArrIndex.arrMenu[3] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/phap-luat.rss");
//                    } else if (ArrIndex.arrMenu[4] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/gia-dinh.rss");
//                    } else if (ArrIndex.arrMenu[5] == 1) {
//                        new readData().execute("https://vnexpress.net/rss/giai-tri.rss");
//                    }
//                }
//                //dantri
//                if (ArrIndex.arrWeb[1] == 1) {
//                    if (ArrIndex.arrMenu[0] == 1) {
//                        new readData().execute("http://dantri.com.vn/trangchu.rss");
//                    } else if (ArrIndex.arrMenu[1] == 1) {
//                        new readData().execute("http://dantri.com.vn/the-gioi.rss");
//                    } else if (ArrIndex.arrMenu[2] == 1) {
//                        new readData().execute("http://dantri.com.vn/the-thao.rss");
//                    } else if (ArrIndex.arrMenu[3] == 1) {
//                        new readData().execute("http://dantri.com.vn/phap-luat.rss");
//                    } else if (ArrIndex.arrMenu[4] == 1) {
//                        new readData().execute("http://dantri.com.vn/doi-song.rss");
//                    } else if (ArrIndex.arrMenu[5] == 1) {
//                        new readData().execute("http://dantri.com.vn/tinh-yeu-gioi-tinh.rss");
//                    }
//                }
//                //vietnamnet
//                if (ArrIndex.arrWeb[2] == 1) {
//                    if (ArrIndex.arrMenu[0] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/home.rss");
//                    } else if (ArrIndex.arrMenu[1] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/the-gioi.rss");
//                    } else if (ArrIndex.arrMenu[2] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/the-thao.rss");
//                    } else if (ArrIndex.arrMenu[3] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/phap-luat.rss");
//                    } else if (ArrIndex.arrMenu[4] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/doi-song.rss");
//                    } else if (ArrIndex.arrMenu[5] == 1) {
//                        new readData().execute("http://vietnamnet.vn/rss/giai-tri.rss");
//                    }
//                }
//                //tuoitre
//                if (ArrIndex.arrWeb[3] == 1) {
//                    if (ArrIndex.arrMenu[0] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/tin-moi-nhat.rss");
//                    } else if (ArrIndex.arrMenu[1] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/the-gioi.rss");
//                    } else if (ArrIndex.arrMenu[2] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/the-thao.rss");
//                    } else if (ArrIndex.arrMenu[3] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/phap-luat.rss");
//                    } else if (ArrIndex.arrMenu[4] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/suc-khoe.rss");
//                    } else if (ArrIndex.arrMenu[5] == 1) {
//                        new readData().execute("https://tuoitre.vn/rss/thu-gian.rss");
//                    }
//                }
//                //tienphong
//                if (ArrIndex.arrWeb[4] == 1) {
//                    if (ArrIndex.arrMenu[0] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/xa-hoi-2.rss");
//                    } else if (ArrIndex.arrMenu[1] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/the-gioi-5.rss");
//                    } else if (ArrIndex.arrMenu[2] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/the-thao-11.rss");
//                    } else if (ArrIndex.arrMenu[3] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/phap-luat-12.rss");
//                    } else if (ArrIndex.arrMenu[4] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/gia-dinh-suc-khoe-210.rss");
//                    } else if (ArrIndex.arrMenu[5] == 1) {
//                        new readData().execute("https://www.tienphong.vn/rss/giai-tri-36.rss");
//                    }
//                }
//
//
//            }
//        });
//    }
}