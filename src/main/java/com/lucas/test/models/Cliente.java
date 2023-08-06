package com.lucas.test.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String nome;
	private String cnpj;	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Cliente() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, nome, razaoSocial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(razaoSocial, other.razaoSocial);
	}
	
	
	public Cliente(Long id, String razaoSocial, String nome, String cnpj) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	

}
