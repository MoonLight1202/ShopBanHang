package com.example.shopbanhang.payment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopbanhang.R;
import com.example.shopbanhang.cart.Product_Cart;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product_Cart> productBuyArrayList;

    public PaymentAdapter(ArrayList<Product_Cart> products, Context context) {
        this.productBuyArrayList = products;
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.line_recycleview_payment, parent, false );
        PaymentAdapter.ViewHolder viewHolder = new PaymentAdapter.ViewHolder( itemView );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product_Cart productCart = productBuyArrayList.get( position );

        Glide.with( context )
                .load( productCart.getAvt() )
                .into( holder.ImgProductBuy );
        holder.txtNameBuy.setText( productCart.getName() );
        holder.txtPriceBuy.setText( "Giá:"+formatVnCurrence( context, String.valueOf( productCart.getPrice() )));
        holder.txtQuantilyBuy.setText("Số lượng: "+String.valueOf(productCart.getQuantily()));
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
        return productBuyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ImgProductBuy;
        public TextView txtNameBuy, txtPriceBuy,txtQuantilyBuy;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            ImgProductBuy = itemView.findViewById( R.id.imgPhoto_Payment );
            txtNameBuy = itemView.findViewById( R.id.txtNameRecyclePayment );
            txtPriceBuy = itemView.findViewById( R.id.txtPriceRecyclePayment );
            txtQuantilyBuy = itemView.findViewById( R.id.txtQuantilyRecyclePayment );
        }
    }
}
