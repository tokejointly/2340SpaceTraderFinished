package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;

class Item implements Serializable {

    private final GoodType type;
    private final String name;
    private int quantity;
    private final int price;

    public Item(GoodType type, String name, int quantity, int price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public GoodType getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {this.quantity = newQuantity;}

    public int getPrice(){
        return price;
    }



    public void sellQuantity(int sold) {
        quantity -= sold;
    }

}
