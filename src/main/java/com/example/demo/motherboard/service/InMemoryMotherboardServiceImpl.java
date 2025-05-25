package com.example.demo.motherboard.service;

import com.example.demo.motherboard.model.MotherboardModel;
import com.example.demo.motherboard.repository.InMemoryMotherboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryMotherboardServiceImpl implements MotherboardService {

    private final InMemoryMotherboardRepository motherboardRepository;

    public InMemoryMotherboardServiceImpl(InMemoryMotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    @Override
    public List<MotherboardModel> findByBrand(Long brandId) {
        return motherboardRepository.findByBrand_Id(brandId);
    }

    @Override
    public List<MotherboardModel> findAllMotherboards() {
        return motherboardRepository.findAll();
    }

    @Override
    public MotherboardModel findMotherboardById(long id) {
        return motherboardRepository.findById(id).orElse(null);
    }

    @Override
    public MotherboardModel findMotherboardByModel(String model) {
        return motherboardRepository.findMotherboardByModel(model);
    }

    @Override
    public MotherboardModel addMotherboard(MotherboardModel motherboard) {
        return motherboardRepository.save(motherboard);
    }

    @Override
    public MotherboardModel updateMotherboard(MotherboardModel motherboard) {
        return motherboardRepository.save(motherboard);
    }

    @Override
    public void deleteMotherboard(long id) {
        motherboardRepository.deleteById(id);
    }

    @Override
    public List<MotherboardModel> findMotherboardsWithPagination(int page, int size) {
        return motherboardRepository.findMotherboardsWithPagination(page, size);
    }
}