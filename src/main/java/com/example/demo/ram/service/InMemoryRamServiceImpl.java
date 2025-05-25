package com.example.demo.ram.service;

import com.example.demo.ram.model.RamModel;
import com.example.demo.ram.repository.InMemoryRamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryRamServiceImpl implements RamService {

    private final InMemoryRamRepository ramRepository;

    public InMemoryRamServiceImpl(InMemoryRamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    @Override
    public List<RamModel> findByBrand(Long brandId) {
        return ramRepository.findByBrand_Id(brandId);
    }

    @Override
    public List<RamModel> findAllRams() {
        return ramRepository.findAll();
    }

    @Override
    public RamModel findRamById(long id) {
        return ramRepository.findById(id).orElse(null);
    }

    @Override
    public RamModel findRamByModel(String model) {
        return ramRepository.findRamByModel(model);
    }

    @Override
    public RamModel addRam(RamModel ram) {
        return ramRepository.save(ram);
    }

    @Override
    public RamModel updateRam(RamModel ram) {
        return ramRepository.save(ram);
    }

    @Override
    public void deleteRam(long id) {
        ramRepository.deleteById(id);
    }

    @Override
    public List<RamModel> findRamsWithPagination(int page, int size) {
        return ramRepository.findRamsWithPagination(page, size);
    }
}