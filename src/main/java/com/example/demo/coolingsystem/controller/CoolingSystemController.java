package com.example.demo.coolingsystem.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.coolingsystem.model.CoolingSystemModel;
import com.example.demo.coolingsystem.service.CoolingSystemService;
import com.example.demo.coolingtype.model.CoolingTypeModel;
import com.example.demo.coolingtype.service.CoolingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/coolingSystemList")
public class CoolingSystemController {

    @Autowired
    private CoolingSystemService coolingSystemService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CoolingTypeService coolingTypeService;

    @GetMapping
    public String getAllCoolingSystems(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<CoolingSystemModel> coolingSystems = coolingSystemService.findCoolingSystemsWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();
        List<CoolingTypeModel> coolingTypes = coolingTypeService.findAllCoolingTypes();

        model.addAttribute("coolingSystems", coolingSystems);
        model.addAttribute("brands", brands);
        model.addAttribute("coolingTypes", coolingTypes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) coolingSystemService.findAllCoolingSystems().size() / size));
        return "coolingSystemList";
    }

    @PostMapping("/add")
    public String addCoolingSystem(@RequestParam long brandId,
                                   @RequestParam String model,
                                   @RequestParam long coolingTypeId,
                                   @RequestParam double price) {
        BrandModel brand = brandService.findBrandById((int)brandId);
        CoolingTypeModel coolingType = coolingTypeService.findCoolingTypeById(coolingTypeId);
        CoolingSystemModel newCoolingSystem = new CoolingSystemModel();
        newCoolingSystem.setBrand(brand);
        newCoolingSystem.setModel(model);
        newCoolingSystem.setCoolingType(coolingType);
        newCoolingSystem.setPrice(price);
        coolingSystemService.addCoolingSystem(newCoolingSystem);
        return "redirect:/coolingSystemList?page=0";
    }

    @PostMapping("/update")
    public String updateCoolingSystem(@RequestParam long id,
                                      @RequestParam long brandId,
                                      @RequestParam String model,
                                      @RequestParam long coolingTypeId,
                                      @RequestParam double price) {
        BrandModel brand = brandService.findBrandById((int)brandId);
        CoolingTypeModel coolingType = coolingTypeService.findCoolingTypeById(coolingTypeId);
        CoolingSystemModel updatedCoolingSystem = new CoolingSystemModel();
        updatedCoolingSystem.setId(id);
        updatedCoolingSystem.setBrand(brand);
        updatedCoolingSystem.setModel(model);
        updatedCoolingSystem.setCoolingType(coolingType);
        updatedCoolingSystem.setPrice(price);
        coolingSystemService.updateCoolingSystem(updatedCoolingSystem);
        return "redirect:/coolingSystemList?page=0";
    }

    @PostMapping("/delete")
    public String deleteCoolingSystem(@RequestParam long id) {
        coolingSystemService.deleteCoolingSystem(id);
        return "redirect:/coolingSystemList?page=0";
    }

    @GetMapping("/searchById")
    public String searchCoolingSystemById(@RequestParam long id, Model model) {
        CoolingSystemModel coolingSystem = coolingSystemService.findCoolingSystemById(id);
        model.addAttribute("coolingSystems", coolingSystem != null ? List.of(coolingSystem) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "coolingSystemList";
    }

    @GetMapping("/searchByModel")
    public String searchCoolingSystemByModel(@RequestParam String model, Model modelAttr) {
        CoolingSystemModel coolingSystem = coolingSystemService.findCoolingSystemByModel(model);
        modelAttr.addAttribute("coolingSystems", coolingSystem != null ? List.of(coolingSystem) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "coolingSystemList";
    }
}