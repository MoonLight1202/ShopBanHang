package com.example.shopbanhang.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shopbanhang.R;
import com.example.shopbanhang.cart.CartActivity;
import com.example.shopbanhang.fragment.ContactFragment;
import com.example.shopbanhang.fragment.HomeFragment;
import com.example.shopbanhang.fragment.LaptopFragment;
import com.example.shopbanhang.fragment.PhoneFragment;
import com.example.shopbanhang.fragment.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_PHONE = 1;
    private static final int FRAGMENT_LAPTOP = 2;
    private static final int FRAGMENT_CONTACT = 3;
    private static final int FRAGMENT_PROFILE = 4;

    private  int currentFragment = FRAGMENT_HOME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        drawerLayout = findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.nav_drawer_open,R.string.nav_drawer_close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.navigationView );
        navigationView.setNavigationItemSelectedListener( this );
        replaceFragment( new HomeFragment() );
        navigationView.getMenu().findItem( R.id.nav_home ).setChecked( true );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home) {
            if(currentFragment != FRAGMENT_HOME){
                replaceFragment( new HomeFragment() );
                currentFragment = FRAGMENT_HOME;
            }
        } else if(id == R.id.nav_phone) {
            if(currentFragment != FRAGMENT_PHONE){
                replaceFragment( new PhoneFragment() );
                currentFragment = FRAGMENT_PHONE;
            }
        } else if(id == R.id.nav_laptop) {
            if(currentFragment != FRAGMENT_LAPTOP){
                replaceFragment( new LaptopFragment() );
                currentFragment = FRAGMENT_LAPTOP;
            }
        } else if(id == R.id.nav_contact) {
            if(currentFragment != FRAGMENT_CONTACT){
                replaceFragment( new ContactFragment() );
                currentFragment = FRAGMENT_CONTACT;
            }
        } else if(id == R.id.nav_profile) {
            if(currentFragment != FRAGMENT_PROFILE){
                replaceFragment( new ProfileFragment() );
                currentFragment = FRAGMENT_PROFILE;
            }
        }
        drawerLayout.closeDrawer( GravityCompat.START );
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen( GravityCompat.START )){
            drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.content_frame,fragment );
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart,menu);
        MenuItem item = menu.findItem(R.id.menu_cart);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_cart){
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected( item );
    }
}