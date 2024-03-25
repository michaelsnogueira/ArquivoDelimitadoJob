package com.springbatch.arquivodelimitado.gateway.repository;

import com.springbatch.arquivodelimitado.gateway.entity.Pendencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendenciaRepository extends JpaRepository<Pendencia, Long> {

}
