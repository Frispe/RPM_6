package com.example.demo.ram.service;

import com.example.demo.ram.model.RamModel;

import java.util.List;

public interface RamService {
    List<RamModel> findAllRams();
    RamModel findRamById(long id);
    RamModel findRamByModel(String model);
    RamModel addRam(RamModel ram);
    RamModel updateRam(RamModel ram);
    void deleteRam(long id);
    List<RamModel> findRamsWithPagination(int page, int size);
    List<RamModel> findByBrand(Long brandId);
}