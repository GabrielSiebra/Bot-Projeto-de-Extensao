package com.bot.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String matricula; // A matrícula é a chave de busca

    private String disciplina;
    private String sala;
    private String professor;
    private String horarioInicio;
    private String horarioFim;
    private boolean temAula;

    public Aula() {}

    // Getters
    public Long getId() { return id; }
    public String getMatricula() { return matricula; }
    public String getDisciplina() { return disciplina; }
    public String getSala() { return sala; }
    public String getProfessor() { return professor; }
    public String getHorarioInicio() { return horarioInicio; }
    public String getHorarioFim() { return horarioFim; }
    public boolean isTemAula() { return temAula; }

    // Setters (omitidos aqui por brevidade, mas você pode gerá-los no VSCode)
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
}