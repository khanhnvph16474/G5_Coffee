package com.poly.g5_coffee.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.adapter.ProductAdapter;
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

        gridViewCF.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                item = list.get(i);

                return false;
            }
        });



        return view;
    }



    void capNhatLv(){
        list = (ArrayList<Product>) dao.getAll();
        adapter = new ProductAdapterHomeUser(getActivity(), this, list);
        gridViewCF.setAdapter(adapter);
    }
}
