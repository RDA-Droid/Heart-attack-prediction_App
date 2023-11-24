package com.ado_tech.myapplication.formulario;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ado_tech.myapplication.R;
import com.ado_tech.myapplication.Result.ResultsActivity;
import com.ado_tech.myapplication.model.CloseResponse;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends Activity implements MainActivityContract.View {
    private MainActivityContract.Presenter presenter;

    private EditText editTextAge, editTextSexMale, editTextCholesterol, editTextSystolicPressure,
            editTextDiastolicPressure, editTextHeartRate, editTextDiabetes, editTextSmoking,
            editTextObesity, editTextAlcoholConsumption, editTextExerciseHours, editTextDietBalanced,
            editTextPreviousHeartProblems, editTextMedicationUse, editTextStressLevel, editTextSedentaryHours,
            editTextIncome, editTextBMI, editTextTriglycerides, editTextPhysicalActivityDays,
            editTextSleepHours, editTextCountry, editTextContinent, editTextHemisphere,editTextFamilyHistory;
    private Button confirmButton;
    GifImageView loadin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new MainActivityPresent(this, this));

        loadin = findViewById(R.id.loaderGif);
        loadin.setVisibility(View.INVISIBLE);
        editTextAge = findViewById(R.id.editTextAge);
        editTextSexMale = findViewById(R.id.editTextSexMale);
        editTextCholesterol = findViewById(R.id.editTextCholesterol);
        editTextSystolicPressure = findViewById(R.id.editTextSystolicPressure);
        editTextDiastolicPressure = findViewById(R.id.editTextDiastolicPressure);
        editTextHeartRate = findViewById(R.id.editTextHeartRate);
        editTextDiabetes = findViewById(R.id.editTextDiabetes);
        editTextSmoking = findViewById(R.id.editTextSmoking);
        editTextObesity = findViewById(R.id.editTextObesity);
        editTextFamilyHistory  = findViewById(R.id.editTextFamilyHistory);
        editTextAlcoholConsumption = findViewById(R.id.editTextAlcoholConsumption);
        editTextExerciseHours = findViewById(R.id.editTextExerciseHours);
        editTextDietBalanced = findViewById(R.id.editTextDietBalanced);
        editTextPreviousHeartProblems = findViewById(R.id.editTextPreviousHeartProblems);
        editTextMedicationUse = findViewById(R.id.editTextMedicationUse);
        editTextStressLevel = findViewById(R.id.editTextStressLevel);
        editTextSedentaryHours = findViewById(R.id.editTextSedentaryHours);
        editTextIncome = findViewById(R.id.editTextIncome);
        editTextBMI = findViewById(R.id.editTextBMI);
        editTextTriglycerides = findViewById(R.id.editTextTriglycerides);
        editTextPhysicalActivityDays = findViewById(R.id.editTextPhysicalActivityDays);
        editTextSleepHours = findViewById(R.id.editTextSleepHours);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextContinent = findViewById(R.id.editTextContinent);
        editTextHemisphere = findViewById(R.id.editTextHemisphere);

        confirmButton = findViewById(R.id.confirmadr);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    presenter.NewTransaccion(
                            Integer.parseInt(editTextAge.getText().toString()),
                            Integer.parseInt(editTextSexMale.getText().toString()),
                            Integer.parseInt(editTextCholesterol.getText().toString()),
                            Integer.parseInt(editTextSystolicPressure.getText().toString()),
                            Integer.parseInt(editTextDiastolicPressure.getText().toString()),
                            Integer.parseInt(editTextHeartRate.getText().toString()),
                            Integer.parseInt(editTextDiabetes.getText().toString()),
                            Integer.parseInt(editTextFamilyHistory.getText().toString()),
                            Integer.parseInt(editTextSmoking.getText().toString()),
                            Integer.parseInt(editTextObesity.getText().toString()),
                            Integer.parseInt(editTextAlcoholConsumption.getText().toString()),
                            Integer.parseInt(editTextExerciseHours.getText().toString()),
                            Integer.parseInt(editTextDietBalanced.getText().toString()),
                            Integer.parseInt(editTextPreviousHeartProblems.getText().toString()),
                            Integer.parseInt(editTextMedicationUse.getText().toString()),
                            Integer.parseInt(editTextStressLevel.getText().toString()),
                            Integer.parseInt(editTextSedentaryHours.getText().toString()),
                            Integer.parseInt(editTextIncome.getText().toString()),
                            Integer.parseInt(editTextBMI.getText().toString()),
                            Integer.parseInt(editTextTriglycerides.getText().toString()),
                            Integer.parseInt(editTextPhysicalActivityDays.getText().toString()),
                            Integer.parseInt(editTextSleepHours.getText().toString()),
                            Integer.parseInt(editTextCountry.getText().toString()),
                            Integer.parseInt(editTextContinent.getText().toString()),
                            Integer.parseInt(editTextHemisphere.getText().toString())
                    );

                }
                else {
                    Toast.makeText(MainActivity.this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateFields() {
        return !editTextAge.getText().toString().isEmpty() &&
                !editTextSexMale.getText().toString().isEmpty() &&
                !editTextCholesterol.getText().toString().isEmpty() &&
                !editTextSystolicPressure.getText().toString().isEmpty() &&
                !editTextDiastolicPressure.getText().toString().isEmpty() &&
                !editTextHeartRate.getText().toString().isEmpty() &&
                !editTextDiabetes.getText().toString().isEmpty() &&
                !editTextSmoking.getText().toString().isEmpty() &&
                !editTextObesity.getText().toString().isEmpty() &&
                !editTextAlcoholConsumption.getText().toString().isEmpty() &&
                !editTextExerciseHours.getText().toString().isEmpty() &&
                !editTextDietBalanced.getText().toString().isEmpty() &&
                !editTextPreviousHeartProblems.getText().toString().isEmpty() &&
                !editTextMedicationUse.getText().toString().isEmpty() &&
                !editTextStressLevel.getText().toString().isEmpty() &&
                !editTextSedentaryHours.getText().toString().isEmpty() &&
                !editTextIncome.getText().toString().isEmpty() &&
                !editTextBMI.getText().toString().isEmpty() &&
                !editTextTriglycerides.getText().toString().isEmpty() &&
                !editTextPhysicalActivityDays.getText().toString().isEmpty() &&
                !editTextSleepHours.getText().toString().isEmpty() &&
                !editTextCountry.getText().toString().isEmpty() &&
                !editTextContinent.getText().toString().isEmpty() &&
                !editTextHemisphere.getText().toString().isEmpty();
    }
    @Override
    public void onWebServiceStart() {
        loadin.setVisibility(View.VISIBLE);
        editTextAge.setVisibility(View.INVISIBLE);
        editTextSexMale.setVisibility(View.INVISIBLE);
        editTextCholesterol.setVisibility(View.INVISIBLE);
        editTextSystolicPressure.setVisibility(View.INVISIBLE);
        editTextDiastolicPressure.setVisibility(View.INVISIBLE);
        editTextHeartRate.setVisibility(View.INVISIBLE);
        editTextDiabetes.setVisibility(View.INVISIBLE);
        editTextSmoking.setVisibility(View.INVISIBLE);
        editTextObesity.setVisibility(View.INVISIBLE);
        editTextFamilyHistory.setVisibility(View.INVISIBLE);
        editTextAlcoholConsumption.setVisibility(View.INVISIBLE);
        editTextExerciseHours.setVisibility(View.INVISIBLE);
        editTextDietBalanced.setVisibility(View.INVISIBLE);
        editTextPreviousHeartProblems.setVisibility(View.INVISIBLE);
        editTextMedicationUse.setVisibility(View.INVISIBLE);
        editTextStressLevel.setVisibility(View.INVISIBLE);
        editTextSedentaryHours.setVisibility(View.INVISIBLE);
        editTextIncome.setVisibility(View.INVISIBLE);
        editTextBMI.setVisibility(View.INVISIBLE);
        editTextTriglycerides.setVisibility(View.INVISIBLE);
        editTextPhysicalActivityDays.setVisibility(View.INVISIBLE);
        editTextSleepHours.setVisibility(View.INVISIBLE);
        editTextCountry.setVisibility(View.INVISIBLE);
        editTextContinent.setVisibility(View.INVISIBLE);
        editTextHemisphere.setVisibility(View.INVISIBLE);
    }

    @Override
    public void finishFlow(boolean result, CloseResponse response, Integer code) {
        if (result) {
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Error","200");
            intent.putExtra("Other_Information", response.getother_info());
            intent.putExtra("transaction_id",response.gettransaction_id());
            startActivityForResult(intent, 29);
            finish();
        }
    }

    @Override
    public void onWebServiceStop() {

    }

    @Override
    public void onWebServiceResume() {

    }

    @Override
    public void continueFlow(boolean result, CloseResponse response, Integer code) {

    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {

    }

    @Override
    public void onNoConnection() {

    }
}
