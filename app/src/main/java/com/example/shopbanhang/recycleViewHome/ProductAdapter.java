package com.example.shopbanhang.recycleViewHome;

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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> productArrayList;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.productArrayList = products;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate( R.layout.dong_recycleview_product,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        Glide.with(context)
                .load(product.getAvt())
                .into(holder.ImgProduct);
        holder.txtName.setText(product.getName());
//        NumberFormat formatter = new DecimalFormat("#.###");
//        int myNumber = product.getPrice();
//        String formattedNumber = formatter.format(myNumber);

        holder.txtPrice.setText(formatVnCurrence( context,String.valueOf( product.getPrice() ) ));
    }
    public static String formatVnCurrence(Context context, String price) {

        NumberFormat format =
                new DecimalFormat("#,##0.00");// #,##0.00 ¤ (¤:// Currency symbol)
        format.setCurrency( Currency.getInstance(Locale.US));//Or default locale

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

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ImgProduct;
        public TextView txtName,txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgProduct = itemView.findViewById(R.id.imgPhotoProductLine);
            txtName = itemView.findViewById(R.id.txtProductNameLine);
            txtPrice = itemView.findViewById(R.id.txtProductPriceLine);
        }
    }
}
