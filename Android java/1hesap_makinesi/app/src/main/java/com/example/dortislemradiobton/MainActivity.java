package com.example.dortislemradiobton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView sonuc;
    EditText sayi1,sayi2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonuc=(TextView) findViewById(R.id.textView3);
        sayi1=(EditText) findViewById(R.id.edit1);
        sayi2=(EditText) findViewById(R.id.edit2);
    }
    public void hesapla (View view) {
        RadioButton topla=(RadioButton)findViewById(R.id.topla);
        RadioButton cikar=(RadioButton)findViewById(R.id.cikar);
        RadioButton carp=(RadioButton)findViewById(R.id.carp);
        RadioButton bol=(RadioButton)findViewById(R.id.bol);
        if (topla.isChecked()) {
            int sayisaldegersay1=Integer.parseInt(sayi1.getText().toString());
            int sayisaldegersay2=Integer.parseInt(sayi2.getText().toString());
            sonuc.setText(String.valueOf("Sonuc: "+(sayisaldegersay1+sayisaldegersay2)));
        }
        else if (cikar.isChecked()) {
            int sayisaldegersay1=Integer.parseInt(sayi1.getText().toString());
            int sayisaldegersay2=Integer.parseInt(sayi2.getText().toString());
            sonuc.setText(String.valueOf("Sonuc: "+(sayisaldegersay1-sayisaldegersay2)));
        }
        else if (carp.isChecked()) {
            int sayisaldegersay1=Integer.parseInt(sayi1.getText().toString());
            int sayisaldegersay2=Integer.parseInt(sayi2.getText().toString());
            sonuc.setText(String.valueOf("Sonuc: "+(sayisaldegersay1*sayisaldegersay2)));
        }
        else if (bol.isChecked()) {
            int sayisaldegersay1=Integer.parseInt(sayi1.getText().toString());
            int sayisaldegersay2=Integer.parseInt(sayi2.getText().toString());
            sonuc.setText(String.valueOf("Sonuc: "+(sayisaldegersay1/sayisaldegersay2)));
        }
        else {
            sonuc.setText("işlem secilmedi");
        }
    }
}