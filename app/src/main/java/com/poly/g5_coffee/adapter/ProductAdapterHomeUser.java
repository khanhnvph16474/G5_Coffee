package com.poly.g5_coffee.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.poly.g5_coffee.Chitietsanpham;
import com.poly.g5_coffee.Fragment.FragmentHome;
import com.poly.g5_coffee.Fragment.FragmentProfile;
import com.poly.g5_coffee.FragmentAdmin.HomeAdminFragment;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.R;

import java.util.ArrayList;

public class ProductAdapterHomeUser extends BaseAdapter {
    private ArrayList<Product> list;
    private Context context;
    private LinearLayout item_user;
    FragmentHome fragmentHome;
    TextView  tvTenSP, tvGia;
    Product product;
    public ProductAdapterHomeUser(@NonNull Context context, FragmentHome fragment, ArrayList<Product> list) {
        this.context = context;
        this.fragmentHome = fragment;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.layout_item_product_home, null);
        }
        final Product item = list.get(position);
        if (item != null) {
            tvTenSP = v.findViewById(R.id.tv_name_item_home_user);
            tvTenSP.setText(item.nameSp);
            tvGia = v.findViewById(R.id.tv_price_item_home_user);
            tvGia.setText(item.price + " VND");
            item_user = v.findViewById(R.id.item_home_user);
        }
        item_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitietsanpham.class);
                Bundle bundle = new Bundle();
                product = new Product();
                bundle.putSerializable("item_product", product);
                intent.putExtras(bundle);
                context.startActivity(intent);
         }
        });
        return v;
    }
}


