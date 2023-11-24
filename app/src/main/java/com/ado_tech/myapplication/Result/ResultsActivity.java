package com.ado_tech.myapplication.Result;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ado_tech.myapplication.R;
import com.ado_tech.myapplication.model.CloseResponse;

import java.io.File;

import pl.droidsonroids.gif.GifImageView;

public class ResultsActivity extends Activity implements ResultContract.View {
    String stateName;
    String transactionId;
    public static Context context;
    TextView message;
    TextView message0;
    TextView message1;
    Button btn_finalize;
    String url;
    String error;
    String probability;
    ResultContract.Presenter presenter;
    ImageView loader2;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        transactionId = getIntent().getStringExtra("transaction_id");
        stateName = getIntent().getStringExtra("Other_Information");
        probability = getIntent().getStringExtra("Probabilidad");
        error = getIntent().getStringExtra("Error");

         presenter = new ResultPresent(this, this);

         setPresenter(presenter);
        initViews();

         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.evaluateTransaction(transactionId);
            }
        }, 4000);
    }

    public void resetapp() {
        clearCache();
        clearLocalStorage();
        String packageName = getApplicationContext().getPackageName();
        Intent restartIntent = getApplicationContext().getPackageManager()
                .getLaunchIntentForPackage(packageName);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(restartIntent);
        finish();
    }

    public void clearCache() {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null && cacheDir.isDirectory()) {
            deleteRecursive(cacheDir);
        }

        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null && externalCacheDir.isDirectory()) {
            deleteRecursive(externalCacheDir);
        }
    }

    private static void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }

    public void clearLocalStorage() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    void initViews() {
        loader2= findViewById(R.id.loader2);
        btn_finalize = findViewById(R.id.btn_finalize);
        btn_finalize.setVisibility(View.INVISIBLE);
        message = findViewById(R.id.tv);
         message = findViewById(R.id.tv);
        message0 = findViewById(R.id.message);
        message1 = findViewById(R.id.textView);
        message0.setVisibility(View.INVISIBLE);
        message1.setVisibility(View.INVISIBLE);
        loader2.setVisibility(View.VISIBLE);
        message.setText("ESPERA UN MOMENTO.");
        url = "https://www.goredforwomen.org/es/health-topics/heart-attack/life-after-a-heart-attack/lifestyle-changes-for-heart-attack-prevention";

        switch (error) {
            case "200": {
                btn_finalize.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finalizar();
                    }
                });
                break;
            }
            case "404": {
                message.setText("ALGO HA OCURRIDO");
                btn_finalize.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finalizar();
                    }
                });
                break;
            }
            default:
                break;
        }
    }

    public void finalizar() {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        finish();
    }

    public void setPresenter(ResultContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onNoConnection() {
        // Handle no connection
    }

    @Override
    public void onWebServiceStart() {
        // Handle web service start
    }

    @Override
    public void onWebServiceStop() {
        // Handle web service stop
    }

    @Override
    public void finishFlow(boolean result, CloseResponse response, int statusCode) {
        if (result && response != null && response.getprobability() != null) {
            double probabilidad = Double.parseDouble(response.getprobability());
            if (probabilidad > 0.05) {
                message.setVisibility(View.VISIBLE);
                message0.setVisibility(View.VISIBLE);
                message1.setVisibility(View.VISIBLE);
                message.setText("Tienes un Alto índice de tener un infarto cardíaco,Cuida mas de tu salud.");
                message0.setText("Número de Transacción:" + transactionId);
                message1.setText("Probabilidad del:" + probabilidad);
                btn_finalize.setVisibility(View.VISIBLE);
            } else {
                message.setText("Tienes un bajo índice de tener un infarto cardíaco, pero sigue cuidando tu salud.");
                message0.setVisibility(View.VISIBLE);
                message1.setVisibility(View.VISIBLE);
                 message0.setText("Número de Transacción:" + transactionId);
                message1.setText("Probabilidad del :" + probabilidad);
                btn_finalize.setVisibility(View.VISIBLE);

            }
        }
    }


    @Override
    public void continueFlow(boolean result, int statusCode, CloseResponse response) {
        // Handle continue flow
    }
}
