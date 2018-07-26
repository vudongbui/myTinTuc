package com.example.owner.mytintuc.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.owner.mytintuc.OnFragmentChangeListener;
import com.example.owner.mytintuc.R;
import com.example.owner.mytintuc.utils.Download;

import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfflineFragment extends Fragment {
    private static final String TAG = "OfflineFragment";
    final static String urlAddress="https://vnexpress.net/rss/suc-khoe.rss";
    OnFragmentChangeListener onFragmentChangeListener;
    public OfflineFragment() {
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
        View view = inflater.inflate(R.layout.fragment_tabonline01, container, false);
        onFragmentChangeListener.onFragmentChange("Read offline");
        // Inflate the layout for this fragment

//        final RecyclerView rv= view.findViewById(R.id.rv);
//        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        new Download(getActivity(),urlAddress,rv).execute();

        return view;
    }

}
