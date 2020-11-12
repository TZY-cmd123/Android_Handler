package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {//构造方法
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;//不在这里被绑定
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Start Service第一次启动 童振宇18231500", Toast.LENGTH_LONG).show();
        super.onCreate();
    }
    //onStartCommand在onCreate方法之后，多次执行，onCreate一次执行（观察logcat的打印）
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)    {
        Toast.makeText(this, "Start Service 童振宇18231500", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
    //服务的销毁，类似Activity的生命周期方法。
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stop Service 童振宇18231500", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}