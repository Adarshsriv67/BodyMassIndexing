package com.example.bodymassindexing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        EditText wt, htFt, htIn;
        TextView result;
        androidx.constraintlayout.widget.ConstraintLayout parent;
        btn=findViewById(R.id.btn);
        wt=findViewById(R.id.editTextWt);
        htFt=findViewById(R.id.editTextHtFt);
        htIn=findViewById(R.id.editTextHtIn);
        result=findViewById(R.id.textViewRslt);
        parent=findViewById(R.id.parent);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight=Integer.parseInt(wt.getText().toString());
                int feet=Integer.parseInt(htFt.getText().toString());
                int inch=Integer.parseInt(htIn.getText().toString());

                int totalInch=feet*12 + inch;
                double totalCm=totalInch*2.53;
                double totalM=totalCm/100;

                double bmi=weight/(totalM*totalM);

                if(bmi<18.5)
                {
                    result.setText("You are UNDERWEIGHT!!!");
                    parent.setBackgroundColor(getResources().getColor(R.color.underweight));
                }
                else if(bmi>=18.5 && bmi<25)
                {
                    result.setText("You are HEALTHY!!!");
                    parent.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
                else if(bmi>=25)
                {
                    result.setText("You are OVERWEIGHT!!!");
                    parent.setBackgroundColor(getResources().getColor(R.color.overweight));
                }
            }
        });

    }
}