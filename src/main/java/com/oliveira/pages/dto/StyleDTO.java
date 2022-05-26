package com.oliveira.pages.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StyleDTO {

    private String titleColor;
    private String titleFontSize;
    private String descriptionColor;
    private String descriptionFontSize;
    private String linkColor;
    private String backgroundColor;
    private String buttonColor;
    private String buttonBackgroundColor;

    public StyleDTO(
            String titleColor,
            String titleFontSize,
            String descriptionColor,
            String descriptionFontSize,
            String linkColor,
            String backgroundColor,
            String buttonColor,
            String buttonBackgroundColor) {
        this.titleColor = titleColor;
        this.titleFontSize = titleFontSize;
        this.descriptionColor = descriptionColor;
        this.descriptionFontSize = descriptionFontSize;
        this.linkColor = linkColor;
        this.backgroundColor = backgroundColor;
        this.buttonColor = buttonColor;
        this.buttonBackgroundColor = buttonBackgroundColor;
    }

    public StyleDTO() {
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitleFontSize() {
        return titleFontSize;
    }

    public void setTitleFontSize(String titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    public String getDescriptionColor() {
        return descriptionColor;
    }

    public void setDescriptionColor(String descriptionColor) {
        this.descriptionColor = descriptionColor;
    }

    public String getDescriptionFontSize() {
        return descriptionFontSize;
    }

    public void setDescriptionFontSize(String descriptionFontSize) {
        this.descriptionFontSize = descriptionFontSize;
    }

    public String getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    public String getButtonBackgroundColor() {
        return buttonBackgroundColor;
    }

    public void setButtonBackgroundColor(String buttonBackgroundColor) {
        this.buttonBackgroundColor = buttonBackgroundColor;
    }
}
