package com.example.demo.powersupply.controller;

import com.example.demo.brand.model.BrandModel;
import com.example.demo.brand.service.BrandService;
import com.example.demo.powersupply.model.PowerSupplyModel;
import com.example.demo.powersupply.service.PowerSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/powerSupplyList")
public class PowerSupplyController {

    @Autowired
    private PowerSupplyService powerSupplyService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public String getAllPowerSupplies(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 10;
        List<PowerSupplyModel> powerSupplies = powerSupplyService.findPowerSuppliesWithPagination(page, size);
        List<BrandModel> brands = brandService.findAllBrands();

        model.addAttribute("powerSupplies", powerSupplies);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                (int) Math.ceil((double) powerSupplyService.findAllPowerSupplies().size() / size));
        return "powerSupplyList";
    }

    @PostMapping("/add")
    public String addPowerSupply(@RequestParam Long brandId,
                                 @RequestParam String model,
                                 @RequestParam int power,
                                 @RequestParam String certification,
                                 @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        PowerSupplyModel newPowerSupply = new PowerSupplyModel(0, brand, model, power, certification, price);
        powerSupplyService.addPowerSupply(newPowerSupply);
        return "redirect:/powerSupplyList?page=0";
    }

    @PostMapping("/update")
    public String updatePowerSupply(@RequestParam long id,
                                    @RequestParam Long brandId,
                                    @RequestParam String model,
                                    @RequestParam int power,
                                    @RequestParam String certification,
                                    @RequestParam double price) {
        BrandModel brand = brandService.findBrandById(brandId.intValue());
        PowerSupplyModel updatedPowerSupply = new PowerSupplyModel(id, brand, model, power, certification, price);
        powerSupplyService.updatePowerSupply(updatedPowerSupply);
        return "redirect:/powerSupplyList?page=0";
    }

    @PostMapping("/delete")
    public String deletePowerSupply(@RequestParam long id) {
        powerSupplyService.deletePowerSupply(id);
        return "redirect:/powerSupplyList?page=0";
    }

    @GetMapping("/searchById")
    public String searchPowerSupplyById(@RequestParam long id, Model model) {
        PowerSupplyModel powerSupply = powerSupplyService.findPowerSupplyById(id);
        model.addAttribute("powerSupplies", powerSupply != null ? List.of(powerSupply) : List.of());
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "powerSupplyList";
    }

    @GetMapping("/searchByModel")
    public String searchPowerSupplyByModel(@RequestParam String model, Model modelAttr) {
        PowerSupplyModel powerSupply = powerSupplyService.findPowerSupplyByModel(model);
        modelAttr.addAttribute("powerSupplies", powerSupply != null ? List.of(powerSupply) : List.of());
        modelAttr.addAttribute("currentPage", 0);
        modelAttr.addAttribute("totalPages", 1);
        return "powerSupplyList";
    }
}