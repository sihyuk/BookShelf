package com.example.bookshelf.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshelf.DetailItemActivity;
import com.example.bookshelf.ModelItem;
import com.example.bookshelf.R;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private List<ModelItem> modelItems;
    private int images;
    private String title;
    private int synopsis;
    private  String author;
    private OnMyItemClickListner listener;

    public RecyclerViewAdapter(Context context, List<ModelItem> modelItems, OnMyItemClickListner listner) {
        this.context = context;
        this.modelItems = modelItems;
        this.listener = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_booklist, parent, false);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final ModelItem modelItem = modelItems.get(position);
        images = modelItem.getImageResources();
        title = modelItem.getTitle();
        synopsis = modelItem.getSynopsis();
        author = modelItem.getAuthor();
        holder.binditem(images, title,author, synopsis);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.setOnItemClickListener(modelItem, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        Context context;

        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvrecycleritem);
            imageView = itemView.findViewById(R.id.ivrecycleitem);
            this.context = context;
        }

        public void binditem(int image_id, String itemtitle,String author, int synopsis_id) {
            textView.setText(itemtitle);
            imageView.setImageResource(image_id);
        }

    }

    public interface OnMyItemClickListner {

        void setOnItemClickListener(ModelItem modelItem, int position);
    }
}


