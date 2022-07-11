package com.example.shopbanhang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopbanhang.R;
import com.example.shopbanhang.recycleViewHome.Product;
import com.example.shopbanhang.recycleViewHome.ProductAdapter;

import java.util.ArrayList;

public class LaptopFragment extends Fragment {
    private RecyclerView recyclerViewPhone;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productArrayList,LaptopArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_phone, container, false);
        recyclerViewPhone = rootView.findViewById( R.id.recycleView_Phone );
        productArrayList = new ArrayList<Product>();
        LaptopArrayList = new ArrayList<Product>();
        productArrayList.add(new Product(1, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(2, "Samsung Galaxy S22 5G",21990000,
                "https://cdn.tgdd.vn/Products/Images/42/231110/Galaxy-S22-Black-600x600.jpg","Điện thoại mới của samsung",1));
        productArrayList.add(new Product(3, "Iphone 11",16990000,
                "https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-do-600x600.jpg","Iphone thế hệ 11",1));
        productArrayList.add(new Product(4, "Laptop Lenovo Yoga-Duet 7",25900000,
                "https://cdn.tgdd.vn/Products/Images/44/255562/lenovo-yoga-duet-7-13itl6-i5-82ma000pvn-021121-032719-600x600.jpg","Laptop Lenovo",2));
        productArrayList.add(new Product(5, "Samsung Galaxy S21 FE 5G",14900000,
                "https://cdn.tgdd.vn/Products/Images/42/267211/Samsung-Galaxy-S21-FE-tim-600x600.jpg","Điện thoại FE của samsung",1));
        productArrayList.add(new Product(6, "Realme C35",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/261888/realme-c35-black-thumb-600x600.jpg","Điện thoại của realme",1));
        productArrayList.add(new Product(7, "Iphone 13 Pro Max",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg","Iphone thế hệ 13",1));
        productArrayList.add(new Product(8, "Samsung Galaxy Z Fold3 5G",33900000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(9, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(10, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(11, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(12, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(13, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));
        productArrayList.add(new Product(14, "Samsung Galaxy Z Fold3 5G",38990000,
                "https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg","Điện thoại gập của samsung",1));

        for (int i = 0; i < productArrayList.size(); i++) {
            if(productArrayList.get( i ).getCatId()==2){
                LaptopArrayList.add( productArrayList.get( i ) );
            }
        }
        productAdapter = new ProductAdapter(LaptopArrayList,rootView.getContext());
        recyclerViewPhone.setAdapter(productAdapter);
        recyclerViewPhone.setLayoutManager(new LinearLayoutManager( rootView.getContext(), LinearLayoutManager.VERTICAL, false));
        return rootView;
    }
}
