package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class q4 extends AppCompatActivity {
    Button b;
    int score;
    RadioGroup rg1;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        rg1=findViewById(R.id.rg1);
        Bundle bundle=getIntent().getExtras();
        score=bundle.getInt("score");
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg1.getCheckedRadioButtonId();
                rb=findViewById(id);
                if(rb.getText().toString().equals("Android:src=@drawable/img")) score=score + 1;
                Intent intent=new Intent(q4.this,q5.class);
                intent.putExtra("score",score);
                startActivity(intent);
            }
        });
    }
}