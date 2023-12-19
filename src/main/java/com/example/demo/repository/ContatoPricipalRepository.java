package com.example.demo.repository;

import com.example.demo.model.ContatoPrincipalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoPricipalRepository extends JpaRepository<ContatoPrincipalModel, Long> {

    @Query(value = "SELECT c" +
                   " FROM ContatoPrincipalModel c" +
                   " WHERE c.id = :id")
    List<ContatoPrincipalModel> consultaPorId(@Param("id") Long id);

}
