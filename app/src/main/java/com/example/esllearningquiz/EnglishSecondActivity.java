package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnglishSecondActivity extends AppCompatActivity {

    Button btn_cat;
    Button btn_cat_1;
    Button btn_cat_2;
    Button btn_cat_3;
    Button btn_cat_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_second);
        initComponents();
        btn_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(1);

            }
        });
        btn_cat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(2);

            }
        });
        btn_cat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(3);

            }
        });
        btn_cat_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(4);

            }
        });
        btn_cat_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(5);

            }
        });
    }

    public void switchActivity(int cat){
        Intent intent = new Intent(EnglishSecondActivity.this, QuizActivity.class);
        intent.putExtra("cat", cat);
        startActivity(intent);
    }

    public void initComponents(){
        btn_cat = findViewById(R.id.btn_cat);
        btn_cat_1 = findViewById(R.id.btn_cat_1);
        btn_cat_2 = findViewById(R.id.btn_cat_2);
        btn_cat_3 = findViewById(R.id.btn_cat_3);
        btn_cat_4 = findViewById(R.id.btn_cat_4);
    }
}