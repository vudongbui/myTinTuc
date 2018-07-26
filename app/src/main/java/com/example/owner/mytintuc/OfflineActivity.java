package com.example.owner.mytintuc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Owner on 5/28/2018.
 */

public class OfflineActivity extends AppCompatActivity {
    @BindView(R.id.iv_online)
    ImageView ivOnline;
    @BindView(R.id.iv_offline)
    ImageView ivOffline;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offlinelayout);
        ButterKnife.bind(this);
        ivOffline.setAlpha(160);
    }

    @OnClick({R.id.iv_online, R.id.iv_offline, R.id.iv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_online:
                Intent intent1 = new Intent(OfflineActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.iv_offline:
                break;
            case R.id.iv_setting:
                Intent intent = new Intent(OfflineActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
