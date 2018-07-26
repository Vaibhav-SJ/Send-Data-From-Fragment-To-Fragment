package com.example.appmomos.senddatafromfragment;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.appmomos.senddatafromfragment.fragments.Fragment1;
import com.example.appmomos.senddatafromfragment.fragments.Fragment2;
import com.example.appmomos.senddatafromfragment.interfaces.SendDataInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SendDataInterface
{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.blank_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
           finish();
        }

        return super.onOptionsItemSelected(item);
    }




}
