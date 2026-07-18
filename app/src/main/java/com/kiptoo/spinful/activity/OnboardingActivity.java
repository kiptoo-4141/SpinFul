package com.kiptoo.spinful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.kiptoo.spinful.R;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Button btnSkip, btnNext;
    private OnboardingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);
        btnSkip = findViewById(R.id.btnSkip);
        btnNext = findViewById(R.id.btnNext);

        int[] layouts = new int[]{
                R.layout.slide_welcome,
                R.layout.slide_how_to_play,
                R.layout.slide_age_gate,
                R.layout.slide_categories
        };

        adapter = new OnboardingAdapter(layouts);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == layouts.length - 1) {
                    btnNext.setText("Get Started");
                    btnSkip.setVisibility(View.GONE);
                } else {
                    btnNext.setText("Next");
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSkip.setOnClickListener(v -> navigateToLogin());

        btnNext.setOnClickListener(v -> {
            int current = viewPager.getCurrentItem();
            if (current < layouts.length - 1) {
                viewPager.setCurrentItem(current + 1);
            } else {
                navigateToLogin();
            }
        });
    }

    private void navigateToLogin() {
        startActivity(new Intent(OnboardingActivity.this, LoginActivity.class));
        finish();
    }

    private class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

        private final int[] layouts;

        OnboardingAdapter(int[] layouts) {
            this.layouts = layouts;
        }

        @NonNull
        @Override
        public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
            return new OnboardingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
            if (layouts[position] == R.layout.slide_age_gate) {
                Button btnYes = holder.itemView.findViewById(R.id.btnAgeYes);
                Button btnNo = holder.itemView.findViewById(R.id.btnAgeNo);

                if (btnYes != null) {
                    btnYes.setOnClickListener(v -> viewPager.setCurrentItem(position + 1));
                }

                if (btnNo != null) {
                    btnNo.setOnClickListener(v -> {
                        Toast.makeText(OnboardingActivity.this, "You must be 18+ to use this app.", Toast.LENGTH_LONG).show();
                        finish();
                    });
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            return layouts[position];
        }

        @Override
        public int getItemCount() {
            return layouts.length;
        }

        class OnboardingViewHolder extends RecyclerView.ViewHolder {
            OnboardingViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}