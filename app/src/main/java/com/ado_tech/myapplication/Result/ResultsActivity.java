package com.ado_tech.myapplication.Result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ado_tech.myapplication.R;
import com.ado_tech.myapplication.model.CloseResponse;

import java.io.File;

public class ResultsActivity extends Activity implements ResultContract.View {
    String stateName;
    String transactionId;
    public static Context context;
    TextView message ;
    TextView message0 ;
    TextView message1 ;
    Button btn_finalize;
    String url;
    String error;

    ResultContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        transactionId = getIntent().getStringExtra("transaction_id");
        stateName = getIntent().getStringExtra("Other_Information");
        error = getIntent().getStringExtra("Error");
        initViews();

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
        btn_finalize = findViewById(R.id.btn_finalize);
        message.findViewById(R.id.tv);
        message0.findViewById(R.id.message);
        message1.findViewById(R.id.textView);
        url = "https://www.goredforwomen.org/es/health-topics/heart-attack/life-after-a-heart-attack/lifestyle-changes-for-heart-attack-prevention";

        switch(error) {
            case "200": {
                message.setVisibility(View.VISIBLE);
                message0.setVisibility(View.VISIBLE);
                message1.setVisibility(View.VISIBLE);
                message.setText("El proceso de validación medica ha finalizado.");
                message0.setText("Numero De Transaccion:"+transactionId);
                message1.setText("Resultado de Transaccion:"+stateName);
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

    }

    @Override
    public void onWebServiceStart() {

    }

    @Override
    public void onWebServiceStop() {

    }

    @Override
    public void finishFlow(boolean result, CloseResponse response, int statusCode) {

    }

    @Override
    public void continueFlow(boolean result, int statusCode, CloseResponse response) {

    }
}