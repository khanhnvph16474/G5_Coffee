package com.poly.g5_coffee.FragmentAdmin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.adapter.ProductAdapter;
import com.poly.g5_coffee.dao.ProductDao;

import java.util.ArrayList;


public class HomeAdminFragment extends Fragment {
    ListView lv;
    ArrayList<Product> list;
    FloatingActionButton btn_add;
    Dialog dialog;
    EditText edMaSp, edTenSp, edGia, edMoTa;
    Button btnSave, btnCancel;
    static ProductDao dao;
    ProductAdapter adapter;
    Product item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_admin, container, false);
        lv = v.findViewById(R.id.lvSp);
        btn_add = v.findViewById(R.id.btn_add_product_admin);
        dao = new ProductDao(getActivity());
        capNhatLv();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity(), 0);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = list.get(i);
                openDialog(getActivity(), 1);
                return false;
            }
        });
        return v;
    }

    protected void openDialog(final Context context, final int type){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.sanpham_dialog);
        edTenSp = dialog.findViewById(R.id.edTenSanPham);
        edGia = dialog.findViewById(R.id.edGiaSanPham);
       edMoTa = dialog.findViewById(R.id.edMoTa);
        btnSave = dialog.findViewById(R.id.btnSaveSach);
        btnCancel = dialog.findViewById(R.id.btnCancelSach);


        edMaSp.setEnabled(false);
        if(type != 0){
            edMaSp.setText(String.valueOf(item.id));
            edTenSp.setText(item.nameSp);
            edGia.setText(String.valueOf(item.price));
            edMoTa.setText(item.message);
        }
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = new Product();
                item.nameSp = edTenSp.getText().toString();
                item.price = Integer.parseInt(edGia.getText().toString());
                item.message = edMoTa.getText().toString();
                if(validate()>0){
                    if(type == 0){
                        if(dao.insert(item)>0){
                            Toast.makeText(context, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        item.id = Integer.parseInt(edMaSp.getText().toString());
                        if(dao.update(item)>0){
                            Toast.makeText(context, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, "Sửa Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    capNhatLv();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }
    public void xoa(final String Id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dao.delete(Id);
                capNhatLv();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    void capNhatLv(){
        list = (ArrayList<Product>) dao.getAll();
        adapter = new ProductAdapter(getActivity(), this, list);
        lv.setAdapter(adapter);
    }

    public int validate(){
        int check = 1;
        if(edTenSp.getText().length()==0 || edGia.getText().length()==0 || edMoTa.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

}