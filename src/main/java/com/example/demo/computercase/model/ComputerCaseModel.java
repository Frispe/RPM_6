package com.example.demo.computercase.model;

import com.example.demo.brand.model.BrandModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "ComputerCase")
public class ComputerCaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Form factor is required")
    private String formFactor;

    @Positive(message = "Price must be positive")
    private double price;

    public ComputerCaseModel() {
    }

    public ComputerCaseModel(long id, int brandId, String model, String formFactor, double price) {
        this.id = id;
        this.model = model;
        this.formFactor = formFactor;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}