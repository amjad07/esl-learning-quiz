package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewCredentials extends AppCompatActivity {

    Button btn_login;
    EditText et_password;
    EditText et_password_again;

    SharedPreferences sharedPref;

    ImageView register_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_credentials);


        initComponents();

/*        et_email.setText("aaa@g.com");
        et_password.setText("123");*/

        register_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewCredentials.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = ( NewCredentials.this).getSharedPreferences("myfile", Context.MODE_PRIVATE);

                //boolean check = sharedPref.getBoolean("check",false);
                SharedPreferences.Editor editor = ((Activity) NewCredentials.this).getSharedPreferences("myfile", Context.MODE_PRIVATE).edit();


                if( et_password.getText().toString().equals(et_password_again.getText().toString())){

                    if(et_password.getText().toString().length() >= 8){
                        editor.putString("et_password",et_password.getText().toString());
                        editor.apply();

                        switchActivity();
                    }
                    else{
                        Toast.makeText(NewCredentials.this,"Password must be 8 chars long",Toast.LENGTH_SHORT).show();

                    }


                }
                else {
                    Toast.makeText(NewCredentials.this,"Password do\'not match",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void switchActivity(){
        Intent intent = new Intent(NewCredentials.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    public void initComponents(){
        register_image = findViewById(R.id.register_image);
        btn_login = findViewById(R.id.btn_login);
        et_password = findViewById(R.id.et_password1);
        et_password_again = findViewById(R.id.et_password_again);
    }
}
