package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyBinderService extends Service {
    private  IBinder mybinder=new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }
    public void ShowTest(String str){
        Toast.makeText(this,str+" 童振宇18231500", Toast.LENGTH_LONG).show();

    }

    //向客户端返回的IBinder对象
    public class MyBinder extends Binder{
        public void SayHello(){
            ShowTest("Bind连接服务");
        }

        public void SayGoodBye(){
            ShowTest("Bind断开服务");
        }
    }





}
