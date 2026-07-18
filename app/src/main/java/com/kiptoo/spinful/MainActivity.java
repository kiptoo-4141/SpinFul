package com.kiptoo.spinful;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout cardWheel = findViewById(R.id.cardWheel);
        Button btnCards = findViewById(R.id.btnCards);
        Button btnProfile = findViewById(R.id.btnProfile);

        cardWheel.setOnClickListener(v -> Toast.makeText(this, "Spinning the Wheel!", Toast.LENGTH_SHORT).show());
        btnCards.setOnClickListener(v -> Toast.makeText(this, "Opening Cards...", Toast.LENGTH_SHORT).show());
        btnProfile.setOnClickListener(v -> Toast.makeText(this, "Opening Profile...", Toast.LENGTH_SHORT).show());
    }
}