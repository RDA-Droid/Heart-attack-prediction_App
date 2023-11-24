package com.ado_tech.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Newtransaccion {

    @SerializedName("Age")
    @Expose
    private int age;

    @SerializedName("Sex_Male")
    @Expose
    private int sexMale;

    @SerializedName("Cholesterol")
    @Expose
    private int cholesterol;

    @SerializedName("Systolic Pressure")
    @Expose
    private int systolicPressure;

    @SerializedName("Diastolic Pressure")
    @Expose
    private int diastolicPressure;

    @SerializedName("Heart Rate")
    @Expose
    private int heartRate;

    @SerializedName("Diabetes_Si")
    @Expose
    private int diabetesSi;

    @SerializedName("Family History_Si")
    @Expose
    private int familyHistorySi;

    @SerializedName("Smoking_Si")
    @Expose
    private int smokingSi;

    @SerializedName("Obesity_Si")
    @Expose
    private int obesitySi;

    @SerializedName("Alcohol Consumption_Moderate")
    @Expose
    private int alcoholConsumptionModerate;

    @SerializedName("Exercise Hours Per Week")
    @Expose
    private int exerciseHoursPerWeek;

    @SerializedName("Diet_Balanced")
    @Expose
    private int dietBalanced;

    @SerializedName("Previous Heart Problems_Si")
    @Expose
    private int previousHeartProblemsSi;

    @SerializedName("Medication Use_No")
    @Expose
    private int medicationUseNo;

    @SerializedName("Stress Level_Low")
    @Expose
    private int stressLevelLow;

    @SerializedName("Sedentary Hours Per Day")
    @Expose
    private int sedentaryHoursPerDay;

    @SerializedName("Income")
    @Expose
    private int income;

    @SerializedName("BMI")
    @Expose
    private int bmi;

    @SerializedName("Triglycerides")
    @Expose
    private int triglycerides;

    @SerializedName("Physical Activity Days Per Week")
    @Expose
    private int physicalActivityDaysPerWeek;

    @SerializedName("Sleep Hours Per Day")
    @Expose
    private int sleepHoursPerDay;

    @SerializedName("Country_Your Country")
    @Expose
    private int countryYourCountry;

    @SerializedName("Continent_Your Continent")
    @Expose
    private int continentYourContinent;

    @SerializedName("Hemisphere_North")
    @Expose
    private int hemisphereNorth;

    public Newtransaccion(
            int age, int sexMale, int cholesterol, int systolicPressure, int diastolicPressure, int heartRate,
            int diabetesSi, int familyHistorySi, int smokingSi, int obesitySi, int alcoholConsumptionModerate,
            int exerciseHoursPerWeek, int dietBalanced, int previousHeartProblemsSi, int medicationUseNo,
            int stressLevelLow, int sedentaryHoursPerDay, int income, int bmi, int triglycerides,
            int physicalActivityDaysPerWeek, int sleepHoursPerDay, int countryYourCountry,
            int continentYourContinent, int hemisphereNorth) {
        this.age = age;
        this.sexMale = sexMale;
        this.cholesterol = cholesterol;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.diabetesSi = diabetesSi;
        this.familyHistorySi = familyHistorySi;
        this.smokingSi = smokingSi;
        this.obesitySi = obesitySi;
        this.alcoholConsumptionModerate = alcoholConsumptionModerate;
        this.exerciseHoursPerWeek = exerciseHoursPerWeek;
        this.dietBalanced = dietBalanced;
        this.previousHeartProblemsSi = previousHeartProblemsSi;
        this.medicationUseNo = medicationUseNo;
        this.stressLevelLow = stressLevelLow;
        this.sedentaryHoursPerDay = sedentaryHoursPerDay;
        this.income = income;
        this.bmi = bmi;
        this.triglycerides = triglycerides;
        this.physicalActivityDaysPerWeek = physicalActivityDaysPerWeek;
        this.sleepHoursPerDay = sleepHoursPerDay;
        this.countryYourCountry = countryYourCountry;
        this.continentYourContinent = continentYourContinent;
        this.hemisphereNorth = hemisphereNorth;
    }

}
