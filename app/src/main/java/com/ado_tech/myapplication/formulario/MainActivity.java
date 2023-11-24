package com.ado_tech.myapplication.formulario;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ado_tech.myapplication.R;
import com.ado_tech.myapplication.Result.ResultContract;
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

    private TextView
            textViewAge, textViewSexMale, textViewCholesterol, textViewSystolicPressure,
            textViewDiastolicPressure, textViewHeartRate, textViewDiabetes, textViewSmoking,
            textViewObesity, textViewAlcoholConsumption, textViewExerciseHours, textViewDietBalanced,
            textViewPreviousHeartProblems, textViewMedicationUse, textViewStressLevel, textViewSedentaryHours,
            textViewIncome, textViewBMI, textViewTriglycerides, textViewPhysicalActivityDays,
            textViewSleepHours, textViewCountry, textViewContinent, textViewHemisphere, textViewFamilyHistory;


    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new MainActivityPresent(this, this));
        vistas();
        viewstext();
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
        finishview(); finishallviews();
        confirmButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void finishFlow(boolean result, CloseResponse response, Integer code) {
        if (result) {

            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Error","200");
            intent.putExtra("Other_Information", response.getother_info());
            intent.putExtra("transaction_id",response.gettransaction_id());
            intent.putExtra("Probabilidad",response.getprobability());

            System.out.println(response.gettransaction_id());
            System.out.println(response.getother_info());
            startActivityForResult(intent, 29);
            finish();
        }
    }

    @Override
    public void onWebServiceStop() {

    }


    @Override
    public void onWebServiceSuccess() {

    }
    public  void finishview(){
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
    public void continueFlow(boolean result, CloseResponse response, Integer code) {


    }

    public void finishallviews(){
        textViewAge.setVisibility(View.INVISIBLE);
        textViewSexMale.setVisibility(View.INVISIBLE);
        textViewCholesterol.setVisibility(View.INVISIBLE);
        textViewSystolicPressure.setVisibility(View.INVISIBLE);
        textViewDiastolicPressure.setVisibility(View.INVISIBLE);
        textViewHeartRate.setVisibility(View.INVISIBLE);
        textViewDiabetes.setVisibility(View.INVISIBLE);
        textViewSmoking.setVisibility(View.INVISIBLE);
        textViewObesity.setVisibility(View.INVISIBLE);
        textViewAlcoholConsumption.setVisibility(View.INVISIBLE);
        textViewExerciseHours.setVisibility(View.INVISIBLE);
        textViewDietBalanced.setVisibility(View.INVISIBLE);
        textViewPreviousHeartProblems.setVisibility(View.INVISIBLE);
        textViewMedicationUse.setVisibility(View.INVISIBLE);
        textViewStressLevel.setVisibility(View.INVISIBLE);
        textViewSedentaryHours.setVisibility(View.INVISIBLE);
        textViewIncome.setVisibility(View.INVISIBLE);
        textViewBMI.setVisibility(View.INVISIBLE);
        textViewTriglycerides.setVisibility(View.INVISIBLE);
        textViewPhysicalActivityDays.setVisibility(View.INVISIBLE);
        textViewSleepHours.setVisibility(View.INVISIBLE);
        textViewCountry.setVisibility(View.INVISIBLE);
        textViewContinent.setVisibility(View.INVISIBLE);
        textViewHemisphere.setVisibility(View.INVISIBLE);
        textViewFamilyHistory.setVisibility(View.INVISIBLE);

    }


    public void viewstext(){
        textViewAge = findViewById(R.id.textViewAge);
        textViewSexMale = findViewById(R.id.textViewSexMale);
        textViewCholesterol = findViewById(R.id.textViewCholesterol);
        textViewSystolicPressure = findViewById(R.id.textViewSystolicPressure);
        textViewDiastolicPressure = findViewById(R.id.textViewDiastolicPressure);
        textViewHeartRate = findViewById(R.id.textViewHeartRate);
        textViewDiabetes = findViewById(R.id.textViewDiabetes);
        textViewSmoking = findViewById(R.id.textViewSmoking);
        textViewObesity = findViewById(R.id.textViewObesity);
        textViewAlcoholConsumption = findViewById(R.id.textViewAlcoholConsumption);
        textViewExerciseHours = findViewById(R.id.textViewExerciseHours);
        textViewDietBalanced = findViewById(R.id.textViewDietBalanced);
        textViewPreviousHeartProblems = findViewById(R.id.textViewPreviousHeartProblems);
        textViewMedicationUse = findViewById(R.id.textViewMedicationUse);
        textViewStressLevel = findViewById(R.id.textViewStressLevel);
        textViewSedentaryHours = findViewById(R.id.textViewSedentaryHours);
        textViewIncome = findViewById(R.id.textViewIncome);
        textViewBMI = findViewById(R.id.textViewBMI);
        textViewTriglycerides = findViewById(R.id.textViewTriglycerides);
        textViewPhysicalActivityDays = findViewById(R.id.textViewPhysicalActivityDays);
        textViewSleepHours = findViewById(R.id.textViewSleepHours);
        textViewCountry = findViewById(R.id.textViewCountry);
        textViewContinent = findViewById(R.id.textViewContinent);
        textViewHemisphere = findViewById(R.id.textViewHemisphere);
        textViewFamilyHistory = findViewById(R.id.textViewFamilyHistory);

    }

    public void vistas(){
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
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onNoConnection() {

    }
}
