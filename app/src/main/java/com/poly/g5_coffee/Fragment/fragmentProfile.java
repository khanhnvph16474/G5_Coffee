package com.poly.g5_coffee.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.g5_coffee.Activity.ChangePasswordActivity;
import com.poly.g5_coffee.Activity.EditProfileUserActivity;
import com.poly.g5_coffee.FragmentLogin.DangNhap_Fragment;
import com.poly.g5_coffee.R;

public class fragmentProfile extends Fragment {
    Button btn_edit_profile, btn_changePassword, btn_logOut;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container,false);

        btn_edit_profile = (Button) view.findViewById(R.id.btn_edit_profile_user);
        btn_changePassword = (Button) view.findViewById(R.id.btn_resets_pass_user);
        btn_logOut = (Button) view.findViewById(R.id.btn_logout_user);
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
                
            }
        });





        return view;
    }



}
