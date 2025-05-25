package com.example.demo.processor.repository;

import com.example.demo.processor.model.ProcessorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryProcessorRepository extends JpaRepository<ProcessorModel, Long> {
    ProcessorModel findProcessorByModel(String model);
    List<ProcessorModel> findByBrand_Id(Long brandId);

    default List<ProcessorModel> findProcessorsWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<ProcessorModel> processorPage = findAll(pageable);
        return processorPage.getContent();
    }
}