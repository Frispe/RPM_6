package com.example.demo.coolingsystem.model;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.coolingtype.model.CoolingTypeModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "CoolingSystem")
public class CoolingSystemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cooling_type_id")
    private CoolingTypeModel coolingType;

    @Positive(message = "Price must be positive")
    private double price;

    public CoolingSystemModel() {
    }

    public CoolingSystemModel(long id, int brandId, String model, int coolingTypeId, double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Positive(message = "Price must be positive")
    public double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "Price must be positive") double price) {
        this.price = price;
    }

    public @NotBlank(message = "Model is required") String getModel() {
        return model;
    }

    public void setModel(@NotBlank(message = "Model is required") String model) {
        this.model = model;
    }

    public CoolingTypeModel getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(CoolingTypeModel coolingType) {
        this.coolingType = coolingType;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }
}