package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bts,btu,btt;
    EditText ed;
    static int count = 0;
    static int Layoutno = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Layoutno = 1;
        setContentView(R.layout.activity_main);

        btt= (Button)findViewById(R.id.button1);
        bts= (Button)findViewById(R.id.button2);
        ed= (EditText)findViewById(R.id.editTextTextPersonName);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed_text = ed.getText().toString();

                if(ed_text.length() == 0){
                    Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_SHORT).show();
                }
                else {
                    Layoutno = 3;
                    Intent i = new Intent(getApplicationContext(),StartButton.class);
                    i.putExtra("name",ed_text);
                    startActivity(i);
                }
            }
        });


        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Layoutno = 2;
                setContentView(R.layout.activity_about_button);

                btu= (Button)findViewById(R.id.button_second);

                btu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Layoutno = 1;
                        Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent1);
                    }
                });
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(Layoutno == 9){
            Layoutno = 8;
            setContentView(R.layout.fragment_fifth__que);
        }
        else if(Layoutno == 8){
            Layoutno = 7;
            setContentView(R.layout.fragment_fourth__que);
        }
        else if(Layoutno == 7){
            Layoutno = 6;
            setContentView(R.layout.fragment_third__que);
        }
        else if(Layoutno == 6){
            Layoutno = 5;
            setContentView(R.layout.fragment_secon__que);
        }
        else if(Layoutno == 5){
            Layoutno = 4;
            setContentView(R.layout.fragment_first_que);
        }
        else if(Layoutno == 4){
            Layoutno = 3;
            setContentView(R.layout.activity_start_button);
        }
        else if (Layoutno == 3){
            Layoutno = 2;
            setContentView(R.layout.activity_main);
        }
        else if (Layoutno == 2){
            Layoutno = 1;
            setContentView(R.layout.activity_main);
        }
        else {
            super.onBackPressed();
        }
    }
}