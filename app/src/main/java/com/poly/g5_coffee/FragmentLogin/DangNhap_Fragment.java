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


public class DangNhap_Fragment extends Fragment {
    Button btnlogin;
    EditText txtname, txtpass;
    DBhelper databaseHelper;
    CustomToast customToast;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dangnhap_fragment, container, false);

        databaseHelper = new DBhelper(getActivity());
        txtname = view.findViewById(R.id.et_lusername);
        txtpass = view.findViewById(R.id.et_lpassword);
        btnlogin = view.findViewById(R.id.btn_llogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtname.getText().toString();
                String pass = txtpass.getText().toString();

                Boolean cheklogin = databaseHelper.CheckLogin(username, pass);
                if (username.equalsIgnoreCase("admin")&&pass.equalsIgnoreCase("admin")){
                    customToast.makeText(getContext(), "Đăng nhập thành công Admin Account", CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
                    Intent intentAdmin = new Intent(getActivity(), ActivityAdmin.class);
                    startActivity(intentAdmin);
                }
                else if(cheklogin == true){
                    customToast.makeText(getContext(), "Đăng nhập thành công", CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }else {
                    customToast.makeText(getContext(), "Tài khoản hoặc mật khẩu không chính xác", CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();
                    txtpass.setText("");
                }
            }
        });
        return view;
    }
}
