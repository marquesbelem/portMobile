package com.example.camil.app_camis;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class Main3Activity_AsyncImage extends Activity {

    String URL = "https://cdn.jogos360.com.br/pa/cm/pacman-come-come-fb.jpg";
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_async_image);
        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);

        // Capture button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new DownloadImage().execute(URL);
            }
        });
    }

    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Main3Activity_AsyncImage.this);
            mProgressDialog.setTitle("Download Image");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                InputStream input = new java.net.URL(imageURL).openStream();
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
            mProgressDialog.dismiss();
        }

    }
}
