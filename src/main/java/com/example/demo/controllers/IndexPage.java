package com.example.demo.controllers;

import com.example.demo.components.SendMail;
import com.example.demo.configs.MailCongig;
import com.example.demo.models.Calculation;
import com.example.demo.repos.CalculationRepository;
import com.example.demo.serviese.CountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexPage {

    @Autowired
    CountService countService;

    @Autowired
    CalculationRepository calculationRepository;

    @Autowired
    SendMail sendMail;



    @GetMapping("/")
    String index() {
        return "index.html";
    }

    @RequestMapping( value = "/", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public RedirectView setData(@RequestParam String theme, @RequestParam String weight,
                                @RequestParam String volume,@RequestParam("file") MultipartFile file) throws IOException {
        double priceVolume = countService.getPriceByVolume(volume);
        double priceWeight = countService.getPriceByWeight(weight);
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MailCongig.class);
        Iterable<Calculation> i = calculationRepository.findAll();
        List<Calculation> list = new ArrayList<>();
        i.forEach(list::add);
        long id = Long.parseLong(list.get(list.size()-1).getUsername())+1;
        sendMail.sendMail(id, file);
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
