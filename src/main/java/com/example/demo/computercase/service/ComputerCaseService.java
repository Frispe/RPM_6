package com.example.demo.computercase.service;

import com.example.demo.computercase.model.ComputerCaseModel;

import java.util.List;

public interface ComputerCaseService {
    List<ComputerCaseModel> findAllComputerCases();
    ComputerCaseModel findComputerCaseById(long id);
    ComputerCaseModel findComputerCaseByModel(String model);
    ComputerCaseModel addComputerCase(ComputerCaseModel computerCase);
    ComputerCaseModel updateComputerCase(ComputerCaseModel computerCase);
    void deleteComputerCase(long id);
    List<ComputerCaseModel> findComputerCaseWithPagination(int page, int size);
}