package com.example.demo.repository;

import com.example.demo.model.ContatoMedicoModel;
import com.example.demo.model.ContatoPrincipalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoMedicoRepository extends JpaRepository<ContatoMedicoModel, Long> {

    @Query(value = "SELECT c" +
                   " FROM ContatoMedicoModel c" +
                   " WHERE c.id = :id")
    List<ContatoMedicoModel> consultaPorId(@Param("id") Long id);

}
