package br.com.sistema.pedidos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.pedidos.model.Pedido;
import br.com.sistema.pedidos.service.PedidoService;
import br.com.sistema.pedidos.util.ValidadorPedido;
@RequestMapping("/pedido")
@RestController
public class PedidosController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ValidadorPedido validador;
	
	
	@RequestMapping(value = "/cadastrarPedido", method = RequestMethod.POST)
	public ResponseEntity salvar(@RequestBody Pedido[] listaPedidos){
		
		if(listaPedidos.length <= 10){
			
			for(Pedido pedido : listaPedidos){
				if(!validador.isRepetido(pedido.getNumeroControle())){
						validador.validaDadosObjeto(pedido);
						pedidoService.save(pedido);
				}
				else{
					return new ResponseEntity<String>("Erro: Produto com esse ID já esta cadastrado", HttpStatus.CONFLICT);
				}
				
			}
		}
		else
		{
			return new ResponseEntity<String>("Erro: Quantidade de pedidos maior do que 10", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("Pedido Cadastrado com sucesso!", HttpStatus.CREATED);
	}
	

	@RequestMapping(value= "/listarTodos" , method= RequestMethod.GET) 
	public ResponseEntity<Iterable<Pedido>> listarTodos() {
		return new ResponseEntity< Iterable<Pedido> >(pedidoService.listarTodos(),HttpStatus.OK); 
	}
	
	@RequestMapping(value="/busca/numeroControle/{numControle}", method = RequestMethod.GET) 
	public ResponseEntity <Pedido> buscaPorNumControle(@PathVariable Integer numControle) {
		return new ResponseEntity< Pedido >(pedidoService.buscaPorNumeroControle(numControle), HttpStatus.OK);
	}
	
	@RequestMapping(value="/busca/IdCliente/{id_cliente}", method =RequestMethod.GET) 
	public ResponseEntity <List<Pedido>> buscaPorID(@PathVariable Integer id_cliente) {
		return new ResponseEntity< List<Pedido> >(pedidoService.buscaPorIdCliente(id_cliente), HttpStatus.OK);
	}
	
	@RequestMapping(value="/busca/data/{data}", method =RequestMethod.GET) 
	public ResponseEntity <List<Pedido>> buscaPorData(@PathVariable @DateTimeFormat(pattern = "ddMMyyyy") LocalDate data) {
		return new ResponseEntity< List<Pedido> >(pedidoService.buscaPorData(data), HttpStatus.OK);
	}
	
}
