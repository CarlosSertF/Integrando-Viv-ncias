package br.com.integrandovivencias.api.service;

import br.com.integrandovivencias.api.dto.PacienteRequestDTO;
import br.com.integrandovivencias.api.dto.PacienteResponseDTO;
import br.com.integrandovivencias.api.model.Paciente;
import br.com.integrandovivencias.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

   
    public List<PacienteResponseDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(PacienteResponseDTO::new)
                .toList();
    }

 
    public PacienteResponseDTO cadastrar(PacienteRequestDTO dados) {
        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(dados.nome());
        novoPaciente.setDataNascimento(dados.dataNascimento());
        repository.save(novoPaciente);
        return new PacienteResponseDTO(novoPaciente);
    }
}