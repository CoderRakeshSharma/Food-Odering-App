package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Categories extends AppCompatActivity {
    CheckBox biscuits,fastfood,softdrink;
    Button placeOrder;
    EditText quant_biscuits,quant_fastfood,quant_softdrink;
    int no_of_biscuits,no_of_fastfood,no_of_softdrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        createbill();
    }

    private void createbill() {
        biscuits=(CheckBox) findViewById(R.id.checkbox_biscuits);
        fastfood=(CheckBox) findViewById(R.id.checkbox_fastfood);
        softdrink=(CheckBox) findViewById(R.id.checkbox_softdrinks);
        placeOrder=(Button) findViewById(R.id.button);
        quant_biscuits=(EditText) findViewById(R.id.editTextTextPersonName);
        quant_fastfood=(EditText) findViewById(R.id.editTextTextPersonName2);
        quant_softdrink=(EditText) findViewById(R.id.editTextTextPersonName3);

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_of_biscuits=Integer.parseInt(quant_biscuits.getText().toString());
                no_of_fastfood=Integer.parseInt(quant_fastfood.getText().toString());
                no_of_softdrink=Integer.parseInt(quant_softdrink.getText().toString());
                int totalOrderval =0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:-\n");
                if(biscuits.isChecked())
                {
                    if(no_of_biscuits == 0)
                        no_of_biscuits=1;
                    result.append("biscuits "+no_of_biscuits +" 10INR\n");
                    totalOrderval=totalOrderval+(no_of_biscuits*10);
                }
                if(fastfood.isChecked())
                {
                    if(no_of_fastfood == 0)
                        no_of_fastfood=1;
                    result.append("fastfood " +no_of_fastfood+" 15INR\n");
                    totalOrderval=totalOrderval+(no_of_fastfood*15);
                }
                if(softdrink.isChecked())
                {
                    if(no_of_softdrink == 0)
                        no_of_softdrink=1;
                    result.append("softdrink "+no_of_softdrink+ " 20INR\n");
                    totalOrderval=totalOrderval+(no_of_softdrink*20);
                }
                result.append("Total: ").append("Rs").append(totalOrderval);
                Toast.makeText(getApplicationContext(),result.toString(), Toast.LENGTH_LONG).show();

            }
        });
        biscuits.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    quant_biscuits.setText("1");
                else
                    quant_biscuits.setText("0");
            }
        });
        fastfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    quant_fastfood.setText("1");
                else
                    quant_fastfood.setText("0");
            }
        });
        softdrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    quant_softdrink.setText("1");
                else
                    quant_softdrink.setText("0");
            }
        });

    }
}