package com.poly.g5_coffee.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.poly.g5_coffee.FragmentAdmin.HomeAdminFragment;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    HomeAdminFragment fragment;
    private ArrayList<Product> list;
    TextView tvMaSP, tvTenSP, tvGia, tvMota;
    ImageView imgDel;

    public ProductAdapter(@NonNull Context context, HomeAdminFragment fragment, ArrayList<Product> list) {
        this.context = context;
        this.fragment = fragment;
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.product_item,null);
        }
        final Product item = list.get(position);
        if(item != null){
            tvTenSP = v.findViewById(R.id.tvTenSp);
            tvTenSP.setText("Tên Sản phẩm: "+item.nameSp);
            tvGia = v.findViewById(R.id.tvGia);
            tvGia.setText("Giá : "+item.price);
            tvMota = v.findViewById(R.id.tvMota);
            tvMota.setText("Mô Tả" + item.message);
            imgDel = v.findViewById(R.id.imgDeleteS);
        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.xoa(String.valueOf(item.id));
            }
        });
        return v;
    }



}
