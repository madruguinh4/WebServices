package br.com.sistema.pedidos.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.sistema.pedidos.util.DeserializadorBigDecimal;
import br.com.sistema.pedidos.util.SerializadorLocalDate;
import br.com.sistema.pedidos.util.DeserializadorLocalDate;
import br.com.sistema.pedidos.util.ConversorLocalDate;

@Entity(name="pedido")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="numero_controle",nullable=false)
	private Integer numeroControle;
	
	@Convert(converter = ConversorLocalDate.class)
	@JsonSerialize(using=SerializadorLocalDate.class)
	@JsonDeserialize(using = DeserializadorLocalDate.class)
	@Column(name= "data_cadastro", columnDefinition = "DATETIME" ,nullable = true)
	private LocalDate dataCadastro;
	
	@Column(name= "nome_produto", nullable = false)
	private String nomeProduto;
	
	@JsonDeserialize(using = DeserializadorBigDecimal.class)
	@Column(name="valor_monetario_produto",nullable = false)
	private BigDecimal valorMonetarioProduto;
	
	@Column(name="quantidade_produto",nullable = true)
	private Integer quantidadeProduto;
	
	@Column(name="id_cliente")
	private Integer idCliente;
	
	public Pedido() {

	}

	public Pedido(Integer numeroControle, LocalDate dataCadastro, String nome, BigDecimal valor, Integer quantidade,
			Integer idCliente) {
		super();
		this.numeroControle = numeroControle;
		this.dataCadastro = dataCadastro;
		this.nomeProduto = nome;
		this.valorMonetarioProduto = valor;
		this.quantidadeProduto = quantidade;
		this.idCliente = idCliente;
	}

	public Integer getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nomeProduto;
	}

	public void setNome(String nome) {
		this.nomeProduto = nome;
	}

	public BigDecimal getValor() {
		return valorMonetarioProduto;
	}

	public void setValor(BigDecimal valor) {
		this.valorMonetarioProduto = valor;
	}

	public Integer getQuantidade() {
		return quantidadeProduto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidadeProduto = quantidade;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public String toString() {
		return "Pedido [numeroControle=" + numeroControle + ", dataCadastro=" + dataCadastro + ", nome=" + nomeProduto
				+ ", valor=" + valorMonetarioProduto + ", quantidade=" + quantidadeProduto + ", id cliente=" + idCliente + "]";
	}
	
	
}
