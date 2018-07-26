package com.example.owner.mytintuc;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Owner on 6/5/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView titleTxt,desctxt,dateTxt;
    ImageView img;
    ImageView ivdown;


    public MyViewHolder(View itemView) {
        super(itemView);

        titleTxt =  itemView.findViewById(R.id.titleTxt);
//        titleTxt.setTextColor(Color.parseColor("#4285f4"));
//        desctxt =  itemView.findViewById(R.id.descTxt);
        dateTxt =  itemView.findViewById(R.id.dateTxt);
        img =  itemView.findViewById(R.id.articleImage);
        ivdown = itemView.findViewById(R.id.iv_down);
    }
}
