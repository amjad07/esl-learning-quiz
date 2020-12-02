package com.example.esllearningquiz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_answer;
    TextView et_email;
    SharedPreferences sharedPref;
    String  answer;

    ImageView register_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);


        initComponents();

/*        et_email.setText("aaa@g.com");
        et_password.setText("123");*/

        register_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = ( ForgetActivity.this).getSharedPreferences("myfile", Context.MODE_PRIVATE);

                //boolean check = sharedPref.getBoolean("check",false);
                answer = sharedPref.getString("sec_answer","@!!##@!");


                if( et_answer.getText().toString().equals(answer)){

                    switchActivity();

                }
                else {
                    Toast.makeText(ForgetActivity.this,"Answer do\'not match",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void switchActivity(){
        Intent intent = new Intent(ForgetActivity.this, NewCredentials.class);
        startActivity(intent);
    }

    public void initComponents(){
        register_image = findViewById(R.id.register_image);
        btn_login = findViewById(R.id.btn_login);
        et_email = findViewById(R.id.et_password1);
        et_answer = findViewById(R.id.et_password_again);
    }
}
