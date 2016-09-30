package com.example.super_me.oneminute;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private MediaRecorder mediaRecorder;

    //述说心情，对自己的话
    //录音功能的实现
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        mediaRecorder = new MediaRecorder();


    }

    private void initdata() {

        int X=9;
    }

    public  void recode(View v){

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        mediaRecorder.setOutputFile("/sdcard/sub/a.mp3");

        try{

            mediaRecorder.prepare();
            mediaRecorder.start();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
