package com.jose.projetofs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plot {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private long area;
    private long production;

    public Plot() {
    }

    public Plot(String name, long area, long production) {
        this.name = name;
        this.area = area;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getProduction() {
        return production;
    }

    public void setProduction(long production) {
        this.production = production;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
