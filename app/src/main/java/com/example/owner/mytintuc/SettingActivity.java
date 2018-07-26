package com.example.owner.mytintuc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Owner on 5/27/2018.
 */

public class SettingActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    @BindView(R.id.iv_online)
    ImageView ivOnline;
    @BindView(R.id.iv_offline)
    ImageView ivOffline;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.cb_vne)
    CheckBox cbVne;
    @BindView(R.id.cb_dtri)
    CheckBox cbDtri;
    @BindView(R.id.cb_3)
    CheckBox cb3;
    @BindView(R.id.cb_4)
    CheckBox cb4;
    @BindView(R.id.cb_5)
    CheckBox cb5;
    @BindView(R.id.cb_m1)
    CheckBox cbM1;
    @BindView(R.id.cb_m2)
    CheckBox cbM2;
    @BindView(R.id.cb_m3)
    CheckBox cbM3;
    @BindView(R.id.cb_m4)
    CheckBox cbM4;
    @BindView(R.id.cb_m5)
    CheckBox cbM5;
    @BindView(R.id.cb_m6)
    CheckBox cbM6;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d(TAG, "onCreate: 1");
        super.onCreate(savedInstanceState);
//        Log.d(TAG, "onCreate: 2");
        setContentView(R.layout.settinglayout);
        ButterKnife.bind(this);
        ivSetting.setAlpha(160);
        ArrIndex.firstOpen = false;
        if (ArrIndex.arrWeb[0] == 1) {
            cbVne.setChecked(true);
        } else {
            cbVne.setChecked(false);
        }
        if (ArrIndex.arrWeb[1] == 1) {
            cbDtri.setChecked(true);
        } else {
            cbDtri.setChecked(false);
        }
        if (ArrIndex.arrWeb[2] == 1) {
            cb3.setChecked(true);
        } else {
            cb3.setChecked(false);
        }
        if (ArrIndex.arrWeb[3] == 1) {
            cb4.setChecked(true);
        } else {
            cb4.setChecked(false);
        }
        if (ArrIndex.arrWeb[4] == 1) {
            cb5.setChecked(true);
        } else {
            cb5.setChecked(false);
        }
        if (ArrIndex.arrMenu[0] == 1) {
            cbM1.setChecked(true);
        } else {
            cbM1.setChecked(false);
        }
        if (ArrIndex.arrMenu[1] == 1) {
            cbM2.setChecked(true);
        } else {
            cbM2.setChecked(false);
        }
        if (ArrIndex.arrMenu[2] == 1) {
            cbM3.setChecked(true);
        } else {
            cbM3.setChecked(false);
        }
        if (ArrIndex.arrMenu[3] == 1) {
            cbM4.setChecked(true);
        } else {
            cbM4.setChecked(false);
        }
        if (ArrIndex.arrMenu[4] == 1) {
            cbM5.setChecked(true);
        } else {
            cbM5.setChecked(false);
        }
        if (ArrIndex.arrMenu[5] == 1) {
            cbM6.setChecked(true);
        } else {
            cbM6.setChecked(false);
        }
    }

    @OnClick({R.id.iv_online, R.id.iv_offline, R.id.iv_setting, R.id.cb_vne, R.id.cb_dtri
            , R.id.cb_3, R.id.cb_4, R.id.cb_5, R.id.cb_m1, R.id.cb_m2, R.id.cb_m3, R.id.cb_m4
            , R.id.cb_m5, R.id.cb_m6, R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_online:
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_offline:
                Intent intent2 = new Intent(SettingActivity.this, OfflineActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.iv_setting:
                break;
            case R.id.cb_vne:
                if (cbVne.isChecked()) {
                    ArrIndex.arrWeb[0] = 1;
                } else {
                    ArrIndex.arrWeb[0] = 0;
                }
                break;
            case R.id.cb_dtri:
                if (cbDtri.isChecked()) {
                    ArrIndex.arrWeb[1] = 1;
                } else {
                    ArrIndex.arrWeb[1] = 0;
                }
                break;
            case R.id.cb_3:
                if (cb3.isChecked()) {
                    ArrIndex.arrWeb[2] = 1;
                } else {
                    ArrIndex.arrWeb[2] = 0;
                }
                break;
            case R.id.cb_4:
                if (cb4.isChecked()) {
                    ArrIndex.arrWeb[3] = 1;
                } else {
                    ArrIndex.arrWeb[3] = 0;
                }
                break;
            case R.id.cb_5:
                if (cb5.isChecked()) {
                    ArrIndex.arrWeb[4] = 1;
                } else {
                    ArrIndex.arrWeb[4] = 0;
                }
                break;
            case R.id.cb_m1:
                if (cbM1.isChecked()) {
                    ArrIndex.arrMenu[0] = 1;
                } else {
                    ArrIndex.arrMenu[0] = 0;
                }
                break;
            case R.id.cb_m2:
                if (cbM2.isChecked()) {
                    ArrIndex.arrMenu[1] = 1;
                } else {
                    ArrIndex.arrMenu[1] = 0;
                }
                break;
            case R.id.cb_m3:
                if (cbM3.isChecked()) {
                    ArrIndex.arrMenu[2] = 1;
                } else {
                    ArrIndex.arrMenu[2] = 0;
                }
                break;
            case R.id.cb_m4:
                if (cbM4.isChecked()) {
                    ArrIndex.arrMenu[3] = 1;
                } else {
                    ArrIndex.arrMenu[3] = 0;
                }
                break;
            case R.id.cb_m5:
                if (cbM5.isChecked()) {
                    ArrIndex.arrMenu[4] = 1;
                } else {
                    ArrIndex.arrMenu[4] = 0;
                }
                break;
            case R.id.cb_m6:
                if (cbM6.isChecked()) {
                    ArrIndex.arrMenu[5] = 1;
                } else {
                    ArrIndex.arrMenu[5] = 0;
                }
                break;
            case R.id.button:
                Intent intent1 = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.button2:
                Intent intent3 = new Intent(SettingActivity.this, OfflineActivity.class);
                startActivity(intent3);
                finish();
                break;
        }
    }
}
