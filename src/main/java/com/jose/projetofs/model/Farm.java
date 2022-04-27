package com.jose.projetofs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Farm {

    @Id
    private String id;
    private String name;
    private List<Plot> plots;


    public Farm() {
    }

    public Farm(String name) {
        this.name = name;
    }

    public Farm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Farm(String name, List<Plot> plots) {
        this.name = name;
        this.plots = plots;
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

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }
}
