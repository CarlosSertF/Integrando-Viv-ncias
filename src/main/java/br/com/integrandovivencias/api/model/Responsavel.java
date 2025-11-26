package br.com.integrandovivencias.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "responsavel")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String telefone; 
    private String relacao;  
    private String email;

   
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;



    // Construtores
    public Responsavel() {}



    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getRelacao() { return relacao; }
    public void setRelacao(String relacao) { this.relacao = relacao; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}