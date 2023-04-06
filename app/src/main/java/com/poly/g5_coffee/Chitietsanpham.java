package com.poly.g5_coffee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.poly.g5_coffee.FragmentAdmin.HomeAdminFragment;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.adapter.ChitietSpAdapter;

import java.text.DecimalFormat;

public class Chitietsanpham extends AppCompatActivity {
    ImageView back, remore, add, anh;
    TextView tensanpham, noidungsanpham, soluong, giatien;
    LinearLayout them;
    ChitietSpAdapter adapter;
    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        AnhXa();
        //Nhận dữ liệu từ HomeFragment
        //Đang lỗi k lấy được data
        product = (Product) getIntent().getSerializableExtra("item_product");
        tensanpham.setText(product.getNameSp());
        //giatien.setText(product.getPrice());
        noidungsanpham.setText(product.getMessage());
        //Sự kiện click
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

    private void AnhXa() {
        back = findViewById(R.id.back);
        remore = findViewById(R.id.remove);
        add = findViewById(R.id.add);
        anh = findViewById(R.id.anh);
        tensanpham = findViewById(R.id.tvt_name_product);
        noidungsanpham = findViewById(R.id.tvt_message_product);
        soluong = findViewById(R.id.soluong);
        giatien = findViewById(R.id.tvt_price_product);
        them = findViewById(R.id.them);
    }


}
