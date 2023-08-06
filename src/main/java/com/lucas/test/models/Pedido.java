package com.lucas.test.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Descricao;
	@ManyToOne
	private Cliente cliente;
	private Double valor;
	
	public Pedido() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Descricao, cliente, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(Descricao, other.Descricao) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(id, other.id) && Objects.equals(valor, other.valor);
	}

	public Pedido(Long id, String descricao, Cliente cliente, Double valor) {
		this.id = id;
		Descricao = descricao;
		this.cliente = cliente;
		this.valor = valor;
	}
	
	
}
