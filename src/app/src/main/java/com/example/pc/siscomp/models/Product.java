package com.example.pc.siscomp.models;

import  java.util.ArrayList;

public class Product {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  static ArrayList<String> getProductsAsString() {
        ArrayList<String>  o = new ArrayList<>();

        o.add("Teclados");
        o.add("Mause");
        o.add("Mainboars");
        o.add("Impresoras");
        o.add("Monitores");
        o.add("Laptops");
        o.add("Cases");
        return  o;
    }
}
