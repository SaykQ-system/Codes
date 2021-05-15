package com.example.loginpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase baglanti;
    EditText kullanici, parola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullanici=(EditText)findViewById(R.id.editTextTextPersonName); //kulanıcı adı alır
        parola=(EditText)findViewById(R.id.editTextTextPassword); //şifreyi alır
        baglanti=openOrCreateDatabase("veritabani2.db",MODE_PRIVATE,null); // veritabani2.db oluşturulur
        baglanti.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar(kullaniciadi text, password text)"); // veri tabanına tablo oluştuurlur tabloya kulanıcı ve parola sütünü eklenir
    }

    public void kayit(View view) {
        baglanti.execSQL("insert into kullanicilar(kullaniciadi,password)values('"+kullanici.getText().toString()+"','"+parola.getText().toString()+"')"); //kulanıcı kaydı veri tabanına yapılır
        Toast.makeText(MainActivity.this,"kaydın başarıyla alındı",Toast.LENGTH_SHORT).show(); //olduna dair bilgi verir
    }

    public void giris(View view) {
        Cursor cursor=baglanti.rawQuery("select * from kullanicilar where kullaniciadi='"+kullanici.getText().toString()+"'and password='"+parola.getText().toString()+"'",null); // giriş için verilen bilgiler veri tabanında bakılır
        if (cursor.moveToFirst()){
            Toast.makeText(MainActivity.this,"Giriş başarılı",Toast.LENGTH_SHORT).show(); // veriler dogru ise giriş yapılır
            Intent yonlendir=new Intent(MainActivity.this,MainActivity2.class); //main actifiden main 2 ye git
            yonlendir.putExtra("kullanıcı",kullanici.getText().toString()); //kulanaçi bilgilerini kulanıcı ya ekle diğer sayfaay yönlendir
            startActivity(yonlendir); //sayfa 2 gitmek için aktivte başlat
        }
    }
}