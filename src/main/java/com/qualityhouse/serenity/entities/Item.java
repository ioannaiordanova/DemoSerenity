package com.qualityhouse.serenity.entities;

public class Item {
    private String article;

    private String quantity;

    private String size;

    private String color;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
