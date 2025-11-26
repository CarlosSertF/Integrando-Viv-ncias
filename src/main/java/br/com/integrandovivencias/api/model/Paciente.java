package br.com.integrandovivencias.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente") 
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Responsavel> responsaveis = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<InfoEscolar> historicoEscolar = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Anamnese> anamneses = new ArrayList<>();



    // Construtor 
    public Paciente() {
    }



    // Getters e Setters 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public List<InfoEscolar> getHistoricoEscolar() {
        return historicoEscolar;
    }

    public void setHistoricoEscolar(List<InfoEscolar> historicoEscolar) {
        this.historicoEscolar = historicoEscolar;
    }

    public List<Anamnese> getAnamneses() { return anamneses; }
    public void setAnamneses(List<Anamnese> anamneses) { this.anamneses = anamneses; }



    // ToString pra aparecer bonitinho no console
    @Override
    public String toString() {
        return "Paciente{id=" + id + ", nome='" + nome + "'}";
    }


}