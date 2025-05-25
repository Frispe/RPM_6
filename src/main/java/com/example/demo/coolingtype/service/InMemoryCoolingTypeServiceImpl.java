package com.example.demo.coolingtype.service;

import com.example.demo.coolingtype.model.CoolingTypeModel;
import com.example.demo.coolingtype.repository.InMemoryCoolingTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryCoolingTypeServiceImpl implements CoolingTypeService {

    private final InMemoryCoolingTypeRepository coolingTypeRepository;

    public InMemoryCoolingTypeServiceImpl(InMemoryCoolingTypeRepository coolingTypeRepository) {
        this.coolingTypeRepository = coolingTypeRepository;
    }

    @Override
    public List<CoolingTypeModel> findAllCoolingTypes() {
        return coolingTypeRepository.findAll();
    }

    @Override
    public CoolingTypeModel findCoolingTypeById(long id) {
        return coolingTypeRepository.findById(id).orElse(null);
    }

    @Override
    public CoolingTypeModel findCoolingTypeByName(String typeName) {
        return coolingTypeRepository.findCoolingTypeByName(typeName);
    }

    @Override
    public CoolingTypeModel addCoolingType(CoolingTypeModel coolingType) {
        return coolingTypeRepository.save(coolingType);
    }

    @Override
    public CoolingTypeModel updateCoolingType(CoolingTypeModel coolingType) {
        if (coolingTypeRepository.existsById(coolingType.getId())) {
            return coolingTypeRepository.save(coolingType);
        }
        return null;
    }

    @Override
    public void deleteCoolingType(long id) {
        coolingTypeRepository.deleteById(id);
    }

    @Override
    public List<CoolingTypeModel> findCoolingTypesWithPagination(int page, int size) {
        return coolingTypeRepository.findCoolingTypesWithPagination(page, size);
    }
}