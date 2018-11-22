package com.example.pc.siscomp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.pc.siscomp.R;
import com.example.pc.siscomp.models.Product;


public class ProductListActivity extends AppCompatActivity {
    ListView listViewProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);

        ArrayList<String> items = Product.getProductsAsString();

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        listViewProducts.setAdapter(itemsAdapter);

    }
}
