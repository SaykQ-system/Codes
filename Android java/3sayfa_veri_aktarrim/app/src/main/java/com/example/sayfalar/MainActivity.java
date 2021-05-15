package com.example.sayfalar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editTextTextPersonName);
    }
    public void sayfaiki(View view){
        Intent yonlendir=new Intent(MainActivity.this,sayfa2.class);
        String aktar=name.getText().toString();
        yonlendir.putExtra("ad", aktar);
        startActivity(yonlendir);
    }
}