package com.example.tdeecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity3 extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4, textView5;
    Button button;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_LASTNAME="lastname";
    private static final String KEY_FIRSTNAME="firstname";
    private static final String KEY_PHONE="phone";
    private static final String KEY_AGE="age";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        button = findViewById(R.id.confirm);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String lastname = sharedPreferences.getString(KEY_LASTNAME,null);
        String firstname = sharedPreferences.getString(KEY_FIRSTNAME,null);
        String phone = sharedPreferences.getString(KEY_PHONE,null);
        String age = sharedPreferences.getString(KEY_AGE,null);

        textView1.setText("Last Name : "+lastname);
        textView2.setText("First Name : "+firstname);
        textView3.setText("Phone Number : "+phone);
        textView4.setText("Age : "+age);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(i);
            }
        });
    }
}
