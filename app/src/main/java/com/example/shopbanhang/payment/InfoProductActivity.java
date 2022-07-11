package com.example.shopbanhang.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shopbanhang.R;
import com.example.shopbanhang.cart.CartActivity;
import com.example.shopbanhang.cart.Product_Cart;
import com.example.shopbanhang.recycleViewHome.Product;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class InfoProductActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageButton imgButtonCart,imgButtonMinus,imgButtonAdd,btnCloseBottomSheetDialog,btnCloseBottomSheetDialogBuy,imgButtonMinusBuy,imgButtonAddBuy;
    private EditText edtQuantilyCart,edtQuantilyBuy;
    private ImageView imgProduct,imgProdCart,imgProdBuy;
    private TextView txtNameInfo, txtPriceInfo, txtDescInfo,txtPriceBottomSheet,txtPriceBottomSheetBuy;
    private LinearLayout  layoutAddToCart;
    private Button btnAddtoCart,btnPayment,btnBuy;
    private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_info_product );
        toolbar = findViewById( R.id.toolbarInfo );
        toolbar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        } );

        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra( "product" );

        imgProduct = findViewById( R.id.imgPhoto_Info );
        txtNameInfo = findViewById( R.id.txtProdNameInfo );
        txtPriceInfo = findViewById( R.id.txtProdPriceInfo );
        txtDescInfo = findViewById( R.id.txtProdDescInfo );
        layoutAddToCart = findViewById( R.id.layoutAddToCart );
        btnBuy = findViewById( R.id.btn_buy_Info );
        btnBuy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOpenBottomDialogBuy();
            }
        } );

        layoutAddToCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOpenBottomDialogAdd();
            }
        } );

        Glide.with(this)
                .load(product.getAvt())
                .into(imgProduct);
        txtNameInfo.setText( product.getName() );
        txtPriceInfo.setText( "Giá bán: "+formatVnCurrence(this,String.valueOf( product.getPrice() )) );
        txtDescInfo.setText( product.getDes()+"\n"+ "Câu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1" +
                " đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến " +
                "N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để " +
                "có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn " +
                "nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu" +
                " trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm " +
                "việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Như" +
                "ng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhậ" +
                "n được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết" +
                " quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả " +
                "tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt " +
                "nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất," +
                " không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không " +
                "phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải" +
                " với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với" +
                " maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines " +
                "và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, " +
                "mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với " +
                "maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines " +
                "và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines " +
                "và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử " +
                "dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. " +
                "Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt " +
                "đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối " +
                "thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 " +
                "và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa l" +
                "ớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn " +
                "nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, " +
                "tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N d" +
                "òng để có một cái nhìn nhỏ gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ " +
                "gọn về dữ liệuCâu trả lời này đã làm việc cho tôi. Nhưng tôi đã nhận được kết quả tốt nhất, không phải với maxlines và lines, mà với maxlines và minlines và không sử dụng dòng. Tôi đặt đường tối thiểu thành 1 và đường tối đa lớn hơn dữ liệu lớn nhất. Bằng cách đó, tôi nhận được từ 1 đến N dòng để có một cái nhìn nhỏ gọn về dữ liệu"
        );

                imgButtonCart = findViewById( R.id.btnCart_InfoProduct );
        imgButtonCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoProductActivity.this, CartActivity.class);
                startActivity(intent);
            }
        } );
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
    private void clickOpenBottomDialogAdd(){
        View viewDialog = getLayoutInflater().inflate( R.layout.bottom_sheet_addtocart,null );

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( this );
        bottomSheetDialog.setContentView( viewDialog );
        bottomSheetDialog.show();
        imgProdCart = viewDialog.findViewById( R.id.imgPhoto_Cart );
        txtPriceBottomSheet = viewDialog.findViewById( R.id.txtProdPriceCart );
        edtQuantilyCart = viewDialog.findViewById( R.id.edtQuantily_Cart );
        imgButtonMinus = viewDialog.findViewById( R.id.btnMinus );
        imgButtonAdd = viewDialog.findViewById( R.id.btnAdd );
        btnAddtoCart = viewDialog.findViewById( R.id.btnAddtoCart );
        btnCloseBottomSheetDialog = viewDialog.findViewById( R.id.btnCloseBottomSheetDialog );
        btnCloseBottomSheetDialog.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        } );

        txtPriceBottomSheet.setText( "Giá bán:\n "+formatVnCurrence(this,String.valueOf( product.getPrice() )) );
        Glide.with(this)
                .load(product.getAvt())
                .into(imgProdCart);
        edtQuantilyCart.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(Integer.valueOf(edtQuantilyCart.getText().toString())<=1){
                    imgButtonMinus.setEnabled( false );
                }
                if(Integer.valueOf(edtQuantilyCart.getText().toString())>=30){
                    imgButtonAdd.setEnabled( false );
                }
            }
        } );
        imgButtonMinus.setEnabled( false );
        imgButtonMinus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(edtQuantilyCart.getText().toString())<=1){
                    edtQuantilyCart.setText( "1" );
                } else {
                    edtQuantilyCart.setText( String.valueOf(Integer.valueOf(edtQuantilyCart.getText().toString())-1));
                    imgButtonAdd.setEnabled( true );
                }
            }
        } );
        imgButtonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(edtQuantilyCart.getText().toString())>=30){
                    edtQuantilyCart.setText( "30" );
                } else {
                    edtQuantilyCart.setText( String.valueOf(Integer.valueOf(edtQuantilyCart.getText().toString())+1));
                    imgButtonMinus.setEnabled( true );
                }
            }
        } );
        btnAddtoCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product_Cart product_cart = new Product_Cart( product.getId(), product.getName(), product.getPrice(), product.getAvt(), product.getDes(),product.getCatId(),Integer.valueOf(edtQuantilyCart.getText().toString()));
                //insert lên database

                Toast.makeText( InfoProductActivity.this,"Đã thêm vào giỏ hàng",Toast.LENGTH_SHORT ).show();
                bottomSheetDialog.dismiss();
            }
        } );
    }
    private void clickOpenBottomDialogBuy(){
        View viewDialogBuy = getLayoutInflater().inflate( R.layout.bottom_sheet_buy,null );

        BottomSheetDialog bottomSheetDialogBuy = new BottomSheetDialog( this );
        bottomSheetDialogBuy.setContentView( viewDialogBuy );
        bottomSheetDialogBuy.show();
        imgProdBuy = viewDialogBuy.findViewById( R.id.imgPhoto_Buy );
        txtPriceBottomSheetBuy = viewDialogBuy.findViewById( R.id.txtProdPriceBuy);
        edtQuantilyBuy = viewDialogBuy.findViewById( R.id.edtQuantily_Buy );
        imgButtonMinusBuy = viewDialogBuy.findViewById( R.id.btnMinusBuy );
        imgButtonAddBuy = viewDialogBuy.findViewById( R.id.btnAddBuy );
        btnPayment = viewDialogBuy.findViewById( R.id.btnPayment );
        btnCloseBottomSheetDialogBuy = viewDialogBuy.findViewById( R.id.btnCloseBottomSheetDialogBuy );
        btnCloseBottomSheetDialogBuy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogBuy.dismiss();
            }
        } );

        txtPriceBottomSheetBuy.setText( "Giá bán:\n "+formatVnCurrence(this,String.valueOf( product.getPrice() )) );
        Glide.with(this)
                .load(product.getAvt())
                .into(imgProdBuy);
        edtQuantilyBuy.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(Integer.valueOf(edtQuantilyBuy.getText().toString())<=1){
                    imgButtonMinusBuy.setEnabled( false );
                }
                if(Integer.valueOf(edtQuantilyBuy.getText().toString())>=30){
                    imgButtonAddBuy.setEnabled( false );
                }
            }
        } );
        imgButtonMinusBuy.setEnabled( false );
        imgButtonMinusBuy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(edtQuantilyBuy.getText().toString())<=1){
                    edtQuantilyBuy.setText( "1" );
                } else {
                    edtQuantilyBuy.setText( String.valueOf(Integer.valueOf(edtQuantilyBuy.getText().toString())-1));
                    imgButtonAddBuy.setEnabled( true );
                }
            }
        } );
        imgButtonAddBuy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(edtQuantilyBuy.getText().toString())>=30){
                    edtQuantilyBuy.setText( "30" );
                } else {
                    edtQuantilyBuy.setText( String.valueOf(Integer.valueOf(edtQuantilyBuy.getText().toString())+1));
                    imgButtonMinusBuy.setEnabled( true );
                }
            }
        } );
        btnPayment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product_Cart product_cart = new Product_Cart( product.getId(), product.getName(), product.getPrice(), product.getAvt(), product.getDes(),product.getCatId(),Integer.valueOf(edtQuantilyBuy.getText().toString()));
                //insert lên database
                bottomSheetDialogBuy.dismiss();
                Intent intent = new Intent(InfoProductActivity.this, PaymentActivity.class);
                intent.putExtra( "productBuy",product_cart );
                startActivity( intent );

            }
        } );
    }
}