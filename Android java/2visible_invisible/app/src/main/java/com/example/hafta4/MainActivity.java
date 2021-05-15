package com.example.hafta4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText yazi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yazi = (EditText)findViewById(R.id.edit);
    }

    public void gizle(View view) {
        if (yazi.getVisibility() == View.VISIBLE) {
            yazi.setVisibility(View.INVISIBLE);
        }
        else if (yazi.getVisibility()== View.INVISIBLE) {
            yazi.setVisibility(View.VISIBLE);
        }
    }
}