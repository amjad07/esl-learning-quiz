package com.example.esllearningquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class QuizActivity extends AppCompatActivity {
    int cat;
     int score = 0;
     int skip_button = 0;
    int flag=0;
    TextView current_cat;
    TextView questions_total;
    TextView question_txt;
    TextView score_txt;
    RadioGroup answersgrp;
    RadioButton radioButton;
    RadioButton radioButton_1;
    RadioButton radioButton_2;
    RadioButton radioButton_3;
    Button skip, submit;
    int temp;

    public int marks=0,correct=0,wrong=0;

    String questions[];
    String answers[];
    String opt[];





    public void CatOneQuestion(){

        questions = new String[]{
                "Q1: _____ Students finished the test.",
                "Q2: I’m free today, but ______ on Friday.",
                "Q3: I wrote to her, but got _____ reply.",
                "Q4: Most complained about the result, but ____ the winners.",
                "Q5: This is a _____ smoking area."
        };
        answers = new String[]{
                "No",
                "Not",
                "No",
                "Not",
                "Not"
        };

        opt = new String[]{
                "No","Not",
                "No","Not",
                "No","Not",
                "No","Not",
                "No","Not"
        };

        current_cat.setText(R.string.btn_cat);
        question_txt.setText(questions[0]);
        question_txt.setText(questions[0]);
        radioButton.setText(opt[0]);
        radioButton_1.setText(opt[1]);

    }
    public void CatTwoQuestion(){
        questions = new String[]{
                "Q1: Be Careful-she’s _____ fool.",
                "Q2: He’s done ____ of the homework yet.",
                "Q3: ____ students came to the class on Friday.",
                "Q4: __ of us did it.",
                "Q5: I have ____ idea what to do."

        };
        answers = new String[]{
                "No",
                "None",
                "No",
                "None",
                "No"
        };

        opt = new String[]{
                "No","None","Not",
                "No","None","Not",
                "No","None","Not",
                "No","None","Not",
                "No","None","Not"
        };
        radioButton_2.setVisibility(View.VISIBLE);
        current_cat.setText(R.string.btn_cat);
        question_txt.setText(questions[0]);
        question_txt.setText(questions[0]);
        radioButton.setText(opt[0]);
        radioButton_1.setText(opt[1]);
        radioButton_2.setText(opt[2]);

    }
    public void CatThreeQuestion(){
        questions = new String[]{
                "Q1: You shouldn't do it like that, do it ____ way.",
                "Q2: Take one of _____ books from that pile.",
                "Q3: Can you see what ____ car’s registration is? It’s too far away for me.  ",
                "Q4: Waiter, I think ____ wine if off. ",
                "Q5: I spoke to her a few hours ago at the meeting ____ morning. "

        };

        answers = new String[]{
                "This",
                "Those",
                "That",
                "This",
                "This"
        };

        opt = new String[]{
                "This","Those","That","These",
                "This","Those","That","These",
                "This","Those","That","These",
                "This","Those","That","These",
                "This","Those","That","These",
        };

        radioButton_2.setVisibility(View.VISIBLE);
        radioButton_3.setVisibility(View.VISIBLE);
        current_cat.setText(R.string.btn_cat);
        question_txt.setText(questions[0]);
        question_txt.setText(questions[0]);
        radioButton.setText(opt[0]);
        radioButton_1.setText(opt[1]);
        radioButton_2.setText(opt[2]);
        radioButton_3.setText(opt[3]);

    }
    public void CatFourQuestion(){
        questions = new String[]{
                "Q1: I go there every____.",
                "Q2: There were cars parked on _____ side of the street.",
                "Q3: They looked at each _____. ",
                "Q4: Everybody ____ there. ",
                "Q5: I looked in ____ classroom, but couldn’t find her. ",

        };

        answers = new String[]{
                "Day",
                "Each",
                "Other",
                "Was",
                "Either could be used here",
        };

        opt = new String[]{
                "Day","Days","Either could be used here. ",
                "Each","Every","Either could be used here. ",
                "Other","Another","Either could be used here. ",
                "Was","Were","Either could be used here.",
                "Each","Every","Either could be used here.",
                "Day","Days","Either could be used here.",
        };

        radioButton_2.setVisibility(View.VISIBLE);
        current_cat.setText(R.string.btn_cat);
        question_txt.setText(questions[0]);
        question_txt.setText(questions[0]);
        radioButton.setText(opt[0]);
        radioButton_1.setText(opt[1]);
        radioButton_2.setText(opt[2]);

    }
    public void CatFiveQuestion(){
        questions = new String[]{
                "Q1: _____ two.",
                "Q2: There ____ a lot of people coming.",
                "Q3: There ____ a lot of water on the carpet. ",
                "Q4: There _____ a lot of noise coming from next door. ",
                "Q5: There ______ a lot of traffic in the rush hour."

        };

        answers = new String[]{
                "There are",
                "Are",
                "Is",
                "Is",
                "Is"
        };

        opt = new String[]{
                "There is",                "There are",
                "Is",                "Are",
                "Is",                "Are",
                "Is",                "Are",
                "Are","Is"
        };

        current_cat.setText(R.string.btn_cat);
        question_txt.setText(questions[0]);
        question_txt.setText(questions[0]);
        radioButton.setText(opt[0]);
        radioButton_1.setText(opt[1]);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initComponents();
        initValues();
        clickListners();



    }

    public void initComponents(){
        current_cat = findViewById(R.id.current_cat);
        score_txt = findViewById(R.id.score);
        questions_total = findViewById(R.id.questions);
        question_txt = findViewById(R.id.question_txt);
        answersgrp = findViewById(R.id.answersgrp);
        radioButton = findViewById(R.id.radioButton);
        radioButton_1 = findViewById(R.id.radioButton_1);
        radioButton_2 = findViewById(R.id.radioButton_2);
        radioButton_3 = findViewById(R.id.radioButton_3);
        skip = findViewById(R.id.skip);
        submit = findViewById(R.id.next);
    }

    public void clickListners(){
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++skip_button;
                conditionCheck();

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answersgrp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(answersgrp.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }



                conditionCheck();

            }
        });
    }

    public void setText(){
        score_txt.setText("Score: " + correct);
        if(temp == 1){

            questions_total.setText(flag+1 + "/5 Questions");
            question_txt.setText(questions[flag]);
            radioButton.setText(opt[flag*2]);
            radioButton_1.setText(opt[flag*2 +1]);
        }else if(temp == 2){
            questions_total.setText(flag+1 + "/5 Questions");
            question_txt.setText(questions[flag]);
            radioButton.setText(opt[flag*3]);
            radioButton_1.setText(opt[flag*3 +1]);
            radioButton_2.setText(opt[flag*3 +2]);
        }else if(temp == 3){
            questions_total.setText(flag+1 + "/5 Questions");
            question_txt.setText(questions[flag]);
            radioButton.setText(opt[flag*4]);
            radioButton_1.setText(opt[flag*4 +1]);
            radioButton_2.setText(opt[flag*4 +2]);
            radioButton_3.setText(opt[flag*4 +3]);
        }else if(temp == 4){
            questions_total.setText(flag+1 + "/5 Questions");
            question_txt.setText(questions[flag]);
            radioButton.setText(opt[flag*3]);
            radioButton_1.setText(opt[flag*3 +1]);
            radioButton_2.setText(opt[flag*3 +2]);
        }else if(temp == 5){
            questions_total.setText(flag+1 + "/5 Questions");
            question_txt.setText(questions[flag]);
            radioButton.setText(opt[flag*2]);
            radioButton_1.setText(opt[flag*2 +1]);
        }

    }
    public void conditionCheck(){
        flag++;
        if (score != 0)
            score = correct ;

        if(flag<questions.length)
        {

            setText();
        }
        else
        {
            marks=correct;
            Intent in = new Intent(getApplicationContext(),ResultActivity.class);
            in.putExtra("points", correct+"");
            in.putExtra("question_skip", skip_button+"");
            startActivity(in);
        }
        answersgrp.clearCheck();
    }
    public void initValues(){
        Intent intent = getIntent();
        temp = intent.getIntExtra("cat", 0); // here 0 is the default value

        score_txt.setText("Score: " + correct);
        if(temp == 1){
            CatOneQuestion();
        }else if(temp == 2){
            CatTwoQuestion();
        }else if(temp == 3){
            CatThreeQuestion();
        }else if(temp == 4){
            CatFourQuestion();
        }else if(temp == 5){
            CatFiveQuestion();
        }
    }
}