package com.example.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {

    // To start service we need the meida player object
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(
                this,
                Settings.System.DEFAULT_RINGTONE_URI
        );

        player.setLooping(true);

        player.start();

        return START_STICKY;

        // Start_sticky indicates the the service coudl restart as needed by this application.

        // Start_not_sticky = the service shoudl not be started unless specifed by the system
        // i.e., like a sound effect
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
        // a bound service is a type of service that allows for other programs to bind to this.
        // null = indicates that the service doesn't support binding.
    }
}
