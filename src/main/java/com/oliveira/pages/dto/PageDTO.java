package com.oliveira.pages.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PageDTO {

    @NotNull(message = "Page Id cannot be null")
    private String id;

    @NotNull(message = "Page Name cannot be null")
    @NotEmpty(message = "Page name cannot be empty.")
    private String name;

    @NotNull(message = "Page Content cannot be null")
    private ContentDTO content;

    @NotNull(message = "Page Content Top cannot be null")
    private ContentTopDTO contentTop;

    public PageDTO(String id, String name, ContentDTO content, ContentTopDTO contentTop) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.contentTop = contentTop;
    }

    public PageDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContentDTO getContent() {
        return content;
    }

    public void setContent(ContentDTO content) {
        this.content = content;
    }

    public ContentTopDTO getContentTop() {
        return contentTop;
    }

    public void setContentTop(ContentTopDTO contentTop) {
        this.contentTop = contentTop;
    }
}
