package com.example.demo.powersupply.repository;

import com.example.demo.powersupply.model.PowerSupplyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InMemoryPowerSupplyRepository extends JpaRepository<PowerSupplyModel, Long> {
    PowerSupplyModel findPowerSupplyByModel(String model);
    List<PowerSupplyModel> findByBrand_Id(Long brandId);

    default List<PowerSupplyModel> findPowerSuppliesWithPagination(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<PowerSupplyModel> powerSupplyPage = findAll(pageable);
        return powerSupplyPage.getContent();
    }
}