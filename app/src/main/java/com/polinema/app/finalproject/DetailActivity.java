package com.polinema.app.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtJudul;
    ImageView imgKopi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtJudul = (TextView)findViewById(R.id.txtJudul);
        imgKopi = (ImageView)findViewById(R.id.imgKopi);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        txtJudul.setText(receivedName);
        imgKopi.setImageResource(receivedImage);
    }
}
