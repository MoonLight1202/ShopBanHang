package com.example.shopbanhang.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopbanhang.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
    private Toolbar toolbarCart;
    private ArrayList<Product_Cart> product_cartList;
    private ProductCartAdapter productCartAdapter;
    private RecyclerView recyclerViewCart;
    private TextView txtAllPrice_Cart;
    private int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );
        recyclerViewCart = findViewById( R.id.recycleView_Cart );

        toolbarCart = findViewById( R.id.toolbarCart );
        toolbarCart.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
        txtAllPrice_Cart = findViewById( R.id.txtAllPrice_Cart );
        product_cartList = new ArrayList<Product_Cart>();
        product_cartList.add( new Product_Cart(13, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1,2 ));
        product_cartList.add( new Product_Cart(4, "Laptop Lenovo Yoga-Duet 7",25900000,
                "https://cdn.tgdd.vn/Products/Images/44/255562/lenovo-yoga-duet-7-13itl6-i5-82ma000pvn-021121-032719-600x600.jpg","Laptop Lenovo",2,1 ));
        product_cartList.add( new Product_Cart(3, "Iphone 11",16990000,
                "https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-do-600x600.jpg","Iphone thế hệ 11",1 ,1 ));

        productCartAdapter = new ProductCartAdapter(product_cartList,CartActivity.this);
        recyclerViewCart.setAdapter(productCartAdapter);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false));
        for (int i = 0; i < product_cartList.size(); i++) {
            value += product_cartList.get( i ).getQuantily() * product_cartList.get( i ).getPrice();
        }
        txtAllPrice_Cart.setText( formatVnCurrence( CartActivity.this,String.valueOf(value) ));
    }

    public void addQuantily(int id){
        for (int i = 0; i < product_cartList.size(); i++) {
            if(product_cartList.get( i ).getId() == id){
                value += product_cartList.get( i ).getPrice();
            }
        }
        txtAllPrice_Cart.setText( formatVnCurrence( CartActivity.this,String.valueOf(value) ));
    }
    public void minusQuantily(int id){
        for (int i = 0; i < product_cartList.size(); i++) {
            if(product_cartList.get( i ).getId() == id){
                value -= product_cartList.get( i ).getPrice();
            }
        }
        txtAllPrice_Cart.setText( formatVnCurrence( CartActivity.this,String.valueOf(value) ));
    }
    public static String formatVnCurrence(Context context, String price) {

        NumberFormat format =
                new DecimalFormat("#,##0.00");// #,##0.00 ¤ (¤:// Currency symbol)
        format.setCurrency( Currency.getInstance( Locale.US));//Or default locale

        price = (!TextUtils.isEmpty(price)) ? price : "0";
        price = price.trim();
        price = format.format(Double.parseDouble(price));
        price = price.replaceAll(",", "\\.");

        if (price.endsWith(".00")) {
            int centsIndex = price.lastIndexOf(".00");
            if (centsIndex != -1) {
                price = price.substring(0, centsIndex);
            }
        }
        price = String.format("%s đ", price);
        return price;
    }
}