package com.example.owner.mytintuc.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.owner.mytintuc.ArrIndex;
import com.example.owner.mytintuc.OnFragmentChangeListener;
import com.example.owner.mytintuc.R;
import com.example.owner.mytintuc.utils.DownloadHTML;
import com.example.owner.mytintuc.utils.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;

import static android.content.ContentValues.TAG;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    OnFragmentChangeListener onFragmentChangeListener;
    private final String SHARED_PREFERENCES_NAME = "appTintuc";
    @BindView(R.id.cb_1)
    CheckBox cb1;
    @BindView(R.id.cb_2)
    CheckBox cb2;
    @BindView(R.id.cb_3)
    CheckBox cb3;
    @BindView(R.id.cb_4)
    CheckBox cb4;
    @BindView(R.id.cb_5)
    CheckBox cb5;
    @BindView(R.id.cb_6)
    CheckBox cb6;
    @BindView(R.id.cb_7)
    CheckBox cb7;
    @BindView(R.id.cb_8)
    CheckBox cb8;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.imageView11)
    ImageView imageView11;
    @BindView(R.id.cb_m1)
    RadioButton cbM1;
    @BindView(R.id.cb_m2)
    RadioButton cbM2;
    @BindView(R.id.cb_m3)
    RadioButton cbM3;
    @BindView(R.id.cb_m4)
    RadioButton cbM4;
    @BindView(R.id.cb_m5)
    RadioButton cbM5;
    @BindView(R.id.cb_m6)
    RadioButton cbM6;
    @BindView(R.id.cl_settinglayout)
    ConstraintLayout clSettinglayout;
    @BindView(R.id.cl_fragSetting)
    ConstraintLayout clFragSetting;
    Unbinder unbinder;
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.bt_resetchoose)
    Button btResetchoose;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onFragmentChangeListener = (OnFragmentChangeListener) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (ArrIndex.arrWeb[1]==1){
            cb1.setChecked(true);
        } else {
            cb1.setChecked(false);
        }
        if (ArrIndex.arrWeb[2]==1){
            cb2.setChecked(true);
        } else {
            cb2.setChecked(false);
        }
        if (ArrIndex.arrWeb[3]==1){
            cb3.setChecked(true);
        } else {
            cb3.setChecked(false);
        }
        if (ArrIndex.arrWeb[4]==1){
            cb4.setChecked(true);
        } else {
            cb4.setChecked(false);
        }
        if (ArrIndex.arrWeb[5]==1){
            cb5.setChecked(true);
        } else {
            cb5.setChecked(false);
        }
        if (ArrIndex.arrWeb[6]==1){
            cb6.setChecked(true);
        } else {
            cb6.setChecked(false);
        }
        if (ArrIndex.arrWeb[7]==1){
            cb7.setChecked(true);
        } else {
            cb7.setChecked(false);
        }
        if (ArrIndex.arrWeb[8]==1){
            cb8.setChecked(true);
        } else {
            cb8.setChecked(false);
        }
        if (ArrIndex.arrMenu[1]==1){
            cbM1.setChecked(true);
        } else {
            cbM1.setChecked(false);
        }
        if (ArrIndex.arrMenu[2]==1){
            cbM2.setChecked(true);
        } else {
            cbM2.setChecked(false);
        }
        if (ArrIndex.arrMenu[3]==1){
            cbM3.setChecked(true);
        } else {
            cbM3.setChecked(false);
        }
        if (ArrIndex.arrMenu[4]==1){
            cbM4.setChecked(true);
        } else {
            cbM4.setChecked(false);
        }
        if (ArrIndex.arrMenu[5]==1){
            cbM5.setChecked(true);
        } else {
            cbM5.setChecked(false);
        }
        if (ArrIndex.arrMenu[6]==1){
            cbM6.setChecked(true);
        } else {
            cbM6.setChecked(false);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        onFragmentChangeListener.onFragmentChange("Setting");



        // Inflate the layout for this fragment
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.bt_resetchoose,R.id.bt_save,R.id.cb_1, R.id.cb_2, R.id.cb_3, R.id.cb_4, R.id.cb_5, R.id.cb_6, R.id.cb_7, R.id.cb_8, R.id.cb_m1, R.id.cb_m2, R.id.cb_m3, R.id.cb_m4, R.id.cb_m5, R.id.cb_m6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_1:
                break;
            case R.id.cb_2:
                break;
            case R.id.cb_3:
                break;
            case R.id.cb_4:
                break;
            case R.id.cb_5:
                break;
            case R.id.cb_6:
                break;
            case R.id.cb_7:
                break;
            case R.id.cb_8:
                break;
            case R.id.cb_m1:
                if (cbM1.isChecked()){
                    cbM2.setChecked(false);
                    cbM3.setChecked(false);
                    cbM4.setChecked(false);
                    cbM5.setChecked(false);
                    cbM6.setChecked(false);
                }
                break;
            case R.id.cb_m2:
                if (cbM2.isChecked()){
                    cbM1.setChecked(false);
                    cbM3.setChecked(false);
                    cbM4.setChecked(false);
                    cbM5.setChecked(false);
                    cbM6.setChecked(false);
                }
                break;
            case R.id.cb_m3:
                if (cbM3.isChecked()){
                    cbM2.setChecked(false);
                    cbM1.setChecked(false);
                    cbM4.setChecked(false);
                    cbM5.setChecked(false);
                    cbM6.setChecked(false);
                }
                break;
            case R.id.cb_m4:
                if (cbM4.isChecked()){
                    cbM2.setChecked(false);
                    cbM3.setChecked(false);
                    cbM1.setChecked(false);
                    cbM5.setChecked(false);
                    cbM6.setChecked(false);
                }
                break;
            case R.id.cb_m5:
                if (cbM5.isChecked()){
                    cbM2.setChecked(false);
                    cbM3.setChecked(false);
                    cbM4.setChecked(false);
                    cbM1.setChecked(false);
                    cbM6.setChecked(false);
                }
                break;
            case R.id.cb_m6:
                if (cbM6.isChecked()){
                    cbM2.setChecked(false);
                    cbM3.setChecked(false);
                    cbM4.setChecked(false);
                    cbM5.setChecked(false);
                    cbM1.setChecked(false);
                }
                break;
            case R.id.bt_save:
                if (cb1.isChecked()){
                    ArrIndex.arrWeb[1]=1;
                }else ArrIndex.arrWeb[1]=0;
                if (cb2.isChecked()){
                    ArrIndex.arrWeb[2]=1;
                }else ArrIndex.arrWeb[2]=0;
                if (cb3.isChecked()){
                    ArrIndex.arrWeb[3]=1;
                }else ArrIndex.arrWeb[3]=0;
                if (cb4.isChecked()){
                    ArrIndex.arrWeb[4]=1;
                }else ArrIndex.arrWeb[4]=0;
                if (cb5.isChecked()){
                    ArrIndex.arrWeb[5]=1;
                }else ArrIndex.arrWeb[5]=0;
                if (cb6.isChecked()){
                    ArrIndex.arrWeb[6]=1;
                }else ArrIndex.arrWeb[6]=0;
                if (cb7.isChecked()){
                    ArrIndex.arrWeb[7]=1;
                }else ArrIndex.arrWeb[7]=0;
                if (cb8.isChecked()){
                    ArrIndex.arrWeb[8]=1;
                }else ArrIndex.arrWeb[8]=0;
                if (cbM1.isChecked()){
                    ArrIndex.arrMenu[1]=1;
                } else ArrIndex.arrMenu[1]=0;
                if (cbM2.isChecked()){
                    ArrIndex.arrMenu[2]=1;
                } else ArrIndex.arrMenu[2]=0;
                if (cbM3.isChecked()){
                    ArrIndex.arrMenu[3]=1;
                } else ArrIndex.arrMenu[3]=0;
                if (cbM4.isChecked()){
                    ArrIndex.arrMenu[4]=1;
                } else ArrIndex.arrMenu[4]=0;
                if (cbM5.isChecked()){
                    ArrIndex.arrMenu[5]=1;
                } else ArrIndex.arrMenu[5]=0;
                if (cbM6.isChecked()){
                    ArrIndex.arrMenu[6]=1;
                } else ArrIndex.arrMenu[6]=0;

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft_add.add(R.id.cl_main,new OnlineFragment());
                ft_add.addToBackStack(null);
                ft_add.commit();

//                Utils.openFragment(getSupportFragmentManager()
//                        ,R.id.cl_main
//                        ,new OnlineFragment());
                break;
            case R.id.bt_resetchoose:
                if (ArrIndex.arrWeb[1]==1){
                    cb1.setChecked(true);
                } else cb1.setChecked(false);
                if (ArrIndex.arrWeb[2]==1){
                    cb2.setChecked(true);
                } else cb2.setChecked(false);
                if (ArrIndex.arrWeb[3]==1){
                    cb3.setChecked(true);
                } else cb3.setChecked(false);
                if (ArrIndex.arrWeb[4]==1){
                    cb4.setChecked(true);
                } else cb4.setChecked(false);
                if (ArrIndex.arrWeb[5]==1){
                    cb5.setChecked(true);
                } else cb5.setChecked(false);
                if (ArrIndex.arrWeb[6]==1){
                    cb6.setChecked(true);
                } else cb6.setChecked(false);
                if (ArrIndex.arrWeb[7]==1){
                    cb7.setChecked(true);
                } else cb7.setChecked(false);
                if (ArrIndex.arrWeb[8]==1){
                    cb8.setChecked(true);
                } else cb8.setChecked(false);
                if (ArrIndex.arrMenu[1]==1){
                    cbM1.setChecked(true);
                } else cbM1.setChecked(false);
                if (ArrIndex.arrMenu[2]==1){
                    cbM2.setChecked(true);
                } else cbM2.setChecked(false);
                if (ArrIndex.arrMenu[3]==1){
                    cbM3.setChecked(true);
                } else cbM3.setChecked(false);
                if (ArrIndex.arrMenu[4]==1){
                    cbM4.setChecked(true);
                } else cbM4.setChecked(false);
                if (ArrIndex.arrMenu[5]==1){
                    cbM5.setChecked(true);
                } else cbM5.setChecked(false);
                if (ArrIndex.arrMenu[6]==1){
                    cbM6.setChecked(true);
                } else cbM6.setChecked(false);

//                Document doc = null;
//                try {
//                    doc = Jsoup.connect("https://www.wikipedia.org/").get();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String text = doc.body().text();
//
//                System.out.print(text);

//                try {
//                    String webPage = "http://www.google.com";
//                    URL url = new URL(webPage);
//                    URLConnection urlConnection = url.openConnection();
//                    InputStream is = urlConnection.getInputStream();
//                    InputStreamReader isr = new InputStreamReader(is);
//
//                    int numCharsRead;
//                    char[] charArray = new char[1024];
//                    StringBuffer sb = new StringBuffer();
//                    while ((numCharsRead = isr.read(charArray)) > 0) {
//                        sb.append(charArray, 0, numCharsRead);
//                    }
//                    String result = sb.toString();
//
//                    System.out.println("*** BEGIN ***");
//                    System.out.println(result);
//                    System.out.println("*** END ***");
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String htmlcontent = " ";
//                try {
//                    URL url = new URL("www.nguoiduatin.vn/rss/the-thao.rss");
//                    HttpURLConnection c = (HttpURLConnection) url.openConnection();
//                    c.connect();
//                    InputStream input = c.getInputStream();
//                    int data;
//                    InputStreamReader reader = new InputStreamReader( input );
//
//                    data = reader.read();
//
//                    while (data != -1)
//                    {
//                        char content = (char) data;
//                        htmlcontent+=content;
//                        data = reader.read();
//                    }
//                }
//                catch (Exception e)
//                {
//                    Log.i("Status : ",e.toString());
//                }
//                //return htmlcontent;
//                String html = "";
//                String url = "ENTER URL TO DOWNLOAD";
//                OkHttpClient client = new OkHttpClient();
//                HttpGet request = new HttpGet(url);
//                HttpResponse response = client.execute(request);
//                InputStream in = response.getEntity().getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                StringBuilder str = new StringBuilder();
//                String line = null;
//                while((line = reader.readLine()) != null)
//                {
//                    str.append(line);
//                }
//                in.close();
//                html = str.toString();
                break;

        }
    }
}
