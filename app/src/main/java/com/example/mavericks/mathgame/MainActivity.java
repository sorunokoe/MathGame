package com.example.mavericks.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import java.util.stream.*;


public class MainActivity extends AppCompatActivity {

    TextView number1, number2, operation;
    Button btn1, btn2, btn3, btn4, resultBtn;
    ArrayList<Button> btnList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();



        startGame();






    }

    void setViews(){
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        operation = findViewById(R.id.operation);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
    }
    void startGame(){
        Random random = new Random();
        int n1 = random.nextInt(10)+1;
        int n2 = random.nextInt(10)+1;

        int result = 0;
        char op = '+';

        switch (random.nextInt(4)){
            case 0:
                op = '+';
                result = n1+n2;
                break;
            case 1:
                op = '-';
                result = n1-n2;
                break;
            case 2:
                op = '*';
                result = n1*n2;
                break;
            case 3:
                op = '/';
                result = n1/n2;
                break;
        }

        number1.setText(new Integer(n1).toString());
        number2.setText(new Integer(n2).toString());
        operation.setText(new Character(op).toString());


        for(int i=0; i<btnList.size();i++){
            int number = random.nextInt(20)+3;
            if(number != result){
                btnList.get(i).setText(new Integer(number).toString());
            }else{
                i--;
            }
        }


        resultBtn = btnList.get(random.nextInt(4));
        resultBtn.setText(new Integer(result).toString());
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

    }

}
