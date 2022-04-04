package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class resultat extends AppCompatActivity {
    Button b1;
    EditText e1;
    TextView t1;
    int score;
    String s;
    dbhelp db;
    KonfettiView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        c = findViewById(R.id.c);
        c.build()
                .addColors(Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, c.getWidth() + 500f, -50f, -50f)
                .streamFor(300, 5000L);
        b1 = findViewById(R.id.b);
        e1 = findViewById(R.id.e1);
        db = new dbhelp(this);
        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");
        s = String.valueOf(score);
        t1 = findViewById(R.id.textView2);
        t1.setText(s);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertdata(e1.getText().toString(), s);
                Intent intent = new Intent(resultat.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}