package com.example.androi_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> listProduct;

    public AdapterProduct(Context context, int layout, List<Product> listProduct) {
        this.context = context;
        this.layout = layout;
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        TextView txtName = view.findViewById(R.id.txt_namePro);
        ImageView imgPro = view.findViewById(R.id.imgPro);

        Product productItem = listProduct.get(i);
        txtName.setText(productItem.getNamePro());
        imgPro.setImageResource(productItem.getImgPro());

        return view;
    }
}
