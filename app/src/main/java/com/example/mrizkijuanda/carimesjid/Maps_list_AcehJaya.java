package com.example.mrizkijuanda.carimesjid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Maps_list_AcehJaya extends Activity  {

    private String id;
    String nama = "";
    String lokasiLAT="";
    String lokasiLONG="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_list);

        Intent intent = getIntent();
        id = intent.getStringExtra(config.EMP_ID);

        getEmployee();



    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Maps_list_AcehJaya.this,"Menampilkan Data...","Loading...",false,false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
                kirim();
            }
            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(config.URL_GET_ACEHJAYA, id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String id = c.getString(config.TAG_ID);
             nama = c.getString(config.TAG_NAMA);
             lokasiLAT = c.getString(config.TAG_LOKASILAT);
             lokasiLONG = c.getString(config.TAG_LOKASILONG);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void kirim(){
        Intent intent = new Intent(this, show_maps_list.class);
        intent.putExtra("nama",nama);
        intent.putExtra("langtitude",lokasiLAT);
        intent.putExtra("longtitude",lokasiLONG);
        startActivity(intent);
    }

}
