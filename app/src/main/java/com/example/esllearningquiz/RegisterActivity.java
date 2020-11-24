package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button btn_register;
    ImageView login_activity;
    EditText et_name,et_email,et_password,dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        login_activity = findViewById(R.id.login_activity);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        dob = findViewById(R.id.dob);


        login_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_name.getText().toString() != null && et_name.getText().toString() != null &&et_name.getText().toString() != null &&et_name.getText().toString() != null ){
                    if(isValidEmail(et_email.getText().toString())){

                        SharedPreferences.Editor editor = ((Activity) RegisterActivity.this).getSharedPreferences("myfile", Context.MODE_PRIVATE).edit();
                        editor.putString("et_name",et_name.getText().toString());
                        editor.putString("et_email",et_email.getText().toString());
                        editor.putString("et_password",et_password.getText().toString());
                        editor.putString("dob",dob.getText().toString());
                        editor.putString("et_name",et_name.getText().toString());
                        editor.apply();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Please enter email carefully",Toast.LENGTH_SHORT).show();

                    }


                }
                else{
                    Toast.makeText(RegisterActivity.this,"Please enter all fields carefully",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}