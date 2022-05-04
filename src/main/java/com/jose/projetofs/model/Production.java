package com.jose.projetofs.model;

public class Production {
    private String type;
    private double quantity;

    public Production(String type, double quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public Production() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
