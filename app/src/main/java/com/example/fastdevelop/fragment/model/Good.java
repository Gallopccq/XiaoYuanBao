package com.example.fastdevelop.fragment.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class Good {
    private String name;
    private String description;
    private double price;
    private int clickTime;
    private Bitmap picture;
    public Good(String name, double price, int clickTime, Bitmap picture)
    {
        this.name = name;
        this.price = price;
        this.clickTime = clickTime;
        this.picture = picture;
    }
    public String getName()
    { return name; }
    public String getDescription()
    { return description; }
    public double getPrice()
    { return price; }
    public int getClickTime()
    { return clickTime; }
    public Bitmap getPicture()
    { return picture; }
}
