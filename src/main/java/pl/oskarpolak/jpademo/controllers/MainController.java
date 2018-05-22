package pl.oskarpolak.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.jpademo.models.BarcodeEntity;
import pl.oskarpolak.jpademo.models.forms.BarcodeForm;
import pl.oskarpolak.jpademo.models.repositories.BarcodeRepository;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository; // = new BarcodeRepostitory();

    @GetMapping("/")
    @ResponseBody
    public String index(Model model) {
        model.addAttribute("barcodeForm", new BarcodeForm());
        return "addBarcode";
    }

}
