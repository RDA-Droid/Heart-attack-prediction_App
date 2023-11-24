package com.ado_tech.myapplication.formulario;

import com.ado_tech.myapplication.model.CloseResponse;

public interface MainActivityContract {

    interface Presenter extends BasePresenter {

        void NewTransaccion(
                int age,
                int sexMale,
                int cholesterol,
                int systolicPressure,
                int diastolicPressure,
                int heartRate,
                int diabetesSi,
                int familyHistorySi,
                int smokingSi,
                int obesitySi,
                int alcoholConsumptionModerate,
                int exerciseHoursPerWeek,
                int dietBalanced,
                int previousHeartProblemsSi,
                int medicationUseNo,
                int stressLevelLow,
                int sedentaryHoursPerDay,
                int income,
                int bmi,
                int triglycerides,
                int physicalActivityDaysPerWeek,
                int sleepHoursPerDay,
                int countryYourCountry,
                int continentYourContinent,
                int hemisphereNorth
        );

    }

    interface View extends BaseView<MainActivityContract.Presenter> {

        void onWebServiceStart();
        void finishFlow(boolean result, CloseResponse response, Integer code);
        void onWebServiceStop();
        void onWebServiceSuccess();
        void continueFlow(boolean result, CloseResponse response, Integer code);
    }
}
