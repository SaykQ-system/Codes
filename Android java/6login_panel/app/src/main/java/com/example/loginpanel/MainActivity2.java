package com.example.loginpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView uyari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        uyari=findViewById(R.id.textView); //ekrana yazı basar
        getIntent().getExtras().getString("kullanıcı"); //kullanıcı diğer sayfadana gelir
        uyari.setText("sayın "+getIntent().getExtras().getString("kullanıcı")+" bu sayfa yapım aşamasında"); //gelen kuılanıcı bilgileri uyari değişkenine aktarılır
    }
}