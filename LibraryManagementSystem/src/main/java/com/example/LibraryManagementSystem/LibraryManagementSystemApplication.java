package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class LibraryManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		///Why not here because AuthorRepository is non static and cannot use non static in static thus different and Autowire variable cannot be static
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception{
		System.out.println("In from function of main class");
		//List<Author> authorList = authorRepository.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(30, "India", "ps");
		//authorList.forEach(x->System.out.println(x.getName()));
	}
}
