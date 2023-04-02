package com.poly.g5_coffee.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.dao.UserDao;

public class EditProfileUserActivity extends AppCompatActivity {
    Button btn_save;
    EditText edt_name,edt_sdt,edt_diachi;
    UserDao dao;
    User user;
    Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_user);
        context = this;
        edt_name = findViewById(R.id.edt_edit_name);
        edt_sdt = findViewById(R.id.edt_edit_phone);
        edt_diachi = findViewById(R.id.edt_edit_diachi);
        dao = new UserDao(context);
        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.name = edt_name.getText().toString();
                user.phoneNumber = edt_sdt.getText().toString();
                user.diaChi = edt_diachi.getText().toString();


                if(validate()>0){
                    if(dao.update(user)>0){
                        Toast.makeText(EditProfileUserActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(EditProfileUserActivity.this,  "Sửa Thất Bại", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
    public int validate(){
        String name = edt_name.getText().toString();
        String phone = edt_sdt.getText().toString();
        String diaChi = edt_diachi.getText().toString();
        int check = 1;
        if(name.equals("") || phone.equals("")|| diaChi.equals("")){
            Toast.makeText(EditProfileUserActivity.this, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }

        return check;
    }

}
