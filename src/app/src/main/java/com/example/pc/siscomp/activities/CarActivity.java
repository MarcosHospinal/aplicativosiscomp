package com.example.pc.siscomp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.siscomp.R;
import com.example.pc.siscomp.adapters.CarItemAdapter;
import com.example.pc.siscomp.models.CarItem;
import com.example.pc.siscomp.models.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CarActivity extends AppCompatActivity {
    ListView listViewCarItems;
    CarItemAdapter itemsAdapter;
    TextView txtTotal;
    ArrayList<CarItem> items;
    ImageButton btnCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        listViewCarItems = (ListView) findViewById(R.id.listViewCarItems);

        items = CarItem.get();

        itemsAdapter =
                new CarItemAdapter(this, items);

        listViewCarItems.setAdapter(itemsAdapter);

        listViewCarItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                Product selItem = (Product) adapter.getItemAtPosition(position);
                if ( selItem != null ) {
//                    Intent o = new Intent(CarActivity.this, ProductActivity.class);
//                    o.putExtra("productId", selItem.getId());
//
//                    startActivity(o);
//                    Log.d(Settings.DEBUG, "La aplicacion dijo: " + selItem.getName());
                }
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        txtTotal = (TextView)findViewById(R.id.txtTotal);
        this.refreshTotals();
        btnCheckout = (ImageButton)findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(CarActivity.this, LoginActivity.class);
                startActivity(o);
            }
        });
    }
    public void refreshTotals() {
        double o = 0;
        for (CarItem t :items) {
            o = o + (double) t.getQuantity();
        }

        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");

        txtTotal.setText(formatter.format(o));
    }
    public void updateCartItem(int position, String qty) {
        CarItem o = items.get(position);
        try {
            o.setQuantity(Integer.parseInt(qty));
        } catch (Exception e) {

        }
        this.refreshTotals();

    }
}
