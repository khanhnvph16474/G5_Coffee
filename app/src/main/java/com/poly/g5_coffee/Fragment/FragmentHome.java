package com.poly.g5_coffee.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.adapter.ProductAdapter;
import com.poly.g5_coffee.dao.ProductDao;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    private GridView gridViewCF;
    ArrayList<Product> list;
    Context context;
    ArrayAdapter arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gridViewCF = view.findViewById(R.id.id_gridview_Home);
        list = new ArrayList<Product>();
        ProductDao productDao = new ProductDao(getContext());
        return view;
    }
}
