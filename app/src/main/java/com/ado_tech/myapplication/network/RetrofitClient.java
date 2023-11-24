package com.ado_tech.myapplication.network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;

import com.ado_tech.myapplication.R;
import com.ado_tech.myapplication.app;
import com.ado_tech.myapplication.model.CloseResponse;
import com.ado_tech.myapplication.model.ErrorResponse;
import com.ado_tech.myapplication.model.Newtransaccion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient implements ApiHelper {

    static Context context;
    private static final String TAG = "okhttp";

    private static RetrofitApi getprediction() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain
                        .request()
                        .newBuilder()
                        .addHeader("APIKEY", RetrofitClient.getApiKey_Server())
                        .addHeader("PROYECTNAME", RetrofitClient.getNameProject_Server())
                         .build();
                return chain.proceed(request);
            }
        });

        return new Retrofit.Builder()
                .baseUrl(RetrofitClient.getUrlSite_Server()+"/predict")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient
                        .connectTimeout(90, TimeUnit.SECONDS)
                        .readTimeout(90, TimeUnit.SECONDS)
                        .writeTimeout(90, TimeUnit.SECONDS)
                        .build())
                .build()
                .create(RetrofitApi.class);
    }

            private static RetrofitApi getClientValidationTransaction() {

                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain
                                .request()
                                .newBuilder()
                                .addHeader("APIKEY", RetrofitClient.getApiKey_Server())
                                .addHeader("PROYECTNAME", RetrofitClient.getNameProject_Server())
                                .build();
                        return chain.proceed(request);
                    }
                });

                return new Retrofit.Builder()
                        .baseUrl(RetrofitClient.getUrlSite_Server()+"obtener_prediccion"+"/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient
                                .connectTimeout(90, TimeUnit.SECONDS)
                                .readTimeout(90, TimeUnit.SECONDS)
                                .writeTimeout(90, TimeUnit.SECONDS)
                                .build())
                        .build()
                        .create(RetrofitApi.class);
            }


            private boolean checkConnection(Context mContext) {
                final ConnectivityManager connectivityManager = ((ConnectivityManager) app.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE));
                return Objects.requireNonNull(connectivityManager).getActiveNetworkInfo() != null
                        && connectivityManager.getActiveNetworkInfo().isConnected();
            }


    public void validateTransaction(final String txId, ValidateTransactionHandler handler, Context mContext) {
        if (!checkConnection(mContext)) {
            handler.onConnectionFailed();
            return;
        }
        getClientValidationTransaction().validateTransaction(txId).enqueue(new Callback<CloseResponse>() {
            @Override
            public void onResponse(@NonNull Call<CloseResponse> call, @NonNull Response<CloseResponse> response) {
                if (response.isSuccessful()) {
                    handler.onSuccess(response.code(), response.body());
                } else {
                    handler.onFailure(response.code(), response.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CloseResponse> call, @NonNull Throwable t) {
                handler.onFailure(-1, t.toString());
            }
        });
    }

    @Override
    public void Newtransaccion(Newtransaccion request, final NewtransaccionHandler handler, Context mContext) {

        if (!checkConnection(mContext)) {
            handler.onConnectionFailed();
            return;
        }

        getprediction().newtransaccion(request).enqueue(new Callback<CloseResponse>() {
            @Override
            public void onResponse(@NonNull Call<CloseResponse> call, @NonNull Response<CloseResponse> response) {

                if (response.isSuccessful()) {
                    handler.onSuccess(response.code(), response.body());
                } else {
                    Gson gson = new GsonBuilder().create();
                    ErrorResponse mError;
                    try {
                        mError = gson.fromJson(response.errorBody().string(), ErrorResponse.class);
                        handler.onFailure(response.code(), mError.getError1());
                    } catch (IOException e) {
                        handler.onFailure(response.code(), app.getAppContext().getResources().getString(R.string.unknown_error));
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<CloseResponse> call, @NonNull Throwable t) {
                handler.onFailure(-1, t.toString());
            }
        });

    }


    public static String getUrlSite_Server() {
                String value = "";
                if(context != null ){
                    SharedPreferences data = context.getSharedPreferences("shared_login_data",Context.MODE_PRIVATE);
                    if (data != null) {
                        value = data.getString("urlSite_Server", "");
                    }
                    assert value != null;
                    if (value.isEmpty()) {
                        value = "";
                    }
                }
                return value;
            }

            public static String getNameProject_Server() {
                String value = "";
                SharedPreferences data = context.getSharedPreferences("shared_login_data",Context.MODE_PRIVATE);
                if (data != null) {
                    value = data.getString("nameProject_Server", "");
                }
                assert value != null;
                if (value.isEmpty()) {
                    value = "";
                }

                return value;
            }

            public static String getApiKey_Server() {
                String value = "";
                SharedPreferences data = context.getSharedPreferences("shared_login_data",Context.MODE_PRIVATE);
                if (data != null) {
                    value = data.getString("apiKey_Server", "");
                }
                assert value != null;
                if (value.isEmpty()) {
                    value = "";
                }

                return value;
            }

    public static void storeConfigSdk(Activity activity, String UrlSite_Sdk, String nameProject_Sdk, String apiKey_Sdk) {
        SharedPreferences prefs = activity.getSharedPreferences("shared_login_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("urlSite_Sdk", UrlSite_Sdk);
        editor.putString("nameProject_Sdk", nameProject_Sdk);
        editor.putString("apiKey_Sdk", apiKey_Sdk);
        editor.commit();
    }

    public static void setContext(Context context) {
        RetrofitClient.context = context;
    }


}