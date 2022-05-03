package com.jose.projetofs.dto;

public class FarmDTO {

    private String id;
    private String name;
    private double area;
    private double production;
    private double productivity;

    public FarmDTO() {
    }

    public FarmDTO(String id, String name, double area, double production, double productivity) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.production = production;
        this.productivity = productivity;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }
}
