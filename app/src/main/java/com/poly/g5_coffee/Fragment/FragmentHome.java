package com.poly.g5_coffee.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.poly.g5_coffee.CustomToast;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.adapter.ProductAdapterHomeUser;
import com.poly.g5_coffee.dao.ProductDao;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    GridView gridViewCF;
    ArrayList<Product> list;
    ProductDao dao;
    ProductAdapterHomeUser adapter;
    Product item;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gridViewCF = view.findViewById(R.id.id_gridview_Home);
        dao = new ProductDao(getActivity());
        capNhatLv();

//        gridViewCF.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
//                item = list.get(i);
//                CustomToast.makeText(getContext(),"Đặt hàng thành công",CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
//
//                return false;
//            }
//        });
        gridViewCF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog();
            }
        });
        return view;
    }



    void capNhatLv(){
        list = (ArrayList<Product>) dao.getAll();
        adapter = new ProductAdapterHomeUser(getActivity(), this, list);
        gridViewCF.setAdapter(adapter);
    }
    public  void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn muốn thêm sản phẩm vào giỏ hàng ?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CustomToast.makeText(getContext(),"Thêm thành công", CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
            
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CustomToast.makeText(getContext(),"Hủy",CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
