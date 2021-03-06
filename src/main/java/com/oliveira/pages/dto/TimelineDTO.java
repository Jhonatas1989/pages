package com.oliveira.pages.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimelineDTO {

    private String text;
    private int sequence;

    public TimelineDTO(String text, int sequence) {
        this.text = text;
        this.sequence = sequence;
    }

    public TimelineDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
