package com.example.samsung.p0921_servicesimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {

        switch (view.getId()) {

            case R.id.btnStart :
                startService(new Intent(this, MyService.class));
                break;
            case R.id.btnStop :
                stopService(new Intent(this, MyService.class));
                break;
            default:
                break;

        }

    }
}
