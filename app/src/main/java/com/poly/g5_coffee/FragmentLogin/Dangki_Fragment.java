package com.poly.g5_coffee.FragmentLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.g5_coffee.DBhelper;
import com.poly.g5_coffee.MainActivity;
import com.poly.g5_coffee.R;


public class Dangki_Fragment extends Fragment {

    DBhelper databaseHelper;
    EditText txtName , txtPass, txtRsPass;
    Button btbDangky, btnDangnhap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dangky_fragment, container, false);

        databaseHelper = new DBhelper(getActivity());
        txtName = view.findViewById(R.id.et_lusername);
        txtPass = view.findViewById(R.id.et_lpassword);
        txtRsPass = view.findViewById(R.id.et_lnhaplaipass);
        btbDangky = view.findViewById(R.id.btn_lregister);
        btnDangnhap = view.findViewById(R.id.btn_llogin);

        btbDangky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = txtName.getText().toString();
                String password = txtPass.getText().toString();
                String confirm_password = txtRsPass.getText().toString();
                if(username.equals("") || password.equals("") || confirm_password.equals("")){
                    Toast.makeText(getContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirm_password)){
                        Boolean checkusername = databaseHelper.CheckUsername(username);
                        if(checkusername == true){
                            Boolean insert = databaseHelper.Insert(username, password);
                            if(insert == true){
                                Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtName.getText().toString();
                String pass = txtPass.getText().toString();

                Boolean cheklogin = databaseHelper.CheckLogin(username, pass);
                if(cheklogin == true){
                    Toast.makeText(getContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(), "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
