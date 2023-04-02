package com.poly.g5_coffee.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.poly.g5_coffee.Fragment.FragmentProfile;
import com.poly.g5_coffee.Model.User;
import com.poly.g5_coffee.R;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> list;
    TextView tvname,tvsdt,tvdiachi;
    FragmentProfile fragmentProfile;
    public UserAdapter(@NonNull Context context, FragmentProfile fragment, ArrayList<User> list) {
        this.context = context;
        this.fragmentProfile = fragment;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.fragment_profile, null);
        }
        final User item = list.get(position);
        if (item != null) {
            tvname = v.findViewById(R.id.tv_name_user);
            tvname.setText(item.name);
            tvsdt = v.findViewById(R.id.tv_sdt_user);
            tvsdt.setText(item.phoneNumber);
            tvdiachi = v.findViewById(R.id.tv_Address_user);
            tvdiachi.setText(item.diaChi);
        }


        return v;
    }
}
