package com.oliveira.pages.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkDTO {

    private String textBefore;
    private String textAfter;
    private String link;
    private String linkText;

    public LinkDTO(String textBefore, String textAfter, String link, String linkText) {
        this.textBefore = textBefore;
        this.textAfter = textAfter;
        this.link = link;
        this.linkText = linkText;
    }

    public LinkDTO() {
    }

    public String getTextBefore() {
        return textBefore;
    }

    public void setTextBefore(String textBefore) {
        this.textBefore = textBefore;
    }

    public String getTextAfter() {
        return textAfter;
    }

    public void setTextAfter(String textAfter) {
        this.textAfter = textAfter;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }
}
