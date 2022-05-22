package com.oliveira.pages.model;

public class Timeline {

    private String text;
    private int sequence;

    public Timeline(String text, int sequence) {
        this.text = text;
        this.sequence = sequence;
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
