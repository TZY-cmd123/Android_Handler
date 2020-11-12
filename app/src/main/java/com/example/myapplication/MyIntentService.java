package com.example.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("IntentService 童振宇18231500");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)    {
        Toast.makeText(this, "Start IntentService 童振宇18231500", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(this, "Start Service 童振宇18231500", Toast.LENGTH_LONG).show();
    }
}
