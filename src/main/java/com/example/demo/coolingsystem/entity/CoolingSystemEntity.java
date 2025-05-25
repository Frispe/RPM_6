package com.example.demo.coolingsystem.entity;

import com.example.demo.coolingsystem.model.CoolingSystemModel;

public class CoolingSystemEntity extends CoolingSystemModel {
    public CoolingSystemEntity(int id, int brandId, String model,
                               int coolingTypeId, double price) {
        super(id, brandId, model, coolingTypeId, price);
    }
}