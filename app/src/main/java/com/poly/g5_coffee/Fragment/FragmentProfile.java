package com.poly.g5_coffee.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


import com.poly.g5_coffee.Activity.ChangePasswordActivity;
import com.poly.g5_coffee.Activity.EditProfileUserActivity;
import com.poly.g5_coffee.Model.Product;
import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.MyDialogFragment;
import com.poly.g5_coffee.R;
import com.poly.g5_coffee.adapter.ProductAdapter;
import com.poly.g5_coffee.adapter.UserAdapter;
import com.poly.g5_coffee.dao.UserDao;

import java.util.ArrayList;

public class FragmentProfile extends Fragment {
    Button btn_edit_profile, btn_changePassword, btn_logOut;
    TextView tvname,tvSdt,tvdiachi;
    User user;
    UserDao dao;
    UserAdapter adapter;
    ArrayList<User> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container,false);

        btn_edit_profile = (Button) view.findViewById(R.id.btn_edit_profile_user);
        btn_changePassword = (Button) view.findViewById(R.id.btn_resets_pass_user);
        tvname = (TextView) view.findViewById(R.id.tv_name_user);
        tvSdt = (TextView) view.findViewById(R.id.tv_sdt_user);
        tvdiachi = (TextView) view.findViewById(R.id.tv_Address_user);
        btn_logOut = (Button) view.findViewById(R.id.btn_logout_user);
//        dao = new UserDao(getActivity());
//
//        list = (ArrayList<User>) dao.getAll();
//        adapter = new UserAdapter(getActivity(), this, list);

        //tvname.setText("" + user.name);



        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfileUserActivity.class);
                startActivity(intent);
            }
        });

        btn_changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });


        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(getFragmentManager(), "Dialog");
            }
        });





        return view;
    }



}
