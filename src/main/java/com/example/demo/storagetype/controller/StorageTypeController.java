package com.example.demo.storagetype.controller;

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
@RequestMapping("/storageTypeList")
public class StorageTypeController {

    @Autowired
    private StorageTypeService storageTypeService;

    @GetMapping
    public String getAllStorageTypes(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<StorageTypeModel> storageTypes = storageTypeService.findStorageTypesWithPagination(page, size);
        model.addAttribute("storageTypes", storageTypes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) storageTypeService.findAllStorageTypes().size() / size));
        return "storageTypeList";
    }

    @PostMapping("/add")
    public String addStorageType(@RequestParam String typeName) {
        StorageTypeModel newStorageType = new StorageTypeModel(null, typeName);
        storageTypeService.addStorageType(newStorageType);
        return "redirect:/storageTypeList?page=0";
    }

    @PostMapping("/update")
    public String updateStorageType(@RequestParam Long id,
                                    @RequestParam String typeName) {
        StorageTypeModel updatedStorageType = new StorageTypeModel(id, typeName);
        storageTypeService.updateStorageType(updatedStorageType);
        return "redirect:/storageTypeList?page=0";
    }

    @PostMapping("/delete")
    public String deleteStorageType(@RequestParam Long id) {
        storageTypeService.deleteStorageType(id);
        return "redirect:/storageTypeList?page=0";
    }

    @GetMapping("/searchById")
    public String searchStorageTypeById(@RequestParam Long id, Model model) {
        StorageTypeModel storageType = storageTypeService.findStorageTypeById(id);
        model.addAttribute("storageTypes", storageType != null ? List.of(storageType) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "storageTypeList";
    }

    @GetMapping("/searchByName")
    public String searchStorageTypeByName(@RequestParam String typeName, Model model) {
        List<StorageTypeModel> storageTypes = storageTypeService.findStorageTypeByName(typeName);
        model.addAttribute("storageTypes", storageTypes != null ? storageTypes : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "storageTypeList";
    }
}