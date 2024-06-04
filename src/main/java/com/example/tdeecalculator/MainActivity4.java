package com.example.tdeecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    Button btn;
    EditText ed_Height, ed_Weight, ed_age;
    TextView result;
    RadioButton male, female, r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ed_Height = findViewById(R.id.height);
        ed_Weight = findViewById(R.id.weight);
        ed_age = findViewById(R.id.age);
        btn = findViewById(R.id.calcul);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        r1 = findViewById(R.id.radioSen);
        r2 = findViewById(R.id.radioAct);
        r3 = findViewById(R.id.radioTAct);
        result = findViewById(R.id.tv1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(ed_Height.getText().toString().trim())) {
                    ed_Height.setError("Select Height");
                    return;
                }
                if (TextUtils.isEmpty(ed_Weight.getText().toString())) {
                    ed_Weight.setError("Select Weight");
                    return;
                }
                if (TextUtils.isEmpty(ed_age.getText().toString())) {
                    ed_age.setError("Select Age");
                    return;
                } else {
                    calcul();
                }
            }

            public void calcul() {
                float Height = Float.parseFloat(ed_Height.getText().toString());
                float Weight = Float.parseFloat(ed_Weight.getText().toString());
                int age = Integer.parseInt(ed_age.getText().toString());
                float calories;

                if (male.isChecked() &&r1.isChecked()) {
                    calories = (float) (((13.7516 * Weight) + (500.33 * Height) - (6.7550 * age) + 66.479)* 1.375);
                    result.setText("Your Calories is: "+calories);
                }if (male.isChecked() &&r2.isChecked()) {
                    calories = (float) (((13.7516 * Weight) + (500.33 * Height) - (6.7550 * age) + 66.479)*1.64);
                    result.setText("Your Calories is: "+calories);
                }if (male.isChecked() &&r3.isChecked()) {
                    calories = (float) (((13.7516 * Weight) + (500.33 * Height) - (6.7550 * age) + 66.479)*1.82);
                    result.setText("Your Calories is: "+calories);
                }
                if (female.isChecked()&& r1.isChecked()) {
                    calories = (float) (((9.740 * Weight) + (184.96 * Height) - (4.6756 * age) + 655.095)*1.375);
                    result.setText("Your Calories is: "+calories);
                }if (female.isChecked()&& r2.isChecked()) {
                    calories = (float) (((9.740 * Weight) + (184.96 * Height) - (4.6756  * age) + 655.095)*1.64);
                    result.setText("Your Calories is: "+calories);
                }if (female.isChecked()&& r3.isChecked()) {
                    calories = (float) (((9.740 * Weight) + (184.96 * Height) - (4.6756  * age) + 655.095)*1.82);
                    result.setText("Your Calories is: "+calories);
                }
            }
        });
    }
}
