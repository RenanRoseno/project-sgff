package com.spring.sgff.repository;

import com.spring.sgff.models.Ponto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
  @Query("SELECT p FROM Ponto p WHERE p.id_funcionario = ?1 AND data BETWEEN ?2 AND ?3")
  List<Ponto> getPontosFuncionario(long id_funcionario, LocalDate dataI, LocalDate dataF);
}
