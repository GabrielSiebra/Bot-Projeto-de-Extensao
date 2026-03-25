package com.bot.service;

import com.bot.dto.AulaResponseDTO;
import com.bot.model.Aula;
import com.bot.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    // Injetando o repositório do banco de dados
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public AulaResponseDTO buscarAulaPorMatricula(String matricula) {
        // Busca a matrícula no banco de dados
        Optional<Aula> aulaEncontrada = aulaRepository.findByMatricula(matricula);

        // Se encontrou a aula para essa matrícula no banco:
        if (aulaEncontrada.isPresent()) {
            Aula aula = aulaEncontrada.get();
            return new AulaResponseDTO(
                aula.isTemAula(),
                aula.getDisciplina(),
                aula.getSala(),
                aula.getProfessor(),
                aula.getHorarioInicio(),
                aula.getHorarioFim()
            );
        } else {
            // Se a matrícula não existe no banco de dados:
            return new AulaResponseDTO(false, "Nenhuma aula encontrada para esta matrícula neste momento.");
        }
    }
}