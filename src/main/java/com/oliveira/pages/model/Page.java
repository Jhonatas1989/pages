package com.oliveira.pages.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("pages")
public class Page {

    @Id
    @NotNull(message = "Page Id cannot be null")
    private String id;

    @NotNull(message = "Page Name cannot be null")
    @NotEmpty(message = "Page name cannot be empty.")
    private String name;

    @NotNull(message = "Page Content cannot be null")
    private Content content;

    @NotNull(message = "Page Content Top cannot be null")
    private ContentTop contentTop;

    public Page(String id, String name, Content content, ContentTop contentTop) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.contentTop = contentTop;
    }

    public Page() {
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public ContentTop getContentTop() {
        return contentTop;
    }

    public void setContentTop(ContentTop contentTop) {
        this.contentTop = contentTop;
    }
}
