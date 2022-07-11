package com.example.shopbanhang.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.shopbanhang.R;
import com.example.shopbanhang.cart.Product_Cart;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {
    private ArrayList<Product_Cart> list;
    private PaymentAdapter adapter;
    private RecyclerView recyclerViewBuy;
    private Product_Cart product_cart;
    private TextView txtAllPriceProduct, txtAllMoney,txtAllMoneyOrder;
    private Button btnOrder;
    private Toolbar toolbarPayment;
    private LinearLayout layoutAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_payment );
        recyclerViewBuy = findViewById( R.id.recycleView_payment );
        toolbarPayment = findViewById( R.id.toolbarPayment );
        layoutAddress = findViewById( R.id.layoutAddress );
        layoutAddress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(PaymentActivity.this, Info_Payment.class ) );
            }
        } );
        toolbarPayment.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );
        Intent intent = getIntent();
        product_cart = (Product_Cart) intent.getSerializableExtra( "productBuy" );

        list = new ArrayList<Product_Cart>();
        list.add( product_cart );

        adapter = new PaymentAdapter(list, PaymentActivity.this);
        recyclerViewBuy.setAdapter(adapter);
        recyclerViewBuy.setLayoutManager(new LinearLayoutManager(PaymentActivity.this, LinearLayoutManager.VERTICAL, false));

        btnOrder = findViewById( R.id.btn_order );
        txtAllMoneyOrder = findViewById( R.id.txtAllPrice_Buy );
        txtAllPriceProduct = findViewById( R.id.txtAllProdPricePayment );
        txtAllMoney = findViewById( R.id.txtAllMoney );
        txtAllPriceProduct.setText( "Tổng tiền hàng: "+ formatVnCurrence( this,String.valueOf( product_cart.getPrice() * product_cart.getQuantily() ) )  );
        txtAllMoney.setText( "Tổng thanh toán: "+ formatVnCurrence( this, String.valueOf( product_cart.getPrice() * product_cart.getQuantily() + 30000 ) ) );
        txtAllMoneyOrder.setText(  formatVnCurrence( this, String.valueOf( product_cart.getPrice() * product_cart.getQuantily() + 30000 ) ) );
        btnOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( PaymentActivity.this, "Đặt hàng",Toast.LENGTH_SHORT ).show();
            }
        } );
    }
    public static String formatVnCurrence(Context context, String price) {

        NumberFormat format =
                new DecimalFormat( "#,##0.00" );// #,##0.00 ¤ (¤:// Currency symbol)
        format.setCurrency( Currency.getInstance( Locale.US ) );//Or default locale

        price = (!TextUtils.isEmpty( price )) ? price : "0";
        price = price.trim();
        price = format.format( Double.parseDouble( price ) );
        price = price.replaceAll( ",", "\\." );

        if (price.endsWith( ".00" )) {
            int centsIndex = price.lastIndexOf( ".00" );
            if (centsIndex != -1) {
                price = price.substring( 0, centsIndex );
            }
        }
        price = String.format( "%s đ", price );
        return price;
    }

}