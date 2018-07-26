package com.example.owner.mytintuc.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.owner.mytintuc.ArrIndex;
import com.example.owner.mytintuc.OnFragmentChangeListener;
import com.example.owner.mytintuc.R;
import com.example.owner.mytintuc.utils.Download;

import okhttp3.OkHttpClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFragment extends Fragment {
    OnFragmentChangeListener onFragmentChangeListener;
    static String urlAddress="https://vnexpress.net/rss/suc-khoe.rss";
    TextView textView;
    public OnlineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onFragmentChangeListener = (OnFragmentChangeListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_online, container, false);
        onFragmentChangeListener.onFragmentChange("Read online");
        final RecyclerView rv= view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        if (ArrIndex.arrMenu[1]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            ArrIndex.inVNE = true;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/tin-moi-nhat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thanhnien.vn/rss/viet-nam.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/home.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/tin-moi-nhat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/xa-hoi-2.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/chinh-tri-209.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/thoi-su.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/phap-luat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }
        if (ArrIndex.arrMenu[2]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            ArrIndex.inVNE = true;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/the-gioi.rss";
                ArrIndex.inVNE = true;
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thanhnien.vn/rss/the-gioi.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/the-gioi.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/the-gioi.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/the-gioi-5.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/the-gioi-213.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/the-gioi.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/the-gioi.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }
        if (ArrIndex.arrMenu[3]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/the-thao.rss";
                ArrIndex.inVNE = true;
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thethao.thanhnien.vn/rss/home.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/the-thao.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/the-thao.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/the-thao-11.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/the-thao-214.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/cuoc-song-so.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/the-thao.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }

        if (ArrIndex.arrMenu[4]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/phap-luat.rss";
                ArrIndex.inVNE = true;
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thanhnien.vn/rss/viet-nam/phap-luat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/phap-luat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/phap-luat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/phap-luat-12.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/phap-luat-237.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/doanh-nhan.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/phap-luat.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }
        if (ArrIndex.arrMenu[5]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/suc-khoe.rss";
                ArrIndex.inVNE = true;
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thanhnien.vn/rss/doi-song.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/suc-khoe.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/suc-khoe.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/gia-dinh-suc-khoe-210.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/suc-khoe-311.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/bat-dong-san.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/nhip-song.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }
        if (ArrIndex.arrMenu[6]==1){
            ArrIndex.articlesFinal.clear();
            ArrIndex.countVNexpress = 0;
            if (ArrIndex.arrWeb[1]==1){
                urlAddress = "https://vnexpress.net/rss/cuoi.rss";
                ArrIndex.inVNE = true;
                new Download(getActivity(),urlAddress,rv).execute();
            }
//            ArrIndex.inVNE = false;
            if (ArrIndex.arrWeb[2]==1){
                urlAddress = "https://thanhnien.vn/rss/the-gioi-tre.r";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[3]==1){
                urlAddress = "http://vietnamnet.vn/rss/giai-tri.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[4]==1){
                urlAddress = "https://tuoitre.vn/rss/giao-duc.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[5]==1){
                urlAddress = "https://www.tienphong.vn/rss/giai-tri-36.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[6]==1){
                urlAddress = "https://vov.vn/rss/van-hoa-giai-tri-215.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[7]==1){
                urlAddress = "http://vneconomy.vn/rss/xe-360.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
            if (ArrIndex.arrWeb[8]==1){
                urlAddress = "https://www.nguoiduatin.vn/rss/giai-tri.rss";
                new Download(getActivity(),urlAddress,rv).execute();
            }
        }

//        ArrIndex.inVNE = false;
        return view;
    }
}
