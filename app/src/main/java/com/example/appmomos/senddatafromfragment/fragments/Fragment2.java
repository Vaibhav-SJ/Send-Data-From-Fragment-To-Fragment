package com.example.appmomos.senddatafromfragment.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appmomos.senddatafromfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment2 extends Fragment
{

    @BindView(R.id.receivedMsgTxt)
    TextView receivedMsgTxt;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        ButterKnife.bind(this,v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @SuppressLint("SetTextI18n")
    public void updateReceivedTxtFun(String name , String number)
    {
        receivedMsgTxt.setText("Name : "+name+"\nNumber : "+number);
    }









}
