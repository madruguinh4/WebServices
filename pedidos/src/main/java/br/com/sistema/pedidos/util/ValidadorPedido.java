package br.com.sistema.pedidos.util;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sistema.pedidos.model.Pedido;
import br.com.sistema.pedidos.repository.PedidoRepository;
import br.com.sistema.pedidos.service.PedidoService;

public class ValidadorPedido {
	
	@Autowired
	private PedidoService pedidoService;
	
	public void validaDadosObjeto(Pedido pedido){
	
		pedido.setQuantidade(validaQuantidade(pedido.getQuantidade()));
		pedido.setDataCadastro(validaData(pedido.getDataCadastro()));
		pedido.setValor(validaDesconto(pedido.getQuantidade(), pedido.getValor()));
		
	}
	
	public Integer validaQuantidade(int quantidade){
		if(quantidade == 0){
			quantidade = 1;
		}
	return quantidade;
	}
	
	public LocalDate validaData(LocalDate data){
		
		if(data == null){
			data = LocalDate.now();
		}
		return data;
	}
	
	public boolean isRepetido(Integer numeroControle){
		boolean numeroRepetido = false;
		
		Pedido pedido = pedidoService.buscaPorNumeroControle(numeroControle);
		if(pedido != null){
			numeroRepetido = true;
		}
		
		return numeroRepetido;
	}
	
	
	
	public BigDecimal validaDesconto(Integer quantidade, BigDecimal valor){
		
		BigDecimal descontoFinal = new BigDecimal("0");
		BigDecimal descontoInicial = new BigDecimal("1"); 
		
		if(quantidade < 5)
			return valor;
		
		if(quantidade >= 5 && quantidade <= 9.0){
			descontoInicial = new BigDecimal("0.05");
		}
		else if(quantidade == 10)
		{
			descontoInicial = new BigDecimal("0.10");
		}
		
		descontoFinal = valor.multiply(descontoInicial);
		valor = valor.subtract(descontoFinal);
		
		return valor;
	}
	
}
