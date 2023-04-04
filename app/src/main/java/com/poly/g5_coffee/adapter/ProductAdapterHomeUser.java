package com.poly.g5_coffee.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poly.g5_coffee.Fragment.FragmentHome;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;

import java.util.ArrayList;

public class ProductAdapterHomeUser extends BaseAdapter {
    private ArrayList<Product> list;
    private Context context;
    FragmentHome fragmentHome;
    TextView tvMaSP, tvTenSP, tvGia, tvMota;


    public ProductAdapterHomeUser(ArrayList<Product> list, Context context, FragmentHome fragmentHome) {
        this.list = list;
        this.context = context;
        this.fragmentHome = fragmentHome;
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
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.product_item,null);
        }
        final Product item = list.get(position);
        if(item != null) {
            tvTenSP = convertView.findViewById(R.id.tv_name_item_home_user);
            tvTenSP.setText("Tên Sản phẩm:  " + item.nameSp);
            tvGia = convertView.findViewById(R.id.tv_price_item_home_user);
            tvGia.setText("Giá : " + item.price);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

}
