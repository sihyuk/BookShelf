package com.example.bookshelf;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SecondDetailActivity extends AppCompatActivity {
    private static String KEY_MODEL_ITEM = "model2";

    public static Intent getIntent(Context context, ModelItem modelItem) {
        Intent intent = new Intent(context, SecondDetailActivity.class);
        intent.putExtra(KEY_MODEL_ITEM, modelItem);
        return intent;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_detail);


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);

        ImageView imageView = findViewById(R.id.ivdisplay);
        TextView title = findViewById(R.id.tvdisplaytitle);
        imageView.setImageResource(getModelItem().getImageResources());
        title.setText(getModelItem().getTitle());
        TextView author= findViewById(R.id.tvdisplayauthor);
        author.setText(getModelItem().getAuthor());
        TextView synopsis = findViewById(R.id.tvsynopsis);
        synopsis.setText(getModelItem().getSynopsis());
        String title1 = getModelItem().getTitle();
        collapsingToolbarLayout.setTitle(title1);

    }
    private ModelItem getModelItem(){
        ModelItem modelItem = (ModelItem) getIntent().getSerializableExtra(KEY_MODEL_ITEM);
        return modelItem;
    }
}
