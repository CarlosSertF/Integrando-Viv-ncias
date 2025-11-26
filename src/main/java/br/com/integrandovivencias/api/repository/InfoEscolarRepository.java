package br.com.integrandovivencias.api.repository;

import br.com.integrandovivencias.api.model.InfoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoEscolarRepository extends JpaRepository<InfoEscolar, Long> {
}