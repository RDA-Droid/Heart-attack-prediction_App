package com.ado_tech.myapplication;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ado_tech.myapplication.model.CloseResponse;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sdkopen.start(
                        SplashScreen.this,
                        "demo",
                        "db92efc69991",
                        "http://127.0.0.1:5000",
                        new AppHandler() {
                            @Override
                            public void onSuccess(CloseResponse response, int code, String uuidDevice) {
                                finish();
                             }

                            @Override
                            public void onFailure(CloseResponse response) {
                                System.out.println("respuesta: fallo" );
                            }

                        });
            }
        }, 3000);
        finish();

    }
}
