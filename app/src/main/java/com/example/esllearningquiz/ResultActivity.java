package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView name_person;
    TextView total_points;
    TextView questions_skip;
    SharedPreferences sharedPref;
    String name;
    String points;
    String questionSkip;
    Button main_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initComponents();
        setValues();




        main_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ResultActivity.this, CategoryActivity.class);
                startActivity(intent1);
                finishAffinity();
            }
        });

    }
    public void initComponents(){
        name_person = findViewById(R.id.name_person);
        total_points = findViewById(R.id.total_points);
        questions_skip = findViewById(R.id.questions_skip);
        main_cat = findViewById(R.id.main_cat);
    }
    public void setValues(){
        final Intent intent = getIntent();
        points = intent.getStringExtra("points");
        questionSkip = intent.getStringExtra("question_skip");

        sharedPref = ( ResultActivity.this).getSharedPreferences("myfile", Context.MODE_PRIVATE);
        name = sharedPref.getString("et_name","");

        name_person.setText("Hi, " + name);
        total_points.setText("Total points: " + points + " / 5");
        questions_skip.setText("Question Skip: " + questionSkip );
    }
}