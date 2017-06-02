package br.com.sistema.pedidos.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="cliente")
public class Cliente {

	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	
	public Cliente() {

	}

	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	} 
	
	public Integer getId(){
		return this.id;
	}	
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome +  "]";
	}

	
	
	
	
}
