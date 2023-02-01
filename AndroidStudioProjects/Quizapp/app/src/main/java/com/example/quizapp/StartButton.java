package com.example.quizapp;

import static com.example.quizapp.MainActivity.Layoutno;
import static com.example.quizapp.MainActivity.count;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class StartButton extends AppCompatActivity {

    TextView t1,t3;
    Button btn_Next,btn_Quit;
    int a = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_button);

        t3 = (TextView)findViewById(R.id.textview_name2);


        ArrayList arrayList = new ArrayList<Fragment>();
        arrayList.add(new FirstQue());
        arrayList.add(new Secon_Que());
        arrayList.add(new Third_Que());
        arrayList.add(new Fourth_Que());
        arrayList.add(new Fifth_Que());

        change_fragment((Fragment) arrayList.get(a));

        btn_Next= (Button)findViewById(R.id.button_first);
        btn_Quit= (Button)findViewById(R.id.button_second);



        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3.setText(count+"");
                Layoutno++;
                if(a< arrayList.size()){
                    change_fragment((Fragment) arrayList.get(a++));
                }
                else {
                    Intent i = new Intent(getApplicationContext(),Result.class);
                    startActivity(i);
                }

//                if (a>= arrayList.size()-1){
//                    Intent i = new Intent(getApplicationContext(),Result.class);
//                    startActivity(i);
//                }
            }
        });

        btn_Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Layoutno = 9;
                Intent i = new Intent(getApplicationContext(),Result.class);
                startActivity(i);
            }
        });



        //Toast.makeText(this,intent.getStringExtra("name"),Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String t2 = intent.getStringExtra("name");


        t1 = (TextView)findViewById(R.id.textview_name);
        t1.setText("Hello "+t2);


    }

    public void change_fragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentlayout,fragment);
        fragmentTransaction.commit();
    }
}