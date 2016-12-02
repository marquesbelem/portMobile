package com.example.camil.app_camis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity_Async extends AppCompatActivity {

    private String[] names ={"Metal Gear ", "Pac Man", "Maximo", "PES","League of Legends",
            "Call of Duty", "Rainbow Six Siege", "Limbo", "Tomb Raider","Super Meat Boy"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_async);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));

        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void, String, String> {
        ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>)listView.getAdapter();
        }

        @Override
        protected String doInBackground(Void... params) {

            for (String Name : names){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(Name);
            }

            return  "Carregamento com sucesso";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }
    }
}
