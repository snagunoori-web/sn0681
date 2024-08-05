package com.txrental.tool.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tool {
    private @Id
    @GeneratedValue Long id;

    private String toolCode;

    private String toolType;
    private String brand;

    public Tool() {

    }

    public Tool(String toolCode, String toolType, String band) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = band;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString() {
        return "ToolDetails{" +
                "id=" + id +
                ", toolCode='" + toolCode + '\'' +
                ", toolType='" + toolType + '\'' +
                ", band='" + brand + '\'' +
                '}';
    }
}
