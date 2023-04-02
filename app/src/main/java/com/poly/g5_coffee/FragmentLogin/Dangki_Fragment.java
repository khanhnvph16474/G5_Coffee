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

import com.poly.g5_coffee.CustomToast;
import com.poly.g5_coffee.DBhelper;
import com.poly.g5_coffee.MainActivity;
import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.dao.UserDao;


public class Dangki_Fragment extends Fragment {

    EditText edtName,edtUsername , edtPass, edtSDT, edtDiachi;
    Button btbDangky, btnDangnhap;
    UserDao dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dangky_fragment, container, false);


        edtUsername = view.findViewById(R.id.edt_username);
        edtPass = view.findViewById(R.id.edt_password);

        edtName = view.findViewById(R.id.edt_name);
        edtSDT = view.findViewById(R.id.edt_sdt);
        edtDiachi = view.findViewById(R.id.edt_diachi);
        btbDangky = view.findViewById(R.id.btn_lregister);
        btnDangnhap = view.findViewById(R.id.btn_llogin);
        dao = new UserDao(getActivity());
        btbDangky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                User user = new User();
                user.userName = edtUsername.getText().toString();
                user.password = edtPass.getText().toString();
                user.name = edtName.getText().toString();
                user.phoneNumber = edtSDT.getText().toString();
                user.diaChi =edtDiachi.getText().toString();

                String username = edtUsername.getText().toString();
                String pass = edtPass.getText().toString();
                String name = edtName.getText().toString();
                String phone = edtSDT.getText().toString();
                String diachi = edtDiachi.getText().toString();
                if (username.equals("") || pass.equals("") ||name.equals("")|| phone.equals("") |diachi.equals("")){
                    Toast.makeText(getActivity(),"Không được bỏ trống",
                            Toast.LENGTH_SHORT).show();
                }else {
                    if (dao.insert(user) > 0) {
                        Toast.makeText(getActivity(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                    edtName.setText("");
//                    edtSDT.setText("");
//                    edtDiachi.setText("");
//                    edtUsername.setText("");
//                    edtPass.setText("");
                    } else {
                        Toast.makeText(getActivity(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPass.getText().toString();

                String name = edtName.getText().toString();
                String phone = edtSDT.getText().toString();
                String diachi = edtDiachi.getText().toString();

                Boolean cheklogin = dao.checkLogin(username, password);
                if(cheklogin == true){
                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(), "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;


    }
}
