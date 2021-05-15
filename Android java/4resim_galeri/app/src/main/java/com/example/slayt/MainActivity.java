package com.example.slayt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView goruntu;
    List<Drawable> resim =new ArrayList<>();
    int sayac=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goruntu=(ImageView) findViewById(R.id.imageView3);
        resim.add(getResources().getDrawable(R.drawable.res1));
        resim.add(getResources().getDrawable(R.drawable.res2));
        resim.add(getResources().getDrawable(R.drawable.res3));
        resim.add(getResources().getDrawable(R.drawable.res4));

        goruntu.setImageDrawable(resim.get(0));
    }
    public void ileri(View view){
        if (sayac<(resim.size()-1)){
            goruntu.setImageDrawable(resim.get(sayac+1));
            sayac++;
        }
    }
    public void geri(View view){
        if (sayac>0){
            goruntu.setImageDrawable(resim.get(sayac-1));
            sayac--;
        }
    }
}