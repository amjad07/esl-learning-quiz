package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_email, et_password;
    SharedPreferences sharedPref;
    String email,pswrd;

    ImageView register_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponents();

        et_email.setText("a@g.com");
        et_password.setText("123");

        register_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = ( MainActivity.this).getSharedPreferences("myfile", Context.MODE_PRIVATE);

                //boolean check = sharedPref.getBoolean("check",false);
                pswrd = sharedPref.getString("et_password","");
                email = sharedPref.getString("et_email","");

                if(et_email.getText().toString().equals(email)  && et_password.getText().toString().equals(pswrd)){

                    switchActivity();

                }
                else {
                    Toast.makeText(MainActivity.this,"Credentials do\'not match",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void switchActivity(){
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void initComponents(){
        register_image = findViewById(R.id.register_image);
        btn_login = findViewById(R.id.btn_login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
    }
}
