package com.example.demo.powersupply.service;

import com.example.demo.powersupply.model.PowerSupplyModel;

import java.util.List;

public interface PowerSupplyService {
    List<PowerSupplyModel> findAllPowerSupplies();
    PowerSupplyModel findPowerSupplyById(long id);
    PowerSupplyModel findPowerSupplyByModel(String model);
    PowerSupplyModel addPowerSupply(PowerSupplyModel powerSupply);
    PowerSupplyModel updatePowerSupply(PowerSupplyModel powerSupply);
    void deletePowerSupply(long id);
    List<PowerSupplyModel> findPowerSuppliesWithPagination(int page, int size);
}