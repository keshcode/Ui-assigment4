package com.example.keshav.iblive.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keshav.iblive.R;
import com.example.keshav.iblive.adapator.CommonRVAdapator;
import com.example.keshav.iblive.constant.Constants;

/**
 * Created by keshav on 2/5/17.
 */

public class MyPostFragment extends Fragment implements Constants {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_post, container, false);
        CommonRVAdapator commonRVAdapator = new CommonRVAdapator(MODE_MYPOST);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvMypost);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(commonRVAdapator);
        return view;
    }
}
