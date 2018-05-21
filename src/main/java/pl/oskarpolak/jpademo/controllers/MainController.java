package pl.oskarpolak.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.jpademo.models.BarcodeEntity;
import pl.oskarpolak.jpademo.models.repositories.BarcodeRepository;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        BarcodeEntity barcodeEntity = new BarcodeEntity();
        barcodeEntity.setProductCompany("Fivarto");
        barcodeEntity.setProductName("Kolektor danych");
        barcodeEntity.setBarcode("1231231231239");
        barcodeEntity.setWeight(10);


        barcodeRepository.save(barcodeEntity);
        return "Poszło zapytanie";
    }

}
