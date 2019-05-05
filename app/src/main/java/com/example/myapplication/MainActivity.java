package com.example.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.TextView;
public class MainActivity extends Activity{
    Context useCount;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //Context useCount = null;
        try{
            // 获取其他程序所对应的Context
            useCount = createPackageContext("com.example.forthwork_1",
                    Context.CONTEXT_IGNORE_SECURITY);
        }
        catch (NameNotFoundException e){
            e.printStackTrace();
        }
        // 使用其他程序的Context获取对应的SharedPreferences
        SharedPreferences prefs = useCount.getSharedPreferences("count",
                Context.MODE_PRIVATE);
        // 读取数据
        int count = prefs.getInt("count", 0);
        TextView show = (TextView) findViewById(R.id.show);
        // 显示读取的数据内容
        show.setText("UseCount应用程序以前被使用了" + count + "次。");
    }
}

