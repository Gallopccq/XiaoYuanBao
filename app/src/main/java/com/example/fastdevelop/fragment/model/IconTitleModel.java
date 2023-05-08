package com.example.fastdevelop.fragment.model;

/**
 * 图标和标题的model
 */

public class IconTitleModel {

    private int iconResource;
    private String title;

    public IconTitleModel(int iconResource, String title) {
        this.iconResource = iconResource;
        this.title = title;
    }

    @Override
    public String toString() {
        return "IconTitleModel{" +
                "iconResource=" + iconResource +
                ", title='" + title + '\'' +
                '}';
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public String getIconTitle() {
        return title;
    }

    public void setIconTitle(String title) {
        this.title = title;
    }
}
