package com.lucas.test.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.test.models.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
