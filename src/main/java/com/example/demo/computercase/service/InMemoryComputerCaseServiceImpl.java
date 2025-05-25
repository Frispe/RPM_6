package com.example.demo.computercase.service;

import com.example.demo.computercase.model.ComputerCaseModel;
import com.example.demo.computercase.repository.InMemoryComputerCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryComputerCaseServiceImpl implements ComputerCaseService {

    private final InMemoryComputerCaseRepository computerCaseRepository;

    public InMemoryComputerCaseServiceImpl(InMemoryComputerCaseRepository computerCaseRepository) {
        this.computerCaseRepository = computerCaseRepository;
    }

    @Override
    public List<ComputerCaseModel> findAllComputerCases() {
        return computerCaseRepository.findAll();
    }

    @Override
    public ComputerCaseModel findComputerCaseById(long id) {
        return computerCaseRepository.findById(id).orElse(null);
    }

    @Override
    public ComputerCaseModel findComputerCaseByModel(String model) {
        return computerCaseRepository.findComputerCaseByModel(model);
    }

    @Override
    public ComputerCaseModel addComputerCase(ComputerCaseModel computerCase) {
        return computerCaseRepository.save(computerCase);
    }

    @Override
    public ComputerCaseModel updateComputerCase(ComputerCaseModel computerCase) {
        return computerCaseRepository.save(computerCase);
    }

    @Override
    public void deleteComputerCase(long id) {
        computerCaseRepository.deleteById(id);
    }

    @Override
    public List<ComputerCaseModel> findComputerCaseWithPagination(int page, int size) {
        return computerCaseRepository.findComputerCaseWithPagination(page, size);
    }
}