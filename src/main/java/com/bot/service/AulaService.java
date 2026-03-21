package com.bot.service;

import com.bot.dto.AulaResponseDTO;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AulaService {

    private final Map<String, AulaResponseDTO> bancoDeDadosMock;

    public AulaService() {
        bancoDeDadosMock = new HashMap<>();
        
        // Populando o banco mockado com as matrículas e aulas
        bancoDeDadosMock.put("12345", new AulaResponseDTO(
            true, "Análise e Desenvolvimento de Sistemas", "Bloco B - Sala 204", 
            "Prof. Roberto", "19:00:00.00", "20:40:00.00"
        ));

        bancoDeDadosMock.put("67890", new AulaResponseDTO(
            true, 
            "Banco de Dados", 
            "Laboratório de Informática 1", 
            "Profa. Fernanda", 
            "20:50:00.00", 
            "22:30:00.00"
        ));
    }

    public AulaResponseDTO buscarAulaPorMatricula(String matricula) {
        // Se a matrícula existir no Map, retorna a aula. Se não, retorna que não tem aula.
        if (bancoDeDadosMock.containsKey(matricula)) {
            return bancoDeDadosMock.get(matricula);
        } else {
            return new AulaResponseDTO(false, "Nenhuma aula encontrada para esta matrícula neste momento.");
        }
    }
}