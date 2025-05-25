package com.example.demo.computercase.entity;

import com.example.demo.computercase.model.ComputerCaseModel;

public class ComputerCaseEntity extends ComputerCaseModel {
    public ComputerCaseEntity(int id, int brandId, String model,
                              String formFactor, double price) {
        super(id, brandId, model, formFactor, price);
    }
}