package com.example.bharatintern_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    TextView result;
    Button cancelbtn;
    Button deletebtn;
    Button nosevenbtn;
    Button noeightbtn;
    Button noninebtn;
    Button nofourbtn;
    Button nofivebtn;
    Button nosixbtn;
    Button noonebtn;
    Button notwobtn;
    Button nothreebtn;
    Button nozerobtn;
    Button plusbtn;
    Button minusbtn;
    Button multiplybtn;
    Button divisionbtn;
    Button dotbtn;
    Button equalsbtn;
    double firstNum;
    String operation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
       result = findViewById(R.id.resultid);
        equalsbtn=findViewById(R.id.equalsbtn);
        dotbtn=findViewById(R.id.dotbtn);
        multiplybtn = findViewById(R.id.multiply_btn);
        divisionbtn=findViewById(R.id.division_btn);
        plusbtn=findViewById(R.id.plusbtn);
        minusbtn=findViewById(R.id.minusbtn);
        cancelbtn=findViewById(R.id.cancelbtn);
        deletebtn=findViewById(R.id.deletebtn);
       noeightbtn=findViewById(R.id.no8btn);
        nofivebtn=findViewById(R.id.no5btn);
        nofourbtn=findViewById(R.id.no4btn);
        noninebtn=findViewById(R.id.no9btn);
        noonebtn=findViewById(R.id.no1btn);
        nozerobtn=findViewById(R.id.no0btn);
       notwobtn=findViewById(R.id.no2btn);
        nothreebtn=findViewById(R.id.no3btn);
        nosixbtn=findViewById(R.id.no6btn);
        nosevenbtn=findViewById(R.id.no7btn);

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("0");
            }
        });
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(noonebtn);
        nums.add(notwobtn);
        nums.add(nothreebtn);
        nums.add(nofourbtn);
        nums.add(nofivebtn);
        nums.add(nosixbtn);
        nums.add(nosevenbtn);
        nums.add(noeightbtn);
        nums.add(noninebtn);
        nums.add(nozerobtn);

        for(Button b : nums){
            b.setOnClickListener(view -> {
                if(!result.getText().toString().equals("0")){
                    result.setText(result.getText().toString()+b.getText().toString());
                }else{
                    result.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> oper = new ArrayList<>();
        oper.add(plusbtn);
        oper.add(minusbtn);
        oper.add(multiplybtn);
        oper.add(divisionbtn);


        for (Button b : oper) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(result.getText().toString());
                operation = b.getText().toString();
                result.setText("0");
            });
        }

        deletebtn.setOnClickListener(view -> {
            String num = result.getText().toString();
            if (num.length()>1) {
                result.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")) {
                result.setText("0");
            }
        });
        dotbtn.setOnClickListener(view -> {
            if (!result.getText().toString().contains(".")) {
                result.setText(result.getText().toString() + ".");
            }
        });
        equalsbtn.setOnClickListener(view -> {
            String currentDisplay = result.getText().toString();
            double equalresult = 0;
            if (currentDisplay.contains(operation)) {
                String[] parts = currentDisplay.split(" ");
                double secondNum = Double.parseDouble(parts[1]);

                switch (operation){
                    case "÷":
                        equalresult = firstNum/secondNum;
                        break;
                    case "x":
                        equalresult = firstNum * secondNum;
                        break;
                    case "-":
                        equalresult = firstNum - secondNum;
                        break;
                    case "+":
                        equalresult = firstNum + secondNum;
                        break;
                }
                result.setText(String.valueOf(equalresult));
                firstNum = equalresult;
            } else {
                double secondNum = Double.parseDouble(currentDisplay);

                switch (operation){
                    case "÷":
                        equalresult = firstNum/secondNum;
                        break;
                    case "x":
                        equalresult = firstNum * secondNum;
                        break;
                    case "-":
                        equalresult = firstNum - secondNum;
                        break;
                    case "+":
                        equalresult = firstNum + secondNum;
                        break;
                }
                result.setText(String.valueOf(equalresult));
                firstNum = equalresult;
            }
        });

    }
}