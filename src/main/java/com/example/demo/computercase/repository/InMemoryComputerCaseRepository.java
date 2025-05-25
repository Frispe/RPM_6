package com.example.demo.computercase.repository;

import com.example.demo.computercase.model.ComputerCaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryComputerCaseRepository extends JpaRepository<ComputerCaseModel, Long> {
    ComputerCaseModel findComputerCaseByModel(String model);

    default List<ComputerCaseModel> findComputerCaseWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<ComputerCaseModel> computerCasePage = findAll(pageable);
        return computerCasePage.getContent();
    }
}