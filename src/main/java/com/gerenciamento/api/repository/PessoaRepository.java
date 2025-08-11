package com.gerenciamento.api.repository;

import com.gerenciamento.api.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, String> {
    List<PessoaEntity> findAllByActiveTrue();
}
