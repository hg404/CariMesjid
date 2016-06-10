package com.example.mrizkijuanda.carimesjid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
    }
    public void maps(View view){
        Intent intent = new Intent(this, Maps.class);

        startActivity(intent);
    }
    public void listpilih(View view){
        Intent intent = new Intent(this, ListPilih.class);
        startActivity(intent);
    }

}
