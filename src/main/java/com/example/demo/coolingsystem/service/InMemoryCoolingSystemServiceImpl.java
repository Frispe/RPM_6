package com.example.demo.coolingsystem.service;

import com.example.demo.coolingsystem.model.CoolingSystemModel;
import com.example.demo.coolingsystem.repository.InMemoryCoolingSystemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryCoolingSystemServiceImpl implements CoolingSystemService {

    private final InMemoryCoolingSystemRepository coolingSystemRepository;

    public InMemoryCoolingSystemServiceImpl(InMemoryCoolingSystemRepository coolingSystemRepository) {
        this.coolingSystemRepository = coolingSystemRepository;
    }

    @Override
    public List<CoolingSystemModel> findAllCoolingSystems() {
        return coolingSystemRepository.findAll();
    }

    @Override
    public CoolingSystemModel findCoolingSystemById(long id) {
        return coolingSystemRepository.findById(id).orElse(null);
    }

    @Override
    public CoolingSystemModel findCoolingSystemByModel(String model) {
        return coolingSystemRepository.findCoolingSystemByModel(model);
    }

    @Override
    public CoolingSystemModel addCoolingSystem(CoolingSystemModel coolingSystem) {
        return coolingSystemRepository.save(coolingSystem);
    }

    @Override
    public CoolingSystemModel updateCoolingSystem(CoolingSystemModel coolingSystem) {
        return coolingSystemRepository.save(coolingSystem);
    }

    @Override
    public void deleteCoolingSystem(long id) {
        coolingSystemRepository.deleteById(id);
    }

    @Override
    public List<CoolingSystemModel> findCoolingSystemsWithPagination(int page, int size) {
        return coolingSystemRepository.findCoolingSystemsWithPagination(page, size);
    }
}