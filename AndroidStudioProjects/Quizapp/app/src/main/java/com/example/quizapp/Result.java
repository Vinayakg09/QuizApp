package com.example.quizapp;

import static com.example.quizapp.MainActivity.count;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        b1= (Button)findViewById(R.id.restart);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        t1=(TextView)findViewById(R.id.textviewr1);
        t2=(TextView)findViewById(R.id.textviewr2);
        t3=(TextView)findViewById(R.id.textviewr3);

        t1.setText("Correct answer "+count);
        t2.setText("Wrong answer "+ (5-count));
        t3.setText("Final Result "+count);
    }
}