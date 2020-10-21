package com.example.onerepmaxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String repsString;
    TextView CalcTextView;
    EditText WeightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.reps_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reps_array, android.R.layout.simple_spinner_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);

         CalcTextView = (TextView) findViewById(R.id.textView5);
         WeightText = (EditText) findViewById(R.id.editText);

         Spinner repsSpinner = (Spinner) findViewById(R.id.reps_spinner);
         repsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                repsString = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double calc=0;
                calc = Double.parseDouble(WeightText.getText().toString()) / (1.0278- (0.0278*Integer.parseInt(repsString)));
                CalcTextView.setText(  String.valueOf(calc));
            }
        });



    }
}
