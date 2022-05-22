package com.oliveira.pages.model;

public class ContentTop extends ContentBase {

    private String description;

    public ContentTop(String title, String videoUrl, Style style, String description) {
        super(title, videoUrl, style);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
