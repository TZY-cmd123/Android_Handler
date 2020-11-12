package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Using Start Service, IntentService, and Bind Service to show your name and ID with a Toast
    private Button Start_Service;
    private Button Bind_Service;
    private Button Unbind_Service;
    private Button IntentService;
    private MyBinderService.MyBinder mybinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybinder=(MyBinderService.MyBinder)service;
            mybinder.SayHello();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mybinder.SayGoodBye();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start_Service=(Button)findViewById(R.id.Start_Service);
        Unbind_Service=(Button)findViewById(R.id.Unbind_Service);
        Bind_Service=(Button)findViewById(R.id.Bind_Service);
        IntentService=(Button)findViewById(R.id.IntentService);
    }

    public void ClickStart_Service(View view){
        Intent intentOne = new Intent(this,MyService.class);
        startService(intentOne);//启动服务
    }

    public void Bind_Service(View view){
        Intent intent =new Intent(this,MyBinderService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);//绑定服务
    }

    public void Unbind_Service(View view){
        Intent intent =new Intent(this,MyBinderService.class);
        Toast.makeText(this, "解绑Bind服务 童振宇18231500", Toast.LENGTH_LONG).show();
        unbindService(connection);//解绑服务
    }

    public void Cancel(View view){
        Intent intentOne = new Intent(this,MyService.class);
        stopService(intentOne);//启动服务
    }

    public void IntentService(View view){
        Intent intent =new Intent(this,MyIntentService.class);
        startService(intent);
    }
}