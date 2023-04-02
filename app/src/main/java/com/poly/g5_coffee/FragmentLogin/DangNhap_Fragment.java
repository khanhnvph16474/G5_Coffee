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

import com.poly.g5_coffee.Activity.ActivityAdmin;
import com.poly.g5_coffee.CustomToast;
import com.poly.g5_coffee.DBhelper;
import com.poly.g5_coffee.MainActivity;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.dao.UserDao;


public class DangNhap_Fragment extends Fragment {
    Button btnlogin;
    EditText edtname, edtpass;
    DBhelper databaseHelper;
    CustomToast customToast;
    UserDao dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dangnhap_fragment, container, false);


        edtname = view.findViewById(R.id.et_lusername);
        edtpass = view.findViewById(R.id.et_lpassword);
        btnlogin = view.findViewById(R.id.btn_llogin);
        dao = new UserDao(getActivity());
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtname.getText().toString();
                String pass = edtpass.getText().toString();

                if(username.isEmpty()||pass.isEmpty()){
                    Toast.makeText(getActivity(),"Tên đăng nhập và mật khẩu không được bỏ trống",
                            Toast.LENGTH_SHORT).show();
                }
                if(dao.checkLogin(username, pass)>0 || (username.equals("admin") && (pass.equals("admin")))){
                    Toast.makeText(getActivity(),"Login thành công", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getActivity(),ActivityAdmin.class);
                    intent.putExtra("user", username);
                    startActivity(intent);
                    getActivity().finish();
                }else {
                    Toast.makeText(getActivity(),"Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
}
