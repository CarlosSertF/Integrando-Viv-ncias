package br.com.integrandovivencias.api.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true) 
    private String email;

    @Column(nullable = false)
    private String senha;

    private String cargo; 



    // RELACIONAMENTO
    @OneToMany(mappedBy = "usuario")
    private List<Anamnese> anamneses = new ArrayList<>();



    // Construtor Vazio
    public Usuario() {
    }



    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public List<Anamnese> getAnamneses() { return anamneses; }
    public void setAnamneses(List<Anamnese> anamneses) { this.anamneses = anamneses; }
}