package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class q1 extends AppCompatActivity {
    Button b,quit;
    int score=0;
    RadioGroup rg1;
    RadioButton rb;
    TextView scoreInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        rg1=findViewById(R.id.rg1);
        b=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg1.getCheckedRadioButtonId();
                rb=findViewById(id);
                if(rb.getText().toString().equals("5.666")) score=score + 1;
                Intent intent=new Intent(q1.this,q2.class);
                intent.putExtra("score",score);
                startActivity(intent);

            }
        });

    }
}