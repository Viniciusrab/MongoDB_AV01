package com.iftm.edu.br.shopping_api.models.dto;

import java.util.List;

public class ShoppingDTO {
    private String id;
    private String userId;
    private List<String> productIds;
    private double total;

    public ShoppingDTO() {}

    public ShoppingDTO(String id, String userId, List<String> productIds, double total) {
        this.id = id;
        this.userId = userId;
        this.productIds = productIds;
        this.total = total;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", productIds=" + productIds +
                ", total=" + total +
                '}';
    }
}
