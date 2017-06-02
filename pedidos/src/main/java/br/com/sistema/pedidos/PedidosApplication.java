package br.com.sistema.pedidos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.sistema.pedidos.controller.PedidosController;
import br.com.sistema.pedidos.service.PedidoService;
import br.com.sistema.pedidos.util.ValidadorPedido;


@SpringBootApplication
public class PedidosApplication {
	
	@Bean
	public ValidadorPedido validadorPedido(){
		return new ValidadorPedido();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}
}
