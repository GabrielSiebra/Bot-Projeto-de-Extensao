package com.bot.dto;

public class AulaResponseDTO {
    private boolean temAula;
    private String disciplina;
    private String sala;
    private String professor;
    private String horarioInicio;
    private String horarioFim;
    private String mensagem;

    public AulaResponseDTO(boolean temAula, String disciplina, String sala, String professor, String horarioInicio, String horarioFim) {
        this.temAula = temAula;
        this.disciplina = disciplina;
        this.sala = sala;
        this.professor = professor;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public AulaResponseDTO(boolean temAula, String mensagem) {
        this.temAula = temAula;
        this.mensagem = mensagem;
    }

    public boolean isTemAula() { return temAula; }
    public String getDisciplina() { return disciplina; }
    public String getSala() { return sala; }
    public String getProfessor() { return professor; }
    public String getHorarioInicio() { return horarioInicio; }
    public String getHorarioFim() { return horarioFim; }
    public String getMensagem() { return mensagem; }
}