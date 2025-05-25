package com.example.demo.brand.service;

import com.example.demo.brand.model.BrandModel;

import java.util.List;

public interface BrandService {
    List<BrandModel> findAllBrands();
    BrandModel findBrandById(int id);
    BrandModel findBrandByName(String name);
    BrandModel addBrand(BrandModel brand);
    BrandModel updateBrand(BrandModel brand);
    void deleteBrand(int id);
    List<BrandModel> findBrandsWithPagination(int page, int size);
}