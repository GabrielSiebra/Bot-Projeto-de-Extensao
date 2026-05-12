package com.bot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AlunoRequestDTO {

    @NotBlank(message = "A matrícula é obrigatória.")
    @Pattern(regexp = "^1-\\d+$", message = "Formato inválido. A matrícula deve começar com '1-' seguido de números.")
    private String matricula;

    // Construtor vazio padrão (boa prática)
    public AlunoRequestDTO() {
    }

    // Getter
    public String getMatricula() {
        return matricula;
    }

    // Setter
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}