package com.dolgozat.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textOutput;
private RelativeLayout relativeLayout;
private Button btnAdd;
private Button btnRemove;
public int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
    relativeLayout = findViewById(R.id.RelativeLayout);
    textOutput = findViewById(R.id.textOutput);
    btnAdd = findViewById(R.id.btnAdd);
    btnRemove = findViewById(R.id.btnRemove);

    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            value++;
            textOutput.setText(String.valueOf(value));
            setColor();
        }
    });

    btnRemove.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            value--;
            setValue();
            setColor();
        }
    });

    textOutput.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            value = 0;
            setColor();
            setValue();
            return true;
        }
    });
    }



    private void setColor(){
        if (value == 0){
            textOutput.setTextColor(Color.rgb(0, 0,255));
        }
        else if(value > 0){
            textOutput.setTextColor(Color.rgb(0,255,0));
        }
        else{
            textOutput.setTextColor(Color.RED);

        }


    }
    private void setValue(){
        textOutput.setText(String.valueOf(value));
    }
}