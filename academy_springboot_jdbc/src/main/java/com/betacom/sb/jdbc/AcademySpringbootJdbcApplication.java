package com.betacom.sb.jdbc;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.betacom.sb.jdbc.components.BusinessComponents;
import com.betacom.sb.jdbc.dao.UfficiDAO;
import com.betacom.sb.jdbc.models.Uffici;

@SpringBootApplication
public class AcademySpringbootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademySpringbootJdbcApplication.class, args);
	}
	
    //private final UfficiDAO jdbcClientRepository;
    
    private final BusinessComponents businessComp;

    public AcademySpringbootJdbcApplication (BusinessComponents businessComp)
    		//, UfficiDAO jdbcClientRepository) 
    {
        
        //this.jdbcClientRepository = jdbcClientRepository;
		this.businessComp = businessComp;
    }
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			/*List<Uffici> lU = jdbcClientRepository.getUffici();
			
			lU.forEach( u-> System.out.println(u) );*/
			
			businessComp.listUffici();
		};
	}

}
