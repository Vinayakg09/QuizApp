package com.example.quizapp;

import static com.example.quizapp.MainActivity.count;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Third_Que extends Fragment implements View.OnClickListener {

    RadioGroup r1;
    View v1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v1= inflater.inflate(R.layout.fragment_third__que, container, false);

        r1 = v1.findViewById(R.id.radiogroup);

        String a = "main method";

        v1.findViewById(R.id.rb1).setOnClickListener(this);
        v1.findViewById(R.id.rb2).setOnClickListener(this);
        v1.findViewById(R.id.rb3).setOnClickListener(this);
        v1.findViewById(R.id.rb4).setOnClickListener(this);
        return v1;
    }
    @Override
    public void onClick(View view) {
        int c = 0;

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){

            case R.id.rb1:
                Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT ).show();
                c = 1;
                break;

            case R.id.rb2:
                Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT ).show();
                c = 0;
                break;

            case R.id.rb3:
                Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT ).show();
                c = 0;
                break;
            case R.id.rb4:
                Toast.makeText(getActivity(),"Wrong", Toast.LENGTH_SHORT).show();
                c = 0;
                break;
        }
        if(count < 3){
            count = count+c;
        }

        //Toast.makeText(view.getContext(), count,Toast.LENGTH_SHORT).show();
        System.out.println(count);
    }


}