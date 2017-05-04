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
 * Created by keshav on 3/5/17.
 */

public class NewRequest extends Fragment implements Constants {
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_requests, container, false);
        CommonRVAdapator commonRVAdapator = new CommonRVAdapator(MODE_NEW_REQUEST);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCommon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(commonRVAdapator);
        return view;
    }

    @Override
    public void init() {

    }
}
