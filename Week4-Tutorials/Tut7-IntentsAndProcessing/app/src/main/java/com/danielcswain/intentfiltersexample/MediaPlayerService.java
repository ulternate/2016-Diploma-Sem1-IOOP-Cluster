package com.danielcswain.intentfiltersexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ulternate on 28/02/2016.
 */
public class MediaPlayerService extends Service{

    MediaPlayer myMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        myMediaPlayer = MediaPlayer.create(this, R.raw.music1);
        myMediaPlayer.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        //super.onStart(intent, startId);
        myMediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        //super.onDestroy();
        myMediaPlayer.stop();
    }
}
