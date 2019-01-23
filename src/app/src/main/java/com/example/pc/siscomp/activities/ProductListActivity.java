package com.example.pc.siscomp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.example.pc.siscomp.R;
import com.example.pc.siscomp.adapters.ProductAdapter;
import com.example.pc.siscomp.generals.Settings;
import com.example.pc.siscomp.helpers.QueueUtils;
import com.example.pc.siscomp.helpers.QueueUtils.QueueObject;
import com.example.pc.siscomp.models.Product;


public class ProductListActivity extends AppCompatActivity {
    ListView listViewProducts;
    QueueObject queue = null;
    ProductAdapter itemsAdapter;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    ArrayList<Product> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        queue = QueueUtils.getInstance(this.getApplicationContext());

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);

        items = new ArrayList<>();

        Product.injectProductsFromCloud(queue, items, this);

        itemsAdapter =
                new ProductAdapter(this, items, queue.getImageLoader());

        listViewProducts.setAdapter(itemsAdapter);

        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent myIntent = getIntent();
        String statusRequest = myIntent.getStringExtra("status");
        if (statusRequest != null && !statusRequest.isEmpty()) {
            Toast.makeText(this, "Oops", Toast.LENGTH_SHORT).show();
        }
        // put your code here...

    }

    public void refreshList() {
        if (itemsAdapter != null) {
            itemsAdapter.notifyDataSetChanged();
        }
    }
    public void selectProduct(int position) {
        Product selItem = items.get(position);

        if ( selItem != null ) {
            Intent o = new Intent(ProductListActivity.this, ProductActivity.class);
            o.putExtra("productId", selItem.getId());

            startActivity(o);
            Log.d(Settings.DEBUG, "La aplicacion dijo: " + selItem.getName());
        }
    }
}

