package br.com.integrandovivencias.api.controller;

import br.com.integrandovivencias.api.dto.PacienteRequestDTO;
import br.com.integrandovivencias.api.dto.PacienteResponseDTO;
import br.com.integrandovivencias.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes") // Define que a URL base é: localhost:8080/pacientes
public class PacienteController {

    @Autowired
    private PacienteService service;

    // GET: Para buscar dados
    @GetMapping
    public List<PacienteResponseDTO> listar() {
        return service.buscarTodos();
    }

    // POST: Para enviar dados (cadastrar)
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrar(@RequestBody PacienteRequestDTO dados, UriComponentsBuilder uriBuilder) {
        PacienteResponseDTO pacienteSalvo = service.cadastrar(dados);

        // Cria a URL onde esse novo paciente pode ser encontrado (Boa prática REST)
        URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(pacienteSalvo.id()).toUri();

        // Retorna código 201 (Created)
        return ResponseEntity.created(uri).body(pacienteSalvo);
    }
}