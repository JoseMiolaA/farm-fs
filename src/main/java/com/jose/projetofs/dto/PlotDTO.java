package com.jose.projetofs.dto;

import com.jose.projetofs.model.Production;

import java.util.List;

public class PlotDTO {
    private String id;
    private String farmId;
    private String name;
    private double area;
    private double totalProduction;
    private double productivity;
    private List<Production> productions;

    public PlotDTO() {
    }

    public PlotDTO(String id, String farmId, String name, double area, double totalProduction, double productivity, List<Production> productions) {
        this.id = id;
        this.farmId = farmId;
        this.name = name;
        this.area = area;
        this.totalProduction = totalProduction;
        this.productivity = productivity;
        this.productions = productions;
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

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }
}
