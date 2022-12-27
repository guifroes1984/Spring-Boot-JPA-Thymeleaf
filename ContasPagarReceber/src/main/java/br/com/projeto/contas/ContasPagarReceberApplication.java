package br.com.projeto.contas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.projeto.contas"})
@ComponentScan(basePackages = {"br.*"})
@EnableJpaRepositories(basePackages = {"br.com.projeto.contas.repository"})
@EnableTransactionManagement
@EnableWebMvc
public class ContasPagarReceberApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ContasPagarReceberApplication.class, args);
	}

}
