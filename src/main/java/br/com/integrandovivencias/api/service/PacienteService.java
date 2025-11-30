package br.com.integrandovivencias.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integrandovivencias.api.dto.PacienteRequestDTO;
import br.com.integrandovivencias.api.dto.PacienteResponseDTO;
import br.com.integrandovivencias.api.model.Paciente;
import br.com.integrandovivencias.api.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public PacienteResponseDTO cadastrar(PacienteRequestDTO dados) {
        // Criamos o paciente usando o SEU construtor.
        // LocalDate.now() pega a data de hoje para o cadastro automaticamente.
        Paciente novoPaciente = new Paciente(
            LocalDate.now(),          // data_cadastro
            dados.data_nascimento(),  // data_nascimento
            dados.nome()              // nome
        );

        repository.save(novoPaciente);
        return new PacienteResponseDTO(novoPaciente);
    }

    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(PacienteResponseDTO::new)
                .toList();
    }
}