package com.example.demo.controllers;

import com.example.demo.models.Calculation;
import com.example.demo.repos.CalculationRepository;
import com.example.demo.serviese.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexPage {

    @Autowired
    CountService countService;

    @Autowired
    CalculationRepository calculationRepository;

    @GetMapping("/")
    String index() {
        return "index.html";
    }
    @PostMapping
    public RedirectView setData(@RequestParam String theme, @RequestParam String weight,
                                @RequestParam String volume){
        double priceVolume = countService.getPriceByVolume(volume);
        double priceWeight = countService.getPriceByWeight(weight);
        Calculation calculation  = new Calculation();
        calculation.setTheme(theme);
        if (priceVolume>priceWeight){
            calculation.setPrice(priceVolume);
        }else {
            calculation.setPrice(priceWeight);
        }
        calculationRepository.save(calculation);
        return new RedirectView("/");
    }

}
