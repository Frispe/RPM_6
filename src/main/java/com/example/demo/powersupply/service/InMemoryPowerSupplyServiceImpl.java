package com.example.demo.powersupply.service;

import com.example.demo.powersupply.model.PowerSupplyModel;
import com.example.demo.powersupply.repository.InMemoryPowerSupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryPowerSupplyServiceImpl implements PowerSupplyService {

    private final InMemoryPowerSupplyRepository powerSupplyRepository;

    public InMemoryPowerSupplyServiceImpl(InMemoryPowerSupplyRepository powerSupplyRepository) {
        this.powerSupplyRepository = powerSupplyRepository;
    }

    @Override
    public List<PowerSupplyModel> findAllPowerSupplies() {
        return powerSupplyRepository.findAll();
    }

    @Override
    public PowerSupplyModel findPowerSupplyById(long id) {
        return powerSupplyRepository.findById(id).orElse(null);
    }

    @Override
    public PowerSupplyModel findPowerSupplyByModel(String model) {
        return powerSupplyRepository.findPowerSupplyByModel(model);
    }

    @Override
    public PowerSupplyModel addPowerSupply(PowerSupplyModel powerSupply) {
        return powerSupplyRepository.save(powerSupply);
    }

    @Override
    public PowerSupplyModel updatePowerSupply(PowerSupplyModel powerSupply) {
        return powerSupplyRepository.save(powerSupply);
    }

    @Override
    public void deletePowerSupply(long id) {
        powerSupplyRepository.deleteById(id);
    }

    @Override
    public List<PowerSupplyModel> findPowerSuppliesWithPagination(int page, int size) {
        return powerSupplyRepository.findPowerSuppliesWithPagination(page, size);
    }
}