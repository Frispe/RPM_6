package com.example.demo.coolingsystem.service;

import com.example.demo.coolingsystem.model.CoolingSystemModel;

import java.util.List;

public interface CoolingSystemService {
    List<CoolingSystemModel> findAllCoolingSystems();
    CoolingSystemModel findCoolingSystemById(long id);
    CoolingSystemModel findCoolingSystemByModel(String model);
    CoolingSystemModel addCoolingSystem(CoolingSystemModel coolingSystem);
    CoolingSystemModel updateCoolingSystem(CoolingSystemModel coolingSystem);
    void deleteCoolingSystem(long id);
    List<CoolingSystemModel> findCoolingSystemsWithPagination(int page, int size);
}