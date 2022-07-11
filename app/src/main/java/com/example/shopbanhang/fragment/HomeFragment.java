package com.example.shopbanhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.shopbanhang.payment.InfoProductActivity;
import com.example.shopbanhang.recycleViewHome.Product;
import com.example.shopbanhang.recycleViewHome.ProductAdapter;
import com.example.shopbanhang.recycleViewHome.RecyclerTouchListener;
import com.example.shopbanhang.slider.Photo;
import com.example.shopbanhang.slider.PhotoAdapter;
import com.example.shopbanhang.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import pl.droidsonroids.gif.GifImageView;

public class HomeFragment extends Fragment {
    public static ViewPager2 mViewPager2;
    private CircleIndicator3 mCircleIndicator3;
    private List<Photo> list;
    private RecyclerView recyclerView,recyclerView2;
    private GifImageView gifImageView;
    ProductAdapter productAdapter;
    ArrayList<Product> productArrayList;

    private Handler handler = new Handler( Looper.getMainLooper());
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentPos = mViewPager2.getCurrentItem();
            if(currentPos == list.size()-1){
                mViewPager2.setCurrentItem( 0 );
            } else {
                mViewPager2.setCurrentItem( currentPos + 1 );
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_home, container, false);
        mViewPager2 = rootView.findViewById( R.id.view_pager2 );
        mCircleIndicator3 = rootView.findViewById( R.id.cir_indicator3 );
        recyclerView = rootView.findViewById( R.id.recycleViewSP );
        recyclerView2 = rootView.findViewById( R.id.recycleView2 );

        gifImageView = rootView.findViewById( R.id.gifNewImage );
        Glide.with(this)
                .load("http://vaishaliscientific.com/wp-content/uploads/2019/11/new-gif-image-6.gif")
                .into(gifImageView);
        list = getListPhoto();
        PhotoAdapter photoAdapter = new PhotoAdapter( this.getActivity(),list );
        mViewPager2.setAdapter( photoAdapter );
        mCircleIndicator3.setViewPager( mViewPager2 );
        mViewPager2.registerOnPageChangeCallback( new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected( position );
                handler.removeCallbacks( runnable );
                handler.postDelayed( runnable,2500 );
            }
        } );
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                Toast.makeText( rootView.getContext(), list.get(position).getLink(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

            }
        });
        productArrayList = new ArrayList<Product>();
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
        productAdapter = new ProductAdapter(productArrayList,rootView.getContext());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
        recyclerView2.setAdapter(productAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(rootView.getContext(), 3));
        recyclerView.addOnItemTouchListener( new RecyclerTouchListener( rootView.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
               // Toast.makeText( rootView.getContext(),"Onclick"+productArrayList.get( position ).getId(),Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(rootView.getContext(), InfoProductActivity.class);
                intent.putExtra( "product", (Serializable) productArrayList.get( position ) );
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText( rootView.getContext(),"LongClick"+productArrayList.get( position ).getId(),Toast.LENGTH_SHORT ).show();
            }
        } ) );

        return rootView;
    }

    private List<Photo> getListPhoto() {
        list = new ArrayList<>();
        list.add( new Photo( "https://cdn.tgdd.vn/2022/03/banner/A55-390-97-390x97.png" ) );
        list.add( new Photo( "https://cdn.tgdd.vn/2022/03/banner/A53-800-200-800x200.png" ) );
        list.add( new Photo( "https://cdn.tgdd.vn/2022/03/banner/800-200-800x200-86.png" ) );
        list.add( new Photo( "https://cdn.tgdd.vn/2022/03/banner/real9proseri-800-200-800x200.png") );
        return list;
    }

    @Override
    public void onPause() {
        handler.removeCallbacks( runnable );
        super.onPause();
    }

    @Override
    public void onResume() {
        handler.postDelayed( runnable,2500 );
        super.onResume();
    }
}
