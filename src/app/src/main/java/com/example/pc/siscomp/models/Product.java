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

    public  static ArrayList<String> getProductsAsString{
        ArrayList<String>  p = new ArrayList<>();

        p.add("Teclados");
        p.add("Mause");
        p.add("Mainboars");
        p.add("Impresoras");
        p.add("Monitores");
        p.add("Laptops");
        p.add("Cases");
        return  p;
    }
}
