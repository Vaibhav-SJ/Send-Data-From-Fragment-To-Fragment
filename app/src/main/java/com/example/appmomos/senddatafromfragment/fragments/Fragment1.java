package com.example.appmomos.senddatafromfragment.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmomos.senddatafromfragment.R;
import com.example.appmomos.senddatafromfragment.interfaces.SendDataInterface;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment1 extends Fragment
{

    SendDataInterface sendDataInterface;

    @BindView(R.id.editTextName)
    EditText editTextName;

    @BindView(R.id.editTextNumber)
    EditText editTextNumber;

    @BindView(R.id.btn1)
    Button btn1;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =  inflater.inflate(R.layout.fragment_fragment1, container, false);
        ButterKnife.bind(this,v);
        sendDataInterface = (SendDataInterface) getActivity();
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataInterface.sendData(editTextName.getText().toString().trim(),editTextNumber.getText().toString().trim());
            }
        });
    }
}
