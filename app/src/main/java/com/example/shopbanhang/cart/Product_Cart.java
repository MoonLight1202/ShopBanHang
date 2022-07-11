package com.example.shopbanhang.cart;

import com.example.shopbanhang.recycleViewHome.Product;

public class Product_Cart extends Product{
    private int quantily;

    public Product_Cart(int id, String name, int price, String avt, String des, int catId, int quantily) {
        super( id, name, price, avt, des, catId );
        this.quantily = quantily;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }
}
