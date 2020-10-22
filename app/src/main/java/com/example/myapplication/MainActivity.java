package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public Button Input;
    public Button Start;
    public Button Cancel;
    public ProgressBar PB;
    public EditText ET;
    public TextView TV;//各个组件
    //public
    public MyHandlerPross HandlerPross;
    int Count=0;

    class MyHandlerTest extends Handler {
        // 通过复写handlerMessage() 从而确定更新UI的操作
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1)
                TV.setText("您输入的是"+msg.obj);
        }
    }

    class MyHandlerPross extends Handler {
        // 通过复写handlerMessage() 从而确定更新UI的操作
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==2)
            {
                if(Count<=100)
                {
                    PB.setProgress(Count);
                    Count++;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Input=(Button)findViewById(R.id.Input);
        Start=(Button)findViewById(R.id.Start);
        Cancel=(Button)findViewById(R.id.Cancel);
        PB=(ProgressBar)findViewById(R.id.progressBar);
        ET=(EditText)findViewById(R.id.Edit);
        TV=(TextView)findViewById(R.id.display);
        TV.setText("测试");
        //HandlerTest = new MyHandlerTest();
        HandlerPross=new MyHandlerPross();
        Message msg1 = Message.obtain();
        msg1.what = 1; // 消息标识
        msg1.obj = ET.getText(); // 获得输入
        //HandlerTest.sendMessage(msg1);
        Message msg2 = Message.obtain();
        msg2.what = 2; // 消息标识
        Start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                HandlerPross=new MyHandlerPross();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        HandlerPross.sendEmptyMessage(2);
                    }
                }, 0, 50);
            }
        });



        new Thread(){
            @Override
            public void run()
            {
                MyHandlerPross HandlerPross=new MyHandlerPross();
                HandlerPross.sendMessage(msg2);
                while (Count<100)
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
        new Thread(){
            @Override
            public void run()
            {
                MyHandlerTest HandlerTest=new MyHandlerTest();
                HandlerTest.sendMessage(msg1);
            }
        }.start();



    }
}