package com.poly.g5_coffee.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.dao.UserDao;

import java.util.ArrayList;

public class ChangePasswordActivity extends AppCompatActivity {
    Button btn_rspass;
    EditText edt_pass,edt_rspass;
    UserDao dao;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        edt_pass = findViewById(R.id.edt_pass);
        edt_rspass = findViewById(R.id.edt_rs_pass);
        btn_rspass = findViewById(R.id.btn_rsPass);
        user = new User();
        dao = new UserDao(ChangePasswordActivity.this);

        btn_rspass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    user.password = edt_pass.getText().toString();
                    if( validate()>0){
                    if(dao.update(user)>0){
                        Toast.makeText(ChangePasswordActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                        edt_pass.setText("");
                        edt_rspass.setText("");
                    }else {
                        Toast.makeText(ChangePasswordActivity.this, "Sửa Thất Bại", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public int validate(){
        int check = 1;
        if(edt_pass.getText().length()==0 || edt_rspass.getText().length()==0){
            Toast.makeText(ChangePasswordActivity.this, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }else {
            String Pass = edt_pass.getText().toString();
            String rePass = edt_rspass.getText().toString();
            if(!Pass.equals(rePass)){
                Toast.makeText(ChangePasswordActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}