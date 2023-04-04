package com.poly.g5_coffee.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.poly.g5_coffee.R;

public class FragmentHistory extends Fragment {
    ImageView anh;
    TextView ten , soluong , gia ;
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
//        anh = view.findViewById(R.id.anh);
//        ten = view.findViewById(R.id.ten);
//        soluong = view.findViewById(R.id.soluong);
//        gia = view.findViewById(R.id.gia);
//        button = view.findViewById(R.id.btn_danhanhang);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Đã nhận được hàng", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
