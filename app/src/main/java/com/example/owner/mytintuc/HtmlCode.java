package com.example.owner.mytintuc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.net.HttpURLConnection;

/**
 * Created by Owner on 6/16/2018.
 */

public class HtmlCode extends Activity {
    TextView tv;

    private static final String TAG = "HtmlCode";
    public void onCreate(Bundle s)
    {
        super.onCreate(s);
        setContentView(R.layout.testhtml);

        tv = (TextView)findViewById(R.id.tv_test);
        Ion.with(getApplicationContext()).load(ArrIndex.linkHTML).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                //Log.d(TAG, "onCompleted:HTML "+result);
                tv.setText(result);
            }
        });
    }
}
