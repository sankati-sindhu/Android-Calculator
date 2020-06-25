package com.example.calcv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //intializing the variables used as global

    //ans is contains, what is to be displayed in the text field output
    String buffer = "0";
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, dec, add, sub, mult, div, per, equ2, del, clear;
    TextView tv;
    boolean operator = false, decBef = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declaration of buttons
        b00 = findViewById(R.id.b00);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        dec = findViewById(R.id.bdecimal);
        add = findViewById(R.id.bplus);
        sub = findViewById(R.id.bminus);
        mult = findViewById(R.id.bmult);
        div = findViewById(R.id.bdivide);
        per = findViewById(R.id.percent);
        clear = findViewById(R.id.bclear);
        del = findViewById(R.id.bdel);
        dec = findViewById(R.id.bdecimal);
        tv = findViewById(R.id.output);

        //initalizing the listeners
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("00");
                tv.setText(buffer);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("0");
                tv.setText(buffer);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update( "1");
                tv.setText(buffer);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("2");
                tv.setText(buffer);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("3");
                tv.setText(buffer);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("4");
                tv.setText(buffer);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("5");
                tv.setText(buffer);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("6");
                tv.setText(buffer);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("7");
                tv.setText(buffer);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("8");
                tv.setText(buffer);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               update("9");
               tv.setText(buffer);
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(".");
                tv.setText(buffer);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("+");
                tv.setText(buffer);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("-");
                tv.setText(buffer);
            }
        });

    }
    //updates the ans
    public void update(String newAdd){

        //checks if the current input is an operator
        boolean operatorCur = (newAdd.equals("+") || newAdd.equals("-") || newAdd.equals("/") || newAdd.equals("*") || newAdd.equals("%"));

        //if the input is an operator
        if(operatorCur){

            //we can now have decimal inputs
            decBef = false;
            //if the previous input is also an operator
            if(operator){
                //substitutes the previous operator with the new operator
                buffer = buffer.substring(0,buffer.length()-1);
                buffer = buffer.concat(newAdd);
            }
            //concats to the current buffer
            else{
                buffer = buffer.concat(newAdd);
            }

        }
        //if current input is decimal
        else if(newAdd.equals(".")) {
            //if previous input(s) were not a decimal starting from the previous operator or strart.
            if (!decBef) {
                //concats to the current buffer
                decBef = true;
                buffer = buffer.concat(newAdd);

            }
        }
        //if the buffer is not 0, we concat the current input(number) to buffer
        else if(!buffer.equals("0")){
            buffer = buffer.concat(newAdd);
        }
        //if the input is 00 and buffer equal to 0, the buffer remains same
        else if(newAdd.equals("00")){
            buffer =  "0";
        }
        //if the buffer is 0 and input is a number(0 to 9), buffer is intialized to the current input
        else{
            buffer =  newAdd;
        }
        operator = operatorCur;

    }

}

/*
* to do
* buffer evaluate = ?
*
* evaluate:
* travel left to right, can use stack
* stack[] = {}
* for element in buffer{
*   if element.isdigit()
*
* should i add '(' ')' ??
*/



