package com.example.demo.repos;

import com.example.demo.models.Calculation;
import com.example.demo.models.Security;
import org.springframework.data.repository.CrudRepository;

public interface CalculationRepository extends CrudRepository<Calculation, String> {

}
