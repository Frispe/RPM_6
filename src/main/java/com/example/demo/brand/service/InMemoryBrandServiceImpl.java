package com.example.demo.brand.service;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.repository.InMemoryBrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryBrandServiceImpl implements BrandService {

    private final InMemoryBrandRepository brandRepository;

    public InMemoryBrandServiceImpl(InMemoryBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandModel> findAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public BrandModel findBrandById(int id) {
        return brandRepository.findById((long) id).orElse(null);
    }

    @Override
    public BrandModel findBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    @Override
    public BrandModel addBrand(BrandModel brand) {
        return brandRepository.save(brand);
    }

    @Override
    public BrandModel updateBrand(BrandModel brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(int id) {
        brandRepository.deleteById((long) id);
    }

    @Override
    public List<BrandModel> findBrandsWithPagination(int page, int size) {
        return brandRepository.findBrandsWithPagination(page, size);
    }
}