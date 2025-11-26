package br.com.integrandovivencias.api.dto;

import br.com.integrandovivencias.api.model.Paciente;
import java.time.LocalDate;

public record PacienteResponseDTO(
    Long id,
    String nome,
    LocalDate dataNascimento
) {
    public PacienteResponseDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getDataNascimento());
    }
}