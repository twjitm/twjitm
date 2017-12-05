package com.twjitm.answer.entity;

public class Choices {
    private Integer id;

    private String title;

    private String items;

    private String answer;

    private Integer degree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}