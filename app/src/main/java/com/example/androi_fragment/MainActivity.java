package com.example.androi_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> arrProduct;
    AdapterProduct adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.LayoutMain) != null) {
            loadDefaultLayout();
        }

        if(findViewById(R.id.LayoutLand) != null) {
            loadLandLayout();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            loadLandLayout();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            loadDefaultLayout();
        }
    }

    private void loadDefaultLayout() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment_details fragment_details1 = new fragment_details();
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.listFragment))
                .hide(fragmentManager.findFragmentById(R.id.FragmentDetails))
                .commit();

        lvProduct = findViewById(R.id.lv_product);
        mapping();
        adapter = new AdapterProduct(this, R.layout.row_items, arrProduct);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                TextView txtName = findViewById(R.id.txtDetails);
                ImageView img = findViewById(R.id.imgDetails);

                txtName.setText(arrProduct.get(i).getNamePro());
                img.setImageResource(arrProduct.get(i).getImgPro());

                fragmentManager.beginTransaction()
                        .show(fragmentManager.findFragmentById(R.id.FragmentDetails))
                        .hide(fragmentManager.findFragmentById(R.id.listFragment))
                        .commit();
            }
        });
    }



    private void loadLandLayout() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment_details fragment_details1 = new fragment_details();
        fragmentManager.beginTransaction()
                .show(fragmentManager.findFragmentById(R.id.listFragment))
                .show(fragmentManager.findFragmentById(R.id.FragmentDetails))
                .commit();

        lvProduct = findViewById(R.id.lv_product);
        mapping();
        adapter = new AdapterProduct(this, R.layout.row_items, arrProduct);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                TextView txtName = findViewById(R.id.txtDetails);
                ImageView img = findViewById(R.id.imgDetails);

                txtName.setText(arrProduct.get(i).getNamePro());
                img.setImageResource(arrProduct.get(i).getImgPro());
            }
        });
    }

    private void mapping() {
        arrProduct = new ArrayList<>();

        arrProduct.add(new Product(R.drawable.shoes_rm_preview, "1"));
        arrProduct.add(new Product(R.drawable.shoes_rm_preview_a, "2"));
        arrProduct.add(new Product(R.drawable.shoes_rm_yellow, "3"));
        arrProduct.add(new Product(R.drawable.shoes_rm_preview_b, "4"));
        arrProduct.add(new Product(R.drawable.shoes_white_removebg_preview, "5"));
        arrProduct.add(new Product(R.drawable.shoes_rm_preview_a, "6"));
        arrProduct.add(new Product(R.drawable.shoes_rm_preview, "7"));
        arrProduct.add(new Product(R.drawable.shoes_rm_purple, "8"));
    }

}