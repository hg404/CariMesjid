package com.example.mrizkijuanda.carimesjid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ListPilih extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pilih);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
    }
    public void bandaaceh(View view){

        Intent intent = new Intent(this, List_bandaaceh.class);

        startActivity(intent);
    }
    public void pidie(View view){

        Intent intent = new Intent(this, List_pidie.class);

        startActivity(intent);
    }

    public void acehbesar(View view){

        Intent intent = new Intent(this, List_acehbesar.class);

        startActivity(intent);
    }

    public void acehjaya(View view){

        Intent intent = new Intent(this, List_acehjaya.class);

        startActivity(intent);
    }
}

