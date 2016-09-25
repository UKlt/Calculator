package com.example.caculator.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String total = "";
    double v1,v2;
    String sign = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClick(View v) {
        Button button = (Button)v;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText(total);
    }
    public void OnAdd(View v) {
        EditText edit = (EditText)findViewById(R.id.editText);
        total = edit.getText().toString();
        v1 = Double.parseDouble(total);
        total = "";
        Button button = (Button)v;
        String str = button.getText().toString();
        sign = str;
        //EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText("");
    }
    public void OnCalculate2(View v){
        EditText edit = (EditText)findViewById(R.id.editText);
        total = edit.getText().toString();
        v1 = Double.parseDouble(total);
        total = "";
        Button button = (Button)v;
        String str = button.getText().toString();
        sign = str;
        //EditText edit = (EditText)findViewById(R.id.editText);
        //double grand_total = 0;
        if(sign.equals("\u00B2\u221a")){
            v1 = Math.sqrt(v1);
        }else if(sign.equals("\u215F\u2093")){
            v1 = 1/v1;
        }
        edit.setText(v1+"");
    }
    public void OnCalculate(View v){
        EditText edit = (EditText)findViewById(R.id.editText);
        String str2 = edit.getText().toString();
        v2 = Double.parseDouble(str2);
        double grand_total=v2;
        if(sign.equals("+")){
            grand_total = v1+v2;
        }else if(sign.equals("-")){
            grand_total = v1-v2;
        }else if(sign.equals("\u00D7")){
            grand_total = v1*v2;
        }else if(sign.equals("\u00F7")){
            grand_total = v1/v2;
        }else if(sign.equals("^")){
            grand_total = Math.pow(v1, v2);
        }
        edit.setText(grand_total+"");
    }
    public void OnDelete(View v){
        EditText edit = (EditText)findViewById(R.id.editText);
        String text = edit.getText().toString();
        edit.setText(text.substring(0, text.length() - 1));
        total = text.substring(0, text.length() - 1);
    }
    public void OnClear(View v){
        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText("");
        total = "";
    }

}
