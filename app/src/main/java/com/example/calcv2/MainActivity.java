package com.example.calcv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //initializing the variables used as global

    //ans is contains, what is to be displayed in the text field output
    String buffer = "0";
    int[] bufferInx;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00, dec, add, sub, mul, div, per, equ2, del, clear;
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
        mul = findViewById(R.id.bmult);
        div = findViewById(R.id.bdivide);
        per = findViewById(R.id.bpercentage);
        clear = findViewById(R.id.bclear);
        del = findViewById(R.id.bdel);
        equ2 = findViewById(R.id.bequalto);
        tv = findViewById(R.id.output);

        //initializing the listeners
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
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("*");
                tv.setText(buffer);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("/");
                tv.setText(buffer);
            }
        });
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("%");
                tv.setText(buffer);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
                tv.setText(buffer);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buffer = "0";
                operator = false;
                decBef = false;
                tv.setText(buffer);
            }
        });
        equ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update("=");
                tv.setText(buffer);
            }
        });

    }
    //updates the ans
    public void update(String newAdd){

        //checks if the current input is an operator
        boolean operatorCur = (newAdd.equals("+") || newAdd.equals("-") || newAdd.equals("/") || newAdd.equals("*") || newAdd.equals("%"));
        if(newAdd.equals("=")){
            buffer = ""+evaluate();
        }
        //if the input is an operator
        else if(operatorCur){

            //we can now have decimal inputs
            decBef = false;
            //if the previous input is also an operator
            if(operator){
                //substitutes the previous operator with the new operator
                buffer = buffer.substring(0,buffer.length()-1);
            }
            //concats to the current buffer
            buffer = buffer.concat(newAdd);

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

    public void delete(){
        int i;
        if (buffer.endsWith(".")) {
            decBef = false;
        }
        else if(isOperator(buffer.charAt(buffer.length()-1)) > 0){
            operator = false;
        }
        //to do:
        /*debug
         * >decbef = true> operator add >decBef = False> delete op> decBef is still false
         * */ {
            if(buffer.length() <= 1){
                buffer = "0";
            }else {
                buffer = buffer.substring(0, buffer.length() - 1);
            }
        }
    }
    //does not follow BODMAS calculates what comes first.
    public double evaluate(){

        char[] expression = new char[buffer.length()];
        double lnum = 0, rnum;
        int i,curOP, prevOP= 1,indx= 0;
        for(i =0; i<buffer.length();i++){
            curOP = isOperator(buffer.charAt(i));
            if( curOP != 0 ){
                rnum = Double.parseDouble(buffer.substring(indx,i));
                lnum = calculate(lnum, rnum, prevOP);
                prevOP = curOP;
                indx = i+1;
            }
            else if((i == buffer.length()-1)){
                rnum = Double.parseDouble(buffer.substring(indx, i+1));
                lnum = calculate(lnum, rnum, prevOP);
                break;
            }

        }
        return lnum;


    }

    public int isOperator(char ch){
        switch (ch) {
            case '+':
                return 1;
            case '-':
                return 2;
            case '/':
                return 3;
            case '*':
                return 4;
            case '%':
                return 5;
            default:
                return 0;
        }
    }

    public double calculate(double no1,double no2,int op){
        switch (op){
            case 1:{
                return no1+no2;
            }
            case 2:{
                return no1 - no2;
            }
            case 3:{
                return no1/no2;
            }
            case 4:{
                return no1*no2;
            }
            case 5:{
                return (no1/100)*no2;
            }
            default:{
                return -1;
            }
        }
    }


}



