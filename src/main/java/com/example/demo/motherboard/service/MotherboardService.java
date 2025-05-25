package com.example.demo.motherboard.service;

import com.example.demo.motherboard.model.MotherboardModel;

import java.util.List;

public interface MotherboardService {
    List<MotherboardModel> findAllMotherboards();
    MotherboardModel findMotherboardById(long id);
    MotherboardModel findMotherboardByModel(String model);
    MotherboardModel addMotherboard(MotherboardModel motherboard);
    MotherboardModel updateMotherboard(MotherboardModel motherboard);
    void deleteMotherboard(long id);
    List<MotherboardModel> findMotherboardsWithPagination(int page, int size);
    List<MotherboardModel> findByBrand(Long brandId);
}