package com.talleroperaciones.talleroperaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AreasCalculator extends AppCompatActivity {
    private TextView title;
    private LinearLayout squareCalculatorLayout;
    private LinearLayout rectangleCalculatorLayout;
    private LinearLayout triangleCalculatorLayout;
    private LinearLayout circleCalculatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_calculator);

        title = findViewById(R.id.areas_title);
        squareCalculatorLayout = this.findViewById(R.id.squareCalculatorLayout);
        rectangleCalculatorLayout = this.findViewById(R.id.rectangleCalculatorLayout);
        triangleCalculatorLayout = this.findViewById(R.id.triangleCalculatorLayout);
        circleCalculatorLayout = this.findViewById(R.id.circleCalculatorLayout);

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
}
