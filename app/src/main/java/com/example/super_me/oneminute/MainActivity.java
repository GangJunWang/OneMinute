package com.example.super_me.oneminute;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        //初始化Button
        initView();
    }

    private void initView() {
        //初始化录音按钮
        final Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt1.getText().equals("开始")) {

                    //得到当前时间，用作录音命名

                    Date date = new Date();

                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

                    String path = "/sdcard/sub/OneMinute" + date + ".mp3";

                    mediaRecorder.setOutputFile(path);

                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();

                        Toast.makeText(getApplicationContext(),"开始录音",Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bt1.setText("停止");

                } else if (bt1.getText().equals("停止")) {

                    mediaRecorder.stop();

                    Toast.makeText(getApplicationContext(),"录音完成",Toast.LENGTH_LONG).show();

                    bt1.setText("开始");
                }
            }
        });
        //初始化播放按钮
        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
