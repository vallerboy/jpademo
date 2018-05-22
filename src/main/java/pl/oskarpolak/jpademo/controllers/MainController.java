package pl.oskarpolak.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.jpademo.models.BarcodeEntity;
import pl.oskarpolak.jpademo.models.forms.BarcodeForm;
import pl.oskarpolak.jpademo.models.repositories.BarcodeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository; // = new BarcodeRepostitory();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("barcodeForm", new BarcodeForm());
        //model.addAttribute("allBarcodes", barcodeRepository.findByBarcodeMatchesAndWeightIsGreaterThanEqual(".*(1|2).*", 10));
        return "addBarcode";
    }

    @PostMapping("/")
    public String index(@ModelAttribute BarcodeForm barcodeForm){
        BarcodeEntity barcodeEntity = new BarcodeEntity(barcodeForm);
        barcodeRepository.save(barcodeEntity);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        List<BarcodeEntity> barcodeEntityList = new ArrayList<>();
        barcodeEntityList.addAll(barcodeRepository.findAllByProductCompanyContains(search));
        barcodeEntityList.addAll(barcodeRepository.findAllByProductNameContains(search));

        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes", barcodeEntityList);
        return "addBarcode";
    }


}
