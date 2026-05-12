package com.bot.controller;

import com.bot.dto.AulaResponseDTO;
import com.bot.service.AulaService;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bot")
@CrossOrigin(origins = "*")
@Validated // 1. ESSENCIAL: Habilita a validação para parâmetros soltos como o @PathVariable
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping("/consulta/{matricula}")
    public AulaResponseDTO consultarAula(
            @PathVariable 
            @Pattern(regexp = "^1-\\d+$", message = "Formato de matrícula inválido.") // 2. Validação direto na String
            String matricula) {
            
        return aulaService.buscarAulaPorMatricula(matricula);
    }
}