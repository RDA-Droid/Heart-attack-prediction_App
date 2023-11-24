package com.ado_tech.myapplication.formulario;


import android.content.Context;
import android.content.Intent;

import com.ado_tech.myapplication.model.CloseResponse;
import com.ado_tech.myapplication.model.Newtransaccion;
import com.ado_tech.myapplication.network.ApiHelper;
import com.ado_tech.myapplication.network.RetrofitClient;

public class MainActivityPresent implements MainActivityContract.Presenter {
    private MainActivityContract.View view;
    Context context;
    private String versionName =  "1.0.0";



    MainActivityPresent(MainActivityContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onViewCreated(Intent intent) {

    }

    @Override
    public void NewTransaccion(int age, int sexMale, int cholesterol, int systolicPressure, int diastolicPressure, int heartRate, int diabetesSi, int familyHistorySi, int smokingSi, int obesitySi, int alcoholConsumptionModerate, int exerciseHoursPerWeek, int dietBalanced, int previousHeartProblemsSi, int medicationUseNo, int stressLevelLow, int sedentaryHoursPerDay, int income, int bmi, int triglycerides, int physicalActivityDaysPerWeek, int sleepHoursPerDay, int countryYourCountry, int continentYourContinent,int hemisphereNorth) {
        view.onWebServiceStart();
        Newtransaccion newTransaction = new Newtransaccion(
                age, sexMale, cholesterol, systolicPressure, diastolicPressure, heartRate,
                diabetesSi, familyHistorySi, smokingSi, obesitySi, alcoholConsumptionModerate,
                exerciseHoursPerWeek, dietBalanced, previousHeartProblemsSi, medicationUseNo,
                stressLevelLow, sedentaryHoursPerDay, income, bmi, triglycerides,
                physicalActivityDaysPerWeek, sleepHoursPerDay, countryYourCountry,
                continentYourContinent, hemisphereNorth
        );

        new RetrofitClient().Newtransaccion(
                newTransaction,
                new ApiHelper.NewtransaccionHandler() {
                    @Override
                    public void onSuccess(int statusCode, CloseResponse response) {
                        view.onWebServiceSuccess();
                        if (statusCode == 200) {
                            view.finishFlow(true,response,statusCode);
                        } else if (statusCode == 201) {
                            view.finishFlow(true, response, statusCode);
                        }
                    }

                    @Override
                    public void onConnectionFailed() {
                        view.onNoConnection();
                    }

                    @Override
                    public void onFailure(int statusCode, String error) {
                        view.onWebServiceStop();
                        if (statusCode == -1) {
                            view.onNoConnection();
                        } else{
                            view.finishFlow(false, null, statusCode);
                        }
                    }
                },context);
    }

}