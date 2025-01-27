package com.kardec.clinica.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT m FROM Medico m " +
            "WHERE m.ativo = true " +
            "AND m.especialidade = :especialidade " +
            "AND m.id NOT IN (SELECT c.medico.id FROM Consulta c " +
            "WHERE c.data = :data)")
    List<Medico> buscarMedicosLivres(@Param("especialidade") Especialidade especialidade, @Param("data") @NotNull @Future LocalDateTime data);


}
