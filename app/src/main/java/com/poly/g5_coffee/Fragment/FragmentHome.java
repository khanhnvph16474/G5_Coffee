package com.poly.g5_coffee.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
        return view;
    }



    void capNhatLv(){
        list = (ArrayList<Product>) dao.getAll();
        adapter = new ProductAdapterHomeUser(getActivity(), this, list);
        gridViewCF.setAdapter(adapter);
    }

}
