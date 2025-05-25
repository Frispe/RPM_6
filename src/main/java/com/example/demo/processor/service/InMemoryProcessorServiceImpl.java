package com.example.demo.processor.service;

import com.example.demo.processor.model.ProcessorModel;
import com.example.demo.processor.repository.InMemoryProcessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryProcessorServiceImpl implements ProcessorService {

    private final InMemoryProcessorRepository processorRepository;

    public InMemoryProcessorServiceImpl(InMemoryProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }

    @Override
    public List<ProcessorModel> findAllProcessors() {
        return processorRepository.findAll();
    }

    @Override
    public ProcessorModel findProcessorById(long id) {
        return processorRepository.findById(id).orElse(null);
    }

    @Override
    public ProcessorModel findProcessorByModel(String model) {
        return processorRepository.findProcessorByModel(model);
    }

    @Override
    public ProcessorModel addProcessor(ProcessorModel processor) {
        return processorRepository.save(processor);
    }

    @Override
    public ProcessorModel updateProcessor(ProcessorModel processor) {
        return processorRepository.save(processor);
    }

    @Override
    public void deleteProcessor(long id) {
        processorRepository.deleteById(id);
    }

    @Override
    public List<ProcessorModel> findProcessorsWithPagination(int page, int size) {
        return processorRepository.findProcessorsWithPagination(page, size);
    }

    @Override
    public List<ProcessorModel> findByBrand(Long brandId) {
        return processorRepository.findByBrand_Id(brandId);
    }
}