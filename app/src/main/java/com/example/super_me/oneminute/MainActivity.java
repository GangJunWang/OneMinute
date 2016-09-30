package com.example.super_me.oneminute;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

//述说心情，对自己的话
        //录音功能的实现
public class MainActivity extends Activity {

    private MediaRecorder mediaRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //音频管理器
        mediaRecorder = new MediaRecorder();
    }

    public void recode(View v) {
        //得到当前时间，用作录音命名

        Date date = new Date();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        String path = "/sdcard/sub/"+date+".mp3";


        mediaRecorder.setOutputFile(path);

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(View v) {

    }

}
