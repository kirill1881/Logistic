package com.example.demo.serviese;

import org.springframework.stereotype.Service;

@Service
public class CountService {
    public double getPriceByWeight (String weight){
        double weight1 = Double.parseDouble(weight);
        double resultPriceByWeight = weight1*0.702;
        return resultPriceByWeight;
    }

    public double getPriceByVolume (String volume){
        double volume1 = Double.parseDouble(volume);
        double resultPriceByVolume = volume1*216;
        return resultPriceByVolume;
    }

}
