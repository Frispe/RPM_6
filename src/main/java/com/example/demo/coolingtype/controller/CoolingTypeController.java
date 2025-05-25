package com.example.demo.coolingtype.controller;

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
@RequestMapping("/coolingTypeList")
public class CoolingTypeController {

    private final CoolingTypeService coolingTypeService;

    @Autowired
    public CoolingTypeController(CoolingTypeService coolingTypeService) {
        this.coolingTypeService = coolingTypeService;
    }

    @GetMapping
    public String getAllCoolingTypes(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<CoolingTypeModel> coolingTypes = coolingTypeService.findCoolingTypesWithPagination(page, size);
        model.addAttribute("coolingTypes", coolingTypes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) coolingTypeService.findAllCoolingTypes().size() / size));
        return "coolingTypeList";
    }

    @PostMapping("/add")
    public String addCoolingType(@RequestParam String name) {
        CoolingTypeModel newCoolingType = new CoolingTypeModel(null, name);
        coolingTypeService.addCoolingType(newCoolingType);
        return "redirect:/coolingTypeList?page=0";
    }

    @PostMapping("/update")
    public String updateCoolingType(@RequestParam Long id,
                                    @RequestParam String name) {
        if (id != null && coolingTypeService.findCoolingTypeById(id) != null) {
            CoolingTypeModel updatedCoolingType = new CoolingTypeModel(id, name);
            coolingTypeService.updateCoolingType(updatedCoolingType);
        }
        return "redirect:/coolingTypeList?page=0";
    }

    @PostMapping("/delete")
    public String deleteCoolingType(@RequestParam Long id) {
        coolingTypeService.deleteCoolingType(id);
        return "redirect:/coolingTypeList?page=0";
    }

    @GetMapping("/searchById")
    public String searchCoolingTypeById(@RequestParam Long id, Model model) {
        CoolingTypeModel coolingType = coolingTypeService.findCoolingTypeById(id);
        model.addAttribute("coolingTypes", coolingType != null ? List.of(coolingType) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "coolingTypeList";
    }

    @GetMapping("/searchByName")
    public String searchCoolingTypeByName(@RequestParam String name, Model model) {
        CoolingTypeModel coolingType = coolingTypeService.findCoolingTypeByName(name);
        model.addAttribute("coolingTypes", coolingType != null ? List.of(coolingType) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "coolingTypeList";
    }
}