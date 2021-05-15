package com.example.sayfalar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sayfa2 extends AppCompatActivity {
    TextView gname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);
        gname=(TextView)findViewById(R.id.textView);

        Intent intent=getIntent();
        String ad=intent.getStringExtra("ad");
        gname.setText(ad);
    }
    public void ana(View view){
        Intent yonlendir=new Intent(sayfa2.this,MainActivity.class);
        startActivity(yonlendir);
    }
}