package com.talleroperaciones.talleroperaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class OperationsPerformed extends AppCompatActivity {
    private TableLayout table;
    private ArrayList<Operation> operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_performed);

        table = findViewById(R.id.table);
        operations = Data.getOperations();

        for (int i = 0; i < operations.size(); i++) {
            TableRow row = new TableRow(this);

            TextView operationID = new TextView(this);
            TextView op = new TextView(this);
            TextView data = new TextView(this);
            TextView result = new TextView(this);

            operationID.setText(""+(i + 1));
            op.setText(operations.get(i).getOperation());

            String dataText = "";
            for (int j = 0; j < operations.get(i).getData().length; j++) {
                dataText += operations.get(i).getData()[j] + "\n";
            }

            data.setText(dataText);
            result.setText(operations.get(i).getResult());

            row.addView(operationID);
            row.addView(op);
            row.addView(data);
            row.addView(result);

            table.addView(row);
        }
    }
}
