package com.ado_tech.myapplication.network;

import com.ado_tech.myapplication.model.CloseResponse;
import com.ado_tech.myapplication.model.Newtransaccion;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RetrofitApi {

    @POST("predict/")
    Call<CloseResponse> newtransaccion(@Body Newtransaccion request);

    @GET("obtener_prediccion/{txId}")
    Call<CloseResponse> validateTransaction(@Path("txId") String txId);



}