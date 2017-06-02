package br.com.sistema.pedidos.service;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.pedidos.model.Pedido;
import br.com.sistema.pedidos.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositoryPedido;
	
	
	public void save(Pedido pedido){
		repositoryPedido.save(pedido);
	}
	
	public Iterable<Pedido> listarTodos(){
		return repositoryPedido.findAll();
	}
	
	public Pedido buscaPorNumeroControle(Integer numeroControle){
		return  repositoryPedido.findOne(numeroControle);
	}
	
	public List<Pedido> buscaPorIdCliente(Integer idCliente){
		return repositoryPedido.findByIdCliente(idCliente);
	}
	
	public List<Pedido> buscaPorData(LocalDate localDate){
		return repositoryPedido.findByDataCadastro(localDate);
	}
	
	public void delete(Integer id){
		repositoryPedido.delete(id);
	}
	
	
}
