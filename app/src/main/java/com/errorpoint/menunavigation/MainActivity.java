package com.errorpoint.menunavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.lavender_dark));
        drawerLayout.addDrawerListener(toggle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();
        } else if (item.getItemId() == R.id.games) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Games()).commit();
        } else if (item.getItemId() == R.id.news) {
             getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new News()).commit();
        } else if (item.getItemId() == R.id.movie) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Movie()).commit();
            // Do something
        }else if (item.getItemId() == R.id.settings) {
            // Do something
        } else if (item.getItemId() == R.id.share) {
            // Do something
        } else if (item.getItemId() == R.id.privacy_policy) {
            // Do something
        } else if (item.getItemId() == R.id.logout) {
            // Do something
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}