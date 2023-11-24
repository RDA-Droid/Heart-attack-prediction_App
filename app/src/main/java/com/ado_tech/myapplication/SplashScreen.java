package com.ado_tech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ado_tech.myapplication.formulario.MainActivity;
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
                        "https://98de-2800-484-6975-5f40-c0f1-c5b8-e874-23fc.ngrok.io",
                        new AppHandler() {
                            @Override
                            public void onSuccess(CloseResponse response, int code, String uuidDevice) {
                                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onFailure(CloseResponse response) {
                                System.out.println("respuesta: fallo");
                            }
                        });
            }
        }, 2000); // 2000 milliseconds = 2 seconds
    }
}
