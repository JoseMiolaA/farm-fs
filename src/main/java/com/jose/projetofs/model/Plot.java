package com.jose.projetofs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Plot {

    @Id
    private String id;

    private String farmId;
    private String name;
    private double area;
    private List<Production> productions;


    public double calculateProductivity() {
        return calculateTotalProduction() / area;
    }

    public double calculateTotalProduction(){
        return productions
                .stream()
                .mapToDouble(x -> x.getQuantity())
                .sum();
    }

    public Plot(String id, String farmId, String name, double area, List<Production> productions) {
        this.id = id;
        this.farmId = farmId;
        this.name = name;
        this.area = area;
        this.productions = productions;
    }

    public Plot() {
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

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }

}