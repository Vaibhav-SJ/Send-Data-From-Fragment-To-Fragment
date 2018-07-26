package com.example.appmomos.senddatafromfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.appmomos.senddatafromfragment.fragments.Fragment1;
import com.example.appmomos.senddatafromfragment.fragments.Fragment2;
import com.example.appmomos.senddatafromfragment.interfaces.SendDataInterface;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SendDataInterface
{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        addFragmentsFun();
    }

    //Adding fragments to activity
    private void addFragmentsFun()
    {
        fragmentManager = MainActivity.this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout1,new Fragment1(),"frag1");
        fragmentTransaction.add(R.id.frameLayout2,new Fragment2(),"frag2").commit();
    }

    @Override
    public void sendData(String name, String number)
    {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("frag2");
        fragment2.updateReceivedTxtFun(name,number);
    }
}
