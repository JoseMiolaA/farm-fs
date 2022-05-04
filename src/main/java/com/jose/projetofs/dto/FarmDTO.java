package com.jose.projetofs.dto;

public class FarmDTO {

    private String id;
    private String name;
    private double area;
    private double totalProduction;
    private double productivity;

    public FarmDTO() {
    }

    public FarmDTO(String id, String name, double area, double totalProduction, double productivity) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.totalProduction = totalProduction;
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

    public double getTotalProduction() {
        return totalProduction;
    }

    public void setTotalProduction(double totalProduction) {
        this.totalProduction = totalProduction;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }
}
