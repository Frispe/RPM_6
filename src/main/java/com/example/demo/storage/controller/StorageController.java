package com.example.demo.storage.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.storage.model.StorageModel;
import com.example.demo.storage.service.StorageService;
import com.example.demo.storagetype.model.StorageTypeModel;
import com.example.demo.storagetype.service.StorageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/storageList")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private StorageTypeService storageTypeService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllStorages(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<StorageModel> storages = storageService.findStoragesWithPagination(page, size);
        List<StorageTypeModel> storageTypes = storageTypeService.findAllStorageTypes();
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("storages", storages);
        model.addAttribute("storageTypes", storageTypes);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) storageService.findAllStorages().size() / size));
        return "storageList";
    }

    @PostMapping("/add")
    public String addStorage(@RequestParam Long storageTypeId,
                             @RequestParam Long brandId,
                             @RequestParam String model,
                             @RequestParam int capacity,
                             @RequestParam int writeSpeed,
                             @RequestParam int readSpeed,
                             @RequestParam double price) {
        StorageTypeModel storageType = storageTypeService.findStorageTypeById(storageTypeId);
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        StorageModel newStorage = new StorageModel(0, storageType, brand, model, capacity, writeSpeed, readSpeed, price);
        storageService.addStorage(newStorage);
        return "redirect:/storageList?page=0";
    }

    @PostMapping("/update")
    public String updateStorage(@RequestParam long id,
                                @RequestParam Long storageTypeId,
                                @RequestParam Long brandId,
                                @RequestParam String model,
                                @RequestParam int capacity,
                                @RequestParam int writeSpeed,
                                @RequestParam int readSpeed,
                                @RequestParam double price) {
        StorageTypeModel storageType = storageTypeService.findStorageTypeById(storageTypeId);
        StorageModel updatedStorage = new StorageModel(id, storageType, brandId, model, capacity, writeSpeed, readSpeed, price);
        storageService.updateStorage(updatedStorage);
        return "redirect:/storageList?page=0";
    }

    @PostMapping("/delete")
    public String deleteStorage(@RequestParam long id) {
        storageService.deleteStorage(id);
        return "redirect:/storageList?page=0";
    }

    @GetMapping("/searchById")
    public String searchStorageById(@RequestParam long id, Model model) {
        StorageModel storage = storageService.findStorageById(id);
        model.addAttribute("storages", storage != null ? List.of(storage) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "storageList";
    }

    @GetMapping("/searchByModel")
    public String searchStorageByModel(@RequestParam String model, Model modelAttr) {
        StorageModel storage = storageService.findStorageByModel(model);
        modelAttr.addAttribute("storages", storage != null ? List.of(storage) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "storageList";
    }
}