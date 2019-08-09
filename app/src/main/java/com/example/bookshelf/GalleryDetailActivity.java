package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.bookshelf.Adapter.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class GalleryDetailActivity extends AppCompatActivity implements GalleryAdapter.OnMyItemClickListner3 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        galleryDetails();

    }
    public void galleryDetails(){
        RecyclerView recyclerView = findViewById(R.id.galleryrecyclerview);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this,getdata2(),this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(galleryAdapter);
    }
    public List<ModelItem> getdata2() {
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
    public void setOnItemClickListener3(ModelItem modelItem, int position) {
//        Intent intent = new Intent(this, DetailItemActivity.class);
//        intent.putExtra("model", modelItem);
        startActivity(DetailItemActivity.getIntent(this,modelItem));
    }


}
