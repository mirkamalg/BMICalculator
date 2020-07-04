package com.mirkamal.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textViewHeight;
    TextView textViewWeight;
    TextView textViewBMI;
    TextView textBMIStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBarHeight = findViewById(R.id.seekBarHeight);
        SeekBar seekBarWeight = findViewById(R.id.seekBarWeight);

        textViewHeight = findViewById(R.id.heightText);
        textViewWeight = findViewById(R.id.weightText);
        textViewBMI = findViewById(R.id.BMI_text);
        textBMIStatus = findViewById(R.id.BMI_status);

        Button buttonCalculate = findViewById(R.id.calculate_button);

        seekBarHeight.setProgress(65);
        seekBarWeight.setProgress(30);

        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewHeight.setText(String.valueOf(progress + 100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewWeight.setText(String.valueOf(progress + 40));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    @SuppressLint("SetTextI18n")
    public void calculate(View view) {

        double bmi = Integer.parseInt(textViewWeight.getText().toString()) / Math.pow((Double.parseDouble(textViewHeight.getText().toString()) / 100), 2);

        int convertedBMI = (int) bmi;

        textViewBMI.setText(String.valueOf(convertedBMI));

        if (convertedBMI >= 30) {
            textBMIStatus.setText("Obese");
        } else if (convertedBMI >= 25) {
            textBMIStatus.setText("Overweight");
        } else if (convertedBMI >= 19) {
            textBMIStatus.setText("Normal");
        } else {
            textBMIStatus.setText("Underweight");
        }
    }
}