package com.poly.g5_coffee.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CartUserAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        public TextView tv_name,tv_price,tv_soluong;
        public Button btn_them,btn_bot;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
