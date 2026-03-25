package com.bot.repository;

import com.bot.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    
    // O Spring Boot cria a query SQL automaticamente lendo o nome deste método!
    Optional<Aula> findByMatricula(String matricula);
}