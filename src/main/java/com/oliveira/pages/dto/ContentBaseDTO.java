package com.oliveira.pages.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentBaseDTO {

    private String title;
    private String videoUrl;

    @NotNull(message = "Style cannot be null")
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
