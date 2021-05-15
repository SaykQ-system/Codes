package com.example.sesplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MediaPlayer muzikcalar;
    SeekBar positionBar;
    int totalTime;
    TextView artisure, eksisure;
    List<MediaPlayer> muzik = new ArrayList<>();
    int sayac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        artisure = findViewById(R.id.textView);
        eksisure = findViewById(R.id.textView2);

        muzik.add(MediaPlayer.create(getBaseContext(),R.raw.sound));
        muzik.add(MediaPlayer.create(getBaseContext(),R.raw.sound2));
        muzik.add(MediaPlayer.create(getBaseContext(),R.raw.sound3));
        muzik.add(MediaPlayer.create(getBaseContext(),R.raw.sound4));

        muzikcalar=muzik.get(0);
        muzikcalar.setLooping(true);
        totalTime = muzikcalar.getDuration();

        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            muzikcalar.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (muzikcalar != null) {
                    try {
                        Message msg = new Message();
                        msg.what = muzikcalar.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                }
            }
        }).start();
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int currentPosition = msg.what;
            positionBar.setProgress(currentPosition);
            String elapsedTime = artisure(currentPosition);
            artisure.setText(elapsedTime);

            String remainingTime = "- " + artisure(totalTime - currentPosition);
            eksisure.setText(remainingTime);
            return true;
        }
    });

    public String artisure(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;
        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;
        return timeLabel;
    }

    public void play(View view){
        if (!muzikcalar.isPlaying()){
            muzikcalar.start();
        }
        else{
            muzikcalar.pause();
        }
    }

    public void  ileri(View viev){
        if (sayac<(muzik.size()-1)){
            muzikcalar=(muzik.get(sayac+1));
            sayac++;
        }
    }

    public void  geri(View viev){
        if (sayac>0){
            muzikcalar=(muzik.get(sayac-1));
            sayac--;
        }
    }
}