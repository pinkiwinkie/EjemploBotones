package com.example.ejemplobotones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView viewCounter;
    private Button incrementButton;
    private Button decrementButton;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewCounter = findViewById(R.id.tvCount); //apunta al objeto del layout y por tanto se convierte en objeto
        incrementButton = findViewById(R.id.btnUp);
        decrementButton = findViewById(R.id.btnDown);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (viewCounter != null)
                    viewCounter.setText(Integer.toString(counter));
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewCounter != null) {
                    if (counter == 0)
                        viewCounter.setText(Integer.toString(counter));
                    else {
                        counter--;
                        viewCounter.setText(Integer.toString(counter));
                    }
                }
            }
        });
    }

    public void showToast(View view) {
        Toast tostada = Toast.makeText(this, "LINDAS VACACIONES", Toast.LENGTH_LONG);
        tostada.show();
    }
}