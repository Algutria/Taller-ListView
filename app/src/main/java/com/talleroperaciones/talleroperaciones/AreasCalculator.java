package com.talleroperaciones.talleroperaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AreasCalculator extends AppCompatActivity {
    private TextView title;
    private LinearLayout squareCalculatorLayout;
    private LinearLayout rectangleCalculatorLayout;
    private LinearLayout triangleCalculatorLayout;
    private LinearLayout circleCalculatorLayout;

    private EditText squareSize, rectangleBase,
            rectangleHeight, triangleBase,
            triangleHeight, circleRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_calculator);

        title = findViewById(R.id.areas_title);
        squareCalculatorLayout = this.findViewById(R.id.squareCalculatorLayout);
        rectangleCalculatorLayout = this.findViewById(R.id.rectangleCalculatorLayout);
        triangleCalculatorLayout = this.findViewById(R.id.triangleCalculatorLayout);
        circleCalculatorLayout = this.findViewById(R.id.circleCalculatorLayout);

        squareSize = this.findViewById(R.id.squareSize);
        rectangleBase = this.findViewById(R.id.rectangleBase);
        rectangleHeight = this.findViewById(R.id.rectangleHeight);
        triangleBase = this.findViewById(R.id.triangleBase);
        triangleHeight = this.findViewById(R.id.triangleHeight);
        circleRadio = this.findViewById(R.id.circleRadio);

        Intent intent = getIntent();
        String calculate = intent.getStringExtra("calculate");
        hideLayouts();

        switch (calculate) {
            case "square":
                title.setText(getResources().getString(R.string.square));
                squareCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "rectangle":
                title.setText(getResources().getString(R.string.rectangle));
                rectangleCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "triangle":
                title.setText(getResources().getString(R.string.triangle));
                triangleCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "circle":
                title.setText(getResources().getString(R.string.circle));
                circleCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
        }

    }

    public void hideLayouts(){
        squareCalculatorLayout.setVisibility(LinearLayout.GONE);
        rectangleCalculatorLayout.setVisibility(LinearLayout.GONE);
        triangleCalculatorLayout.setVisibility(LinearLayout.GONE);
        circleCalculatorLayout.setVisibility(LinearLayout.GONE);
    }

    public void showResult(Double result){
        AlertDialog alertDialog = new AlertDialog.Builder(AreasCalculator.this).create();
        alertDialog.setTitle(getResources().getString(R.string.result));
        alertDialog.setMessage(getResources().getString(R.string.area) + ": " + result);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void calculateSquareArea(View v){
        if(isAValidValue(squareSize)){
            Double squareSizeValue = Double.parseDouble(squareSize.getText().toString());
            Double result = squareSizeValue * squareSizeValue;

            showResult(result);
        }
    }

    public void calculateRectangleArea(View v){
        if(isAValidValue(rectangleBase) && isAValidValue(rectangleHeight)) {
            Double rectangleBaseValue = Double.parseDouble(rectangleBase.getText().toString());
            Double rectangleHeightValue = Double.parseDouble(rectangleHeight.getText().toString());
            Double result = rectangleBaseValue * rectangleHeightValue;

            showResult(result);
        }
    }

    public void calculatetriangleArea(View v){
        if(isAValidValue(triangleBase) && isAValidValue(triangleHeight)) {
            Double triangleBaseValue = Double.parseDouble(triangleBase.getText().toString());
            Double triangleHeightValue = Double.parseDouble(triangleHeight.getText().toString());
            Double result = triangleBaseValue * triangleHeightValue / 2;

            showResult(result);
        }
    }

    public void calculateCircleArea(View v){
        if(isAValidValue(circleRadio)) {
            Double circleRadioValue = Double.parseDouble(circleRadio.getText().toString());
            Double result = 3.14 * Math.pow(2, circleRadioValue);

            showResult(result);
        }
    }

    public boolean isAValidValue(EditText input) {
        if (input.getText().toString().trim().isEmpty()) {
            input.requestFocus();
            input.setError(getResources().getString(R.string.blank_quantity));
            return false;
        }

        if (Double.parseDouble(input.getText().toString()) == 0) {
            input.requestFocus();
            input.setError(getResources().getString(R.string.quantity_greater_than_zero));
            return false;
        }

        return true;
    }
}
