package com.example.tdeecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    EditText ed_mail, ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_mail = findViewById(R.id.mail);
        ed_password = findViewById(R.id.password);
        button = findViewById(R.id.cnx);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
                validatePassword();
                connexion();
            }
        });
    }
    private boolean validateEmail() { // EditText sous format mail
        String emailInput = ed_mail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            ed_mail.setError("Please check the mail");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            ed_mail.setError("Please check the mail");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword() {  // EditTexxt sous format du password
        String passwordInput = ed_password.getText().toString().trim();
        String ConfitmpasswordInput = ed_password.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            ed_password.setError("Please check the Password");
            return false;
        }
        if (passwordInput.length() < 8) {
            ed_password.setError("Please check the Password");
            return false;
        }
        if (!passwordInput.equals(ConfitmpasswordInput)) {
            ed_password.setError("Please check the Password");
            return false;
        }
        else {
            return true;}
    }
    private void connexion() {
        if ( validateEmail()==true && validatePassword()==true){
            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(i);
        }
    }
}

