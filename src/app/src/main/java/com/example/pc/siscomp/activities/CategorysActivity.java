package com.example.pc.siscomp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pc.siscomp.R;
import com.example.pc.siscomp.adapters.CategoryItemAdapter;
import com.example.pc.siscomp.models.Category;

import java.util.ArrayList;

public class CategorysActivity extends AppCompatActivity {
    CategoryItemAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorys);
        ListView lista = (ListView)findViewById(R.id.milista);
        ArrayList<Category> Categorys = Category.getList();
        adaptador = new CategoryItemAdapter(this, Categorys);
        lista.setAdapter(adaptador);
    }
}
