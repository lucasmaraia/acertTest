package com.lucas.test.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.test.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
