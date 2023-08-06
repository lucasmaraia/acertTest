package com.lucas.test.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.test.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
