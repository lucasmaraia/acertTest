package com.lucas.test.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereco;
	@ManyToOne
	private Pedido pedido;
	private String descricao;
	
	public Entrega() {
		
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Entrega(Long id, String endereco, Pedido pedido, String descricao) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.pedido = pedido;
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descricao, endereco, id, pedido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(pedido, other.pedido);
	}
	
	
}
