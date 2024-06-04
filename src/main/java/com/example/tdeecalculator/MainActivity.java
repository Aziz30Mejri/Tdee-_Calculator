package com.example.tdeecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration des variables
    Button button;
    EditText ed_lastname,ed_firstname,ed_phone,ed_age;
    RadioGroup radio_sex;
    RadioButton rb_h,rb_f;
    SharedPreferences sharedPreferences;
    String genre;


    //creer shared preferences
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_LASTNAME="lastname";
    private static final String KEY_FIRSTNAME="firstname";
    private static final String KEY_PHONE="phone";
    private static final String KEY_AGE="age";
    private static final String KEY_SEX="sex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialisation des variable

        ed_lastname = findViewById(R.id.last_name);
        ed_firstname = findViewById(R.id.first_name);
        ed_phone = findViewById(R.id.phone);
        ed_age = findViewById(R.id.age);
        button = findViewById(R.id.next);
        radio_sex= findViewById(R.id.rd_sex);
        rb_h = findViewById(R.id.radioMale);
        rb_f = findViewById(R.id.radioFemale);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String lastname = sharedPreferences.getString(KEY_LASTNAME,null);
        String firstname = sharedPreferences.getString(KEY_FIRSTNAME,null);
        String phone = sharedPreferences.getString(KEY_PHONE,null);
        String age = sharedPreferences.getString(KEY_AGE,null);


        if (lastname!=null && firstname!=null && phone!=null && age!=null ){
            Intent i2 = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(i2);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                // Conditions sur les EditeText if isEmpty
                if (TextUtils.isEmpty(ed_lastname.getText().toString().trim())) {
                    ed_lastname.setError("Please check the Name");
                    return;
                }
                if (TextUtils.isEmpty(ed_firstname.getText().toString())) {
                    ed_firstname.setError("Please check the First Name");
                    return;
                }
                if (ed_phone.length() != 8) { // format du numéro du telephone
                    ed_phone.setError("Please check the Phone Number");
                    return;
                }

                if (ed_age.length() != 2) { // format d'age logique composé de 2 chiffres
                    ed_age.setError("Please check the Age");
                    return;
                }
                if (rb_h.isChecked()) {
                    genre = "Male";
                } else if (rb_f.isChecked()) {
                    genre = "Female";
                }
                //Toast
                Toast.makeText(MainActivity.this, " Registered Information ", Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_LASTNAME,ed_lastname.getText().toString());
                editor.putString(KEY_FIRSTNAME,ed_firstname.getText().toString());
                editor.putString(KEY_PHONE,ed_phone.getText().toString());
                editor.putString(KEY_AGE,ed_age.getText().toString());

                editor.apply();

                // intent vers page 2
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}