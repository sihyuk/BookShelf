package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailItemActivity extends AppCompatActivity {
    private static String KEY_MODEL_ITEM = "model";

    public static Intent getIntent(Context context, ModelItem modelItem) {
        Intent intent = new Intent(context, DetailItemActivity.class);
        intent.putExtra(KEY_MODEL_ITEM, modelItem);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        ImageView imageView = findViewById(R.id.ivdisplay);
        TextView title = findViewById(R.id.tvdisplaytitle);
        imageView.setImageResource(getModelItem().getImageResources());
        title.setText(getModelItem().getTitle());
        TextView author= findViewById(R.id.tvdisplayauthor);
        author.setText(getModelItem().getAuthor());
        TextView synopsis = findViewById(R.id.tvsynopsis);
        synopsis.setText(getModelItem().getSynopsis());

    }

    private ModelItem getModelItem(){
        ModelItem modelItem = (ModelItem) getIntent().getSerializableExtra(KEY_MODEL_ITEM);
        return modelItem;
    }
}
