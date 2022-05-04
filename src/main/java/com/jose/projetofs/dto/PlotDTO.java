package com.jose.projetofs.dto;

public class PlotDTO {
    private String id;
    private String farmId;
    private String name;
    private double area;
    private double production;
    private double productivity;

    public PlotDTO() {
    }

    public PlotDTO(String id, String farmId, String name, double area, double production, double productivity) {
        this.id = id;
        this.farmId = farmId;
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

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
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
