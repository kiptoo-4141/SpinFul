package com.kiptoo.spinful;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.kiptoo.spinful.activity.LoginActivity;
import com.kiptoo.spinful.activity.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("SpinfulPrefs", MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean("is_first_run", true);

        if (!isFirstRun) {
            // Check if logged in
            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
            finish();
            return; // Skip the splash animation entirely
        }

        setContentView(R.layout.activity_splash);

        // Initialize UI Elements
        View logoContainer = findViewById(R.id.logoContainer);
        ImageView innerWheel = findViewById(R.id.logoInnerWheel);
        ImageView centerS = findViewById(R.id.logoCenterS);
        TextView textTitle = findViewById(R.id.textTitle);
        TextView textSubtitle = findViewById(R.id.textSubtitle);

        // 1. Set Initial Animation States (Hidden/Offset)
        logoContainer.setScaleX(0f);
        logoContainer.setScaleY(0f);
        centerS.setScaleX(0f);
        centerS.setScaleY(0f);
        textTitle.setTranslationY(50f);
        textSubtitle.setTranslationY(30f);

        // 2. Animate Logo Scale Up (Bounces slightly into place)
        logoContainer.animate()
                .scaleX(1.0f)
                .scaleY(1.0f)
                .setDuration(1000)
                .setInterpolator(new OvershootInterpolator(1.2f))
                .start();

        // 3. Animate Inner Wheel Spin (Fast start, smooth deceleration)
        innerWheel.animate()
                .rotation(720f) // Two complete 360-degree spins
                .setDuration(1400)
                .setInterpolator(new DecelerateInterpolator())
                .start();

        // 4. Pop out the center 'S' emblem shortly after the wheel starts spinning
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                centerS.animate()
                        .scaleX(1.0f)
                        .scaleY(1.0f)
                        .setDuration(400)
                        .setInterpolator(new OvershootInterpolator())
                        .start();
            }
        }, 600);

        // 5. Fade In & Slide Up Text Elements
        textTitle.animate()
                .alpha(1.0f)
                .translationY(0f)
                .setDuration(800)
                .setStartDelay(800)
                .start();

        textSubtitle.animate()
                .alpha(1.0f)
                .translationY(0f)
                .setDuration(800)
                .setStartDelay(1000)
                .start();

        // 6. Intent Transition to Main Screen
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("SpinfulPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("is_first_run", false);
                editor.apply();

                Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(intent);

                // Smooth crossfade out of the splash screen
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 2800);
    }
}