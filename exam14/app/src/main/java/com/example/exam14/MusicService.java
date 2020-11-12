package com.example.exam14;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service
{
    MediaPlayer mp;


    @Override
    // onBind() : 는 BoundService타입 방식으로 사용할때 사용
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate() {        // service가 구동하면 최초에 한번만 실행

        android.util.Log.i("서비스 테스트", "onCreate()"); // 로그캣
        super.onCreate();
    }

    @Override
    public void onDestroy() {       // 서비스를 중지하면 실행되는 메소드
        android.util.Log.i("서비스 테스트", "onDestroy()");
        mp.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {  // onCreate후에 실행되는 메소드          onstart()함수였으나, onStartCommand()함수를 사용할 것을 권장함.
        android.util.Log.i("서비스 테스트", "onStartCommand()");
        mp = MediaPlayer.create(this, R.raw.song1);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }


}
