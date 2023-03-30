package com.poly.g5_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.poly.g5_coffee.Activity.ActivityAdmin;

public class themsanpham_Admin extends AppCompatActivity {
    ImageView back,anh, addanh;
    TextView ten, noidung, gia;
    Button addsanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themsanpham_admin);
        back = findViewById(R.id.back);
        anh =  findViewById(R.id.anh);
        addanh = findViewById(R.id.addanh);
        ten = findViewById(R.id.ten);
        noidung = findViewById(R.id.noidung);
        gia = findViewById(R.id.gia);
        addsanpham = findViewById(R.id.addsanpham);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(themsanpham_Admin.this, ActivityAdmin.class);
                startActivity(intent);
            }
        });
        addanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        addsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
