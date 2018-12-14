package com.example.pc.siscomp.models;

import java.util.ArrayList;

public class Category {
    public String name ;
    public Category(String _name){
        this.name = _name;
    }
    public static ArrayList getList(){
        ArrayList<Category> list = new ArrayList<Category>();
        list.add(new Category("Teclado"));
        list.add(new Category("Mause"));
        list.add(new Category("Mainboard"));
        list.add(new Category("Monitor"));
        list.add(new Category("Laptop"));
        return list;
    }
}
