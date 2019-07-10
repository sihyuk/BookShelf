package com.example.bookshelf;

import java.io.Serializable;

public class ModelItem implements Serializable {


    private int imageResources;
    private String title;
    private int Synopsis;
    private String author;

    public ModelItem(int imageResources, String title, String author, int synopsis) {
        this.imageResources = imageResources;
        this.title = title;
        this.Synopsis = synopsis;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResources() {
        return imageResources;
    }


    public int getSynopsis() {
        return Synopsis;
    }

    public String getAuthor() {
        return author;
    }
}

