package com.poly.g5_coffee.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.poly.g5_coffee.Chitietsanpham;
import com.poly.g5_coffee.Fragment.FragmentHome;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;

import java.util.ArrayList;

public class ChitietSpAdapter extends BaseAdapter {
    private ArrayList<Product> list;
    private Context context;
    private LinearLayout item_user;
    Chitietsanpham chitietsanpham;
    TextView tvTenSP, tvGia,tvMessage;
    Product product;
    public ChitietSpAdapter(@NonNull Context context, Chitietsanpham fragment, ArrayList<Product> list) {
        this.context = context;
        this.chitietsanpham = fragment;
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
        final Product item = list.get(position);
        if (item != null) {
            tvTenSP = v.findViewById(R.id.tv_name_item_home_user);
            tvTenSP.setText(item.nameSp);
            tvGia = v.findViewById(R.id.tv_price_item_home_user);
            tvGia.setText(item.price + " VND");
            tvMessage = v.findViewById(R.id.tvt_message_product);
            tvMessage.setText(item.message);

        }
        return v;
    }
}
