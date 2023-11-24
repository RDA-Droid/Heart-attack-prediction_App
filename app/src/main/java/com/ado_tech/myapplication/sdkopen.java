package com.ado_tech.myapplication;

import android.app.Activity;
import android.content.Intent;

import com.ado_tech.myapplication.formulario.MainActivity;
import com.ado_tech.myapplication.network.RetrofitClient;

public class sdkopen {
    private static AppHandler sHandler;

    public static void start(final Activity activity,
                             String projectName_Sdk,
                             String apiKey_Sdk,
                             String Url_Sdk,
                             AppHandler handler) {
        RetrofitClient.setContext(activity);
        RetrofitClient.storeConfigSdk(activity, Url_Sdk, projectName_Sdk, apiKey_Sdk);
        RetrofitClient.setContext(activity);
        sHandler = handler;

    }

    public static void launcheractivity(final Activity activity) {
        Intent myIntent = new Intent(activity, MainActivity.class);
        activity.startActivity(myIntent);
    }



    public static AppHandler getHandler() {
        return sHandler;
    }
}