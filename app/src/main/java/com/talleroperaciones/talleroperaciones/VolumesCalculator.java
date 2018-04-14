package com.talleroperaciones.talleroperaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VolumesCalculator extends AppCompatActivity {
    private TextView title;
    private LinearLayout sphereCalculatorLayout;
    private LinearLayout cylinderCalculatorLayout;
    private LinearLayout coneCalculatorLayout;
    private LinearLayout cubeCalculatorLayout;

    private EditText sphereRadio, cylinderRadio,
            cylinderHeight, coneRadio,
            coneHeight, cubeHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumes_calculator);

        title = findViewById(R.id.volumes_title);
        sphereCalculatorLayout = this.findViewById(R.id.sphereCalculatorLayout);
        cylinderCalculatorLayout = this.findViewById(R.id.cylinderCalculatorLayout);
        coneCalculatorLayout = this.findViewById(R.id.coneCalculatorLayout);
        cubeCalculatorLayout = this.findViewById(R.id.cubeCalculatorLayout);

        sphereRadio = this.findViewById(R.id.sphereRadio);
        cylinderRadio = this.findViewById(R.id.cylinderRadio);
        cylinderHeight = this.findViewById(R.id.cylinderHeight);
        coneRadio = this.findViewById(R.id.coneRadio);
        coneHeight = this.findViewById(R.id.coneHeight);
        cubeHeight = this.findViewById(R.id.cubeHeight);

        Intent intent = getIntent();
        String calculate = intent.getStringExtra("calculate");
        hideLayouts();

        switch (calculate) {
            case "sphere":
                title.setText(getResources().getString(R.string.sphere));
                sphereCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cylinder":
                title.setText(getResources().getString(R.string.cylinder));
                cylinderCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cone":
                title.setText(getResources().getString(R.string.cone));
                coneCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
            case "cube":
                title.setText(getResources().getString(R.string.cube));
                cubeCalculatorLayout.setVisibility(LinearLayout.VISIBLE);
                break;
        }
    }

    public void hideLayouts(){
        sphereCalculatorLayout.setVisibility(LinearLayout.GONE);
        cylinderCalculatorLayout.setVisibility(LinearLayout.GONE);
        coneCalculatorLayout.setVisibility(LinearLayout.GONE);
        cubeCalculatorLayout.setVisibility(LinearLayout.GONE);
    }

    public void showResult(Double result){
        AlertDialog alertDialog = new AlertDialog.Builder(VolumesCalculator.this).create();
        alertDialog.setTitle(getResources().getString(R.string.result));
        alertDialog.setMessage(getResources().getString(R.string.volume) + ": " + result);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void calculateSphereVolume(View v){
        if(isAValidValue(sphereRadio)){
            Double sphereRadioValue = Double.parseDouble(sphereRadio.getText().toString());
            Double result = (4 * 3.14 * Math.pow(sphereRadioValue, 3)) / 3;
            String radioTxt = getResources().getString(R.string.radio) + ": " + sphereRadioValue;

            String[] data = { radioTxt };
            sendOperation(getResources().getString(R.string.sphere_volume_op), data, result +  "");

            showResult(result);
        }
    }

    public void calculateCylinderVolume(View v){
        if(isAValidValue(cylinderRadio) && isAValidValue(cylinderHeight)) {
            Double cylinderRadioValue = Double.parseDouble(cylinderRadio.getText().toString());
            Double cylinderHeightValue = Double.parseDouble(cylinderHeight.getText().toString());
            Double result = 3.14 * Math.pow(cylinderRadioValue, 2) * cylinderHeightValue;

            String radioTxt = getResources().getString(R.string.radio) + ": " + cylinderRadioValue;
            String heightTxt = getResources().getString(R.string.height) + ": " + cylinderHeightValue;

            String[] data = {radioTxt , heightTxt};
            sendOperation(getResources().getString(R.string.cylinder_volume_op), data, result +  "");

            showResult(result);
        }
    }

    public void calculateConeVolume(View v){
        if(isAValidValue(coneRadio) && isAValidValue(coneHeight)) {
            Double coneRadioValue = Double.parseDouble(coneRadio.getText().toString());
            Double coneHeightValue = Double.parseDouble(coneHeight.getText().toString());
            Double result = (3.14 * Math.pow(coneRadioValue, 2) * coneHeightValue) / 3;

            String radioTxt = getResources().getString(R.string.radio) + ": " + coneRadioValue;
            String heightTxt = getResources().getString(R.string.height) + ": " + coneHeightValue;

            String[] data = {radioTxt , heightTxt};
            sendOperation(getResources().getString(R.string.cone_volume_op), data, result +  "");

            showResult(result);
        }
    }

    public void calculateCubeVolume(View v){
        if(isAValidValue(cubeHeight)) {
            Double cubeHeightValue = Double.parseDouble(cubeHeight.getText().toString());
            Double result = Math.pow(cubeHeightValue, 3);

            String heightTxt = getResources().getString(R.string.radio) + ": " + cubeHeightValue;

            String[] data = { heightTxt };
            sendOperation(getResources().getString(R.string.cube_volume_op), data, result +  "");

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

    public void clear(View v) {
        sphereRadio.setText("");
        cylinderRadio.setText("");
        cylinderHeight.setText("");
        coneRadio.setText("");
        coneHeight.setText("");
        cubeHeight.setText("");
    }

    public void sendOperation(String operation, String[] data, String result){
        Operation op = new Operation(operation, data, result);
        op.save();
    }
}
