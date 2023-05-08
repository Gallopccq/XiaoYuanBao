package com.example.fastdevelop.fragment.model;

/* attention!
 * 当添加新一类数据时需要修改：
 * Goods的成员、构造函数，对应的setter,getter方法
 * GoodsAdapter.ViewHolder的成员、构造函数
 *  */

public class Goods {
    private int imageResource;
    private String title;
    private String description;

    public Goods(int imageResource,String title,String description){
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
