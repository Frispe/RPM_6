package com.example.demo.processor.service;

import com.example.demo.processor.model.ProcessorModel;

import java.util.List;

public interface ProcessorService {
    List<ProcessorModel> findAllProcessors();
    ProcessorModel findProcessorById(long id);
    ProcessorModel findProcessorByModel(String model);
    ProcessorModel addProcessor(ProcessorModel processor);
    ProcessorModel updateProcessor(ProcessorModel processor);
    void deleteProcessor(long id);
    List<ProcessorModel> findProcessorsWithPagination(int page, int size);
    List<ProcessorModel> findByBrand(Long brandId);
}