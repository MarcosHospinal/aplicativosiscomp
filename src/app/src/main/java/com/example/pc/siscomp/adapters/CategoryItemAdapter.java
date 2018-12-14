package com.example.pc.siscomp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pc.siscomp.R;
import com.example.pc.siscomp.models.Category;

import java.util.ArrayList;

public class CategoryItemAdapter extends ArrayAdapter<Category> {
    private class  ViewHolder{
        private TextView name;
    }
    Context _context;

    public CategoryItemAdapter(Context context, ArrayList<Category> items){
        super(context, 0, items);
    }

    public View getView(final int  position, View convertView, ViewGroup parent){

        CategoryItemAdapter.ViewHolder holder;
        final Category rowItem = (Category) getItem(position);

        LayoutInflater minflater =( LayoutInflater)
                this._context.getSystemService(_context.LAYOUT_INFLATER_SERVICE);

        if (convertView ==null){
            convertView = minflater.inflate(R.layout.adapter_category_item,null);
            holder = new   CategoryItemAdapter.ViewHolder();
            holder.name =(TextView)convertView.findViewById(R.id.namex);
            convertView.setTag(holder);
        }else{
            holder =(CategoryItemAdapter.ViewHolder) convertView.getTag();
        }
        holder.name.setText(rowItem.name);
        return  convertView;
    }
}
