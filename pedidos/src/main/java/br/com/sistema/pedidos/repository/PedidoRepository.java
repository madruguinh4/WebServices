package br.com.sistema.pedidos.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.pedidos.model.Pedido;

@Repository
public interface PedidoRepository extends  CrudRepository<Pedido, Integer>{

	public List<Pedido> findByDataCadastro(LocalDate dataCadastro);
	public List<Pedido> findByIdCliente(Integer id);
	
}
