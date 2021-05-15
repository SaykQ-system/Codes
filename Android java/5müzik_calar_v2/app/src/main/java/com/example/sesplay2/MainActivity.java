package com.example.sesplay2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer muzikcalar;
    SeekBar ilerleme;
    TextView kacinci_txt,topla_süre_txt;
    int deger,sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        muzikcalar=MediaPlayer.create(MainActivity.this, R.raw.sound);
        ilerleme= (SeekBar) findViewById(R.id.seekBar);
        kacinci_txt=(TextView) findViewById(R.id.textView);
        topla_süre_txt=(TextView) findViewById(R.id.textView2);
        //seekbar
        ilerleme.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    sure = ilerleme.getProgress();
                    muzikcalar.seekTo(sure * 1000);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    //Timer
    private void TimerKur() {
        CountDownTimer timer=new CountDownTimer(Long.MAX_VALUE,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                deger=(muzikcalar.getCurrentPosition()/1000);
                hesap(muzikcalar.getCurrentPosition()/1000,kacinci_txt);
                hesap(muzikcalar.getDuration()/1000,topla_süre_txt);
                ilerleme.setProgress(deger);
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }
    //süre hesap
    void hesap(int mcs, TextView rid) {
        float min = (float) (mcs - (mcs % 60)) / 60;
        float sec = (float) mcs % 60;
        if (sec < 10) {
            rid.setText("" + (int) min + ":0" + (int) sec);
        } else {
            rid.setText("" + (int) min + ":" + (int) sec);
        }
    }
    //buttonlar(play-pause)
    public void basladur(View view){
        if (!muzikcalar.isPlaying()){
            muzikcalar.start();
            ilerleme.setMax(muzikcalar.getDuration()/1000);
            TimerKur();
        }
        else{
            muzikcalar.pause();
        }
    }
    //mp3 button
    public void ses1(View view) {
        muzikcalar.stop();
        muzikcalar = MediaPlayer.create(MainActivity.this, R.raw.sound);
        muzikcalar.start();
        ilerleme.setMax(muzikcalar.getDuration()/1000);
    }
    public void ses2(View view) {
        muzikcalar.stop();
        muzikcalar = MediaPlayer.create(MainActivity.this, R.raw.sound2);
        muzikcalar.start();
        ilerleme.setMax(muzikcalar.getDuration()/1000);
    }
    public void ses4(View view) {
        muzikcalar.stop();
        muzikcalar = MediaPlayer.create(MainActivity.this, R.raw.sound3);
        muzikcalar.start();
        ilerleme.setMax(muzikcalar.getDuration()/1000);
    }
    public void ses3(View view) {
        muzikcalar.stop();
        muzikcalar = MediaPlayer.create(MainActivity.this, R.raw.sound4);
        muzikcalar.start();
        ilerleme.setMax(muzikcalar.getDuration()/1000);
    }
}