package br.com.integrandovivencias.api.repository;

import br.com.integrandovivencias.api.model.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
}