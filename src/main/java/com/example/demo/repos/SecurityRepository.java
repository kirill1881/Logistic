package com.example.demo.repos;

import com.example.demo.models.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SecurityRepository extends CrudRepository<Security, String> {

    @Query
    Optional<Security> findFirstByUsername(@Param("username") String username);
}
