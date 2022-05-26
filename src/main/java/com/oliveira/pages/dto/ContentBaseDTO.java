package com.oliveira.pages.dto;

public class ContentBaseDTO {

    private String title;
    private String videoUrl;
    private StyleDTO style;

    public ContentBaseDTO(String title, String videoUrl, StyleDTO style) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.style = style;
    }

    public ContentBaseDTO() {
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

    public StyleDTO getStyle() {
        return style;
    }

    public void setStyle(StyleDTO style) {
        this.style = style;
    }
}
