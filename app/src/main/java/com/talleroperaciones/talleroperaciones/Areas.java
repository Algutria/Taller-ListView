package com.talleroperaciones.talleroperaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Areas extends AppCompatActivity {
    private ListView listView;
    private String [] options;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        listView = findViewById(R.id.areasOptions);
        options = getResources().getStringArray(R.array.area_options);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in = new Intent(Areas.this, AreasCalculator.class);
                        in.putExtra("calculate", "square");
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Areas.this, AreasCalculator.class);
                        in.putExtra("calculate", "rectangle");
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Areas.this, AreasCalculator.class);
                        in.putExtra("calculate", "triangle");
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(Areas.this, AreasCalculator.class);
                        in.putExtra("calculate", "circle");
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
