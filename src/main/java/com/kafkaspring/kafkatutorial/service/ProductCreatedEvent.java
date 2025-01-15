package com.kafkaspring.kafkatutorial.service;

public class ProductCreatedEvent {

    private String productId;
    private String title;
    private Integer qty;

    private Integer price;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String productId, String title, Integer qty, Integer price) {
        this.productId = productId;
        this.title = title;
        this.qty = qty;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
