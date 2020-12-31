package com.example.media_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.media_app.model.model_rec_one;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.infideap.drawerbehavior.Advance3DDrawerLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private  RecyclerView  horizontal_recycler_view;
//    private ArrayList<model_rec_one> horizontalList;
//    private adaptor_recyler_one horizontalAdapter;
    public Toolbar toolbar;
    private FragmentManager fm;
    //FloatingActionButton rateUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  rateUs = findViewById(R.id.rateUs);
        toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        Advance3DDrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
       // aa= (BottomAppBar) findViewById(R.id.appBar);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        drawer.setViewScale(Gravity.START, 1f);
        drawer.setRadius(Gravity.START, 30);
        drawer.setViewElevation(Gravity.START, 10);
        drawer.setViewRotation(Gravity.START, 13);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        HomeFrag fragment = new HomeFrag(MainActivity.this);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction =
                                fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_main, fragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.action_tv:
                        Toast.makeText(MainActivity.this, "TV", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_drama:
                        Toast.makeText(MainActivity.this, "Drama", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_live:
                        Toast.makeText(MainActivity.this, "Live", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_more:
                        SettingsFragment fragment2 = new SettingsFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 =
                                fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.frame_layout_main, fragment2);
                        fragmentTransaction2.commit();
                        Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        clickNav(item.getItemId());
        return true;
    }
    public void clickNav(int item) {
        switch (item) {

            case R.id.nav_home:
                loadFrag(new HomeFrag(MainActivity.this), getResources().getString(R.string.home), fm, true);
                break;
            case R.id.nav_more:
                SettingsFragment fragment2 = new SettingsFragment();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 =
                        fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.frame_layout_main, fragment2);
                fragmentTransaction2.commit();
                Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void loadFrag(Fragment f1, String name, FragmentManager fm, boolean addToBackStack) {
        FragmentTransaction ft = fm.beginTransaction();
        if (name.equals(getResources().getString(R.string.home))) {
            addToBackStack = false;
            fm.popBackStackImmediate();
            fm.popBackStack();
        }

        if (addToBackStack)
            ft.addToBackStack(name);

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.frame_layout_main, f1, name);
        ft.commit();
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(name);
    }
//        ImageSlider imageSlider = findViewById(R.id.slider);
//        List<SlideModel> slideModel = new ArrayList<>();
//        slideModel.add(new SlideModel(R.drawable.drama2));
//        slideModel.add(new SlideModel(R.drawable.drama));
//        slideModel.add(new SlideModel(R.drawable.baba_jani));
//        imageSlider.setImageList(slideModel);




//        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizental_recy_view);
//        horizontalList = new ArrayList<model_rec_one>();
//        for (int i = 0; i < MyData.nameArray.length; i++) {
//            horizontalList.add(new model_rec_one(
//                    MyData.nameArray[i],
//                    MyData.drawableArray[i]
//            ));
//        }
//        horizontalAdapter=new adaptor_recyler_one(horizontalList);
//        LinearLayoutManager horizontalLayoutManagaer
//                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
//        horizontal_recycler_view.setAdapter(horizontalAdapter);


//    public void home_freg(View view) {
//        HomeFrag fragment = new HomeFrag(MainActivity.this);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction =
//                fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout_main, fragment);
//        fragmentTransaction.commit();
//    }
}