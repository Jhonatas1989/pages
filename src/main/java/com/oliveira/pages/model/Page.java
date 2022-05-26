package com.oliveira.pages.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pages")
public class Page {

    @Id
    private String id;

    private String name;

    private Content content;

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
