package com.poly.g5_coffee;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

    public class splash extends AppCompatActivity {
        Button button;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);

            button = findViewById(R.id.btntieptuc);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(splash.this,login.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

