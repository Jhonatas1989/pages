package com.oliveira.pages.model;

public class ContentBase {

    private String title;
    private String videoUrl;
    private Style style;

    public ContentBase(String title, String videoUrl, Style style) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
