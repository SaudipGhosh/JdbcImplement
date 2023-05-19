package com.SpringDataJdbc.JdbcImplement;

import com.SpringDataJdbc.JdbcImplement.Repositary.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcImplementApplication implements CommandLineRunner {

	@Autowired
	EmpRepo empRepo;
	public static void main(String[] args) {
		SpringApplication.run(JdbcImplementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.empRepo.createTable());

	}
}


