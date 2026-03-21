package com.bot.controller;

import com.bot.dto.AulaResponseDTO;     // Importando o DTO
import com.bot.service.AulaService;     // Importando o Service
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bot")
@CrossOrigin(origins = "*")
public class AulaController {

    private final AulaService aulaService;

    // Injeção de dependência do Spring
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping("/consulta/{matricula}")
    public AulaResponseDTO consultarAula(@PathVariable String matricula) {
        return aulaService.buscarAulaPorMatricula(matricula);
    }
}