package com.example.shopbanhang.cart;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopbanhang.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class ProductCartAdapter extends RecyclerView.Adapter<ProductCartAdapter.ViewHolder> {
    private CartActivity context;
    private ArrayList<Product_Cart> productCartArrayList;
    private int quantilyAdd;

    public ProductCartAdapter(ArrayList<Product_Cart> products, CartActivity context) {
        this.productCartArrayList = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.dong_produc, parent, false );
        ProductCartAdapter.ViewHolder viewHolder = new ProductCartAdapter.ViewHolder( itemView );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product_Cart productCart = productCartArrayList.get( position );
        holder.edtQuantily.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(Integer.valueOf(holder.edtQuantily.getText().toString())<=1){
                    holder.btnMinus_Cart.setEnabled( false );
                }
                if(Integer.valueOf(holder.edtQuantily.getText().toString())>=30){
                    holder.btnAdd_Cart.setEnabled( false );
                }
            }
        } );
        holder.btnMinus_Cart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.valueOf( holder.edtQuantily.getText().toString() ) <= 1) {
                    holder.edtQuantily.setText( "1" );
                } else {
                    holder.edtQuantily.setText( String.valueOf( Integer.valueOf( holder.edtQuantily.getText().toString() ) - 1 ) );
                    holder.btnAdd_Cart.setEnabled( true );
                    productCart.setQuantily( productCart.getQuantily() );

                }
                context.minusQuantily( productCart.getId() );
            }
        } );
        holder.btnAdd_Cart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.valueOf( holder.edtQuantily.getText().toString() ) >= 30) {
                    holder.edtQuantily.setText( "30" );
                } else {
                    holder.edtQuantily.setText( String.valueOf( Integer.valueOf( holder.edtQuantily.getText().toString() ) + 1 ) );
                    holder.btnMinus_Cart.setEnabled( true );
                    productCart.setQuantily( productCart.getQuantily() );
                }
                context.addQuantily( productCart.getId() );
            }
        } );
        Glide.with( context )
                .load( productCart.getAvt() )
                .into( holder.ImgProduct );
        holder.txtName.setText( productCart.getName() );
        holder.txtPrice.setText( formatVnCurrence( context, String.valueOf( productCart.getPrice() ) ) );
        holder.edtQuantily.setText( String.valueOf( productCart.getQuantily() ) );
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

    @Override
    public int getItemCount() {
        return productCartArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ImgProduct;
        public TextView txtName, txtPrice;
        public EditText edtQuantily;
        public ImageButton btnMinus_Cart, btnAdd_Cart;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            ImgProduct = itemView.findViewById( R.id.imgPhoto_Cart );
            txtName = itemView.findViewById( R.id.txtNameProdCart );
            txtPrice = itemView.findViewById( R.id.txtProdPriceCart );
            edtQuantily = itemView.findViewById( R.id.edtQuantily_Cart );
            btnMinus_Cart = itemView.findViewById( R.id.btnMinus_Cart );
            btnAdd_Cart = itemView.findViewById( R.id.btnAdd_Cart );
        }
    }
}
