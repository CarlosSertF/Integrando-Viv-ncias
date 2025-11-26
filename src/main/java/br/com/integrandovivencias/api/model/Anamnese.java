package br.com.integrandovivencias.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anamnese")
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_realizacao")
    private LocalDateTime dataRealizacao = LocalDateTime.now(); 

    
    @Column(columnDefinition = "TEXT") 
    private String queixaAtual;

    private boolean temLaudo;
    
    @Column(columnDefinition = "TEXT")
    private String descricaoLaudo;

    private boolean tomaMedicacao;
    
    @Column(columnDefinition = "TEXT")
    private String descricaoMedicacao;

    private boolean fazAcompanhamento;
    
    @Column(columnDefinition = "TEXT")
    private String descricaoAcompanhamento;

    private boolean temDificuldadeFala;
    
    @Column(columnDefinition = "TEXT")
    private String preferenciasBrincadeiras;


    
    // RELACIONAMENTOS 
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // Quem criou a ficha
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



    // Construtor 
    public Anamnese() {
    }



    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(LocalDateTime dataRealizacao) { this.dataRealizacao = dataRealizacao; }

    public String getQueixaAtual() { return queixaAtual; }
    public void setQueixaAtual(String queixaAtual) { this.queixaAtual = queixaAtual; }

    public boolean isTemLaudo() { return temLaudo; }
    public void setTemLaudo(boolean temLaudo) { this.temLaudo = temLaudo; }

    public String getDescricaoLaudo() { return descricaoLaudo; }
    public void setDescricaoLaudo(String descricaoLaudo) { this.descricaoLaudo = descricaoLaudo; }

    public boolean isTomaMedicacao() { return tomaMedicacao; }
    public void setTomaMedicacao(boolean tomaMedicacao) { this.tomaMedicacao = tomaMedicacao; }

    public String getDescricaoMedicacao() { return descricaoMedicacao; }
    public void setDescricaoMedicacao(String descricaoMedicacao) { this.descricaoMedicacao = descricaoMedicacao; }

    public boolean isFazAcompanhamento() { return fazAcompanhamento; }
    public void setFazAcompanhamento(boolean fazAcompanhamento) { this.fazAcompanhamento = fazAcompanhamento; }

    public String getDescricaoAcompanhamento() { return descricaoAcompanhamento; }
    public void setDescricaoAcompanhamento(String descricaoAcompanhamento) { this.descricaoAcompanhamento = descricaoAcompanhamento; }

    public boolean isTemDificuldadeFala() { return temDificuldadeFala; }
    public void setTemDificuldadeFala(boolean temDificuldadeFala) { this.temDificuldadeFala = temDificuldadeFala; }

    public String getPreferenciasBrincadeiras() { return preferenciasBrincadeiras; }
    public void setPreferenciasBrincadeiras(String preferenciasBrincadeiras) { this.preferenciasBrincadeiras = preferenciasBrincadeiras; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}