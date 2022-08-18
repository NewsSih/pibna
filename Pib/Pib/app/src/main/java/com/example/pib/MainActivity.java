package com.example.pib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread thread = new Thread(){

            public void run(){
                try {
                    sleep(2000);

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        };thread.start();

    }
}