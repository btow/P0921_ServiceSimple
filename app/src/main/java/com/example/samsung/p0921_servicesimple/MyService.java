package com.example.samsung.p0921_servicesimple;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    final String LOG_TAG = "myLogs";
    private String message = "";

    @Override
    public void onCreate() {
        super.onCreate();
        message = "The method \"onCreate()\" is run";
        Log.d(LOG_TAG, message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        message = "The method \"onStartCommand()\" is run";
        Log.d(LOG_TAG, message);
        someTask();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        message = "The method \"onDestroy()\" is run";
        Log.d(LOG_TAG, message);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        message = "The method \"onBind()\" is run";
        Log.d(LOG_TAG, message);
        return null;
    }

    private void someTask() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    message = "i = " + i;
                    Log.d(LOG_TAG, message);

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stopSelf();

                }
            }
        }).start();

    }
}
