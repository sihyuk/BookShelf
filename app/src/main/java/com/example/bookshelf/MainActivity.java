package com.example.bookshelf;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.bookshelf.Adapter.RecentlyAddedAdapter;
import com.example.bookshelf.Adapter.RecyclerViewAdapter;
import com.example.bookshelf.Adapter.SliderAdapter;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewAdapter.OnMyItemClickListner {

    SliderView sliderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("BookShelf");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //SliderViewClass();
        RecyclerViewBooks();
        RecentlyAddedBooks();

    }
    public  void RecentlyAddedBooks(){
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview2);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, getdata(), this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(recyclerViewAdapter);
    }

    public void SliderViewClass() {
        //sliderView = findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(this);
        adapter.setCount(4);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE);

        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                    sliderView.setCurrentPagePosition(position);
            }
        });
    }

    public void RecyclerViewBooks() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, getdata(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<ModelItem> getdata() {
        List<ModelItem> modelItems = new ArrayList<ModelItem>();
        modelItems.add(new ModelItem(R.drawable.angels_and_demon, "Angels and Demon","Dan Brown", R.string.angels_and_demon));
        modelItems.add(new ModelItem(R.drawable.game_of_thrones, "Game of Thrones","George R.R. Martin", R.string.game_of_thrones));
        modelItems.add(new ModelItem(R.drawable.shadow_of_the_wind, "Shadow of the wind","Carlos Ruiz Zafón", R.string.the_shadow_of_the_wind));
        modelItems.add(new ModelItem(R.drawable.song_of_solomon, "Song of Solomon","Toni Morrison", R.string.song_of_solomon));
        modelItems.add(new ModelItem(R.drawable.the_culling_trial, "The Culling Trial","K.F. Breene", R.string.the_culling_blade));
        modelItems.add(new ModelItem(R.drawable.the_da_vinci_code, "The Da Vinci Code","Dan Brown" ,R.string.the_da_vinci_code));
        modelItems.add(new ModelItem(R.drawable.the_name_of_the_wind, "The Name of the Wind","Patrick Rothfuss " ,R.string.the_name_of_the_wind));
        modelItems.add(new ModelItem(R.drawable.to_kill_a_mockingbird, "To kill a MockingBird","Harper Lee", R.string.to_kill_a_mockingbird));
        modelItems.add(new ModelItem(R.drawable.ulysses1, "Ulysses","James Joyce", R.string.ulysses));
        modelItems.add(new ModelItem(R.drawable.war_and_peace, "War and Peace","Leo Tolstoy", R.string.war_and_peace));

        return modelItems;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void setOnItemClickListener(ModelItem modelItem, int position) {
//        Intent intent = new Intent(this, DetailItemActivity.class);
//        intent.putExtra("model", modelItem);
        startActivity(DetailItemActivity.getIntent(this,modelItem));
    }
}
