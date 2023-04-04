package com.poly.g5_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chitietsanpham extends AppCompatActivity {
    ImageView back, remore, add, anh;
    TextView tensanpham, noidungsanpham, soluong, giatien;
    LinearLayout them;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        back = findViewById(R.id.back);
        remore = findViewById(R.id.remove);
        add = findViewById(R.id.add);
        anh = findViewById(R.id.anh);
        tensanpham = findViewById(R.id.tvt_name_product);
        noidungsanpham = findViewById(R.id.tvt_message_product);
        soluong = findViewById(R.id.soluong);
        giatien = findViewById(R.id.tvt_price_product);
        them = findViewById(R.id.them);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
