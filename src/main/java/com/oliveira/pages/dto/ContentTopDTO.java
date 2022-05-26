package com.oliveira.pages.dto;

public class ContentTopDTO extends ContentBaseDTO {

    private String description;

    public ContentTopDTO(String title, String videoUrl, StyleDTO style, String description) {
        super(title, videoUrl, style);
        this.description = description;
    }

    public ContentTopDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
