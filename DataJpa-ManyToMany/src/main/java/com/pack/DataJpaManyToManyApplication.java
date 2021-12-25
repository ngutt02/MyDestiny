package com.pack;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.pack.entity.Author;
import com.pack.entity.Book;
import com.pack.repository.BookRepository;

@SpringBootApplication
public class DataJpaManyToManyApplication implements CommandLineRunner {

	
	@Autowired
	DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(DataJpaManyToManyApplication.class, args);
	}

	@Autowired
	private ApplicationContext container;
	public void run(String... args) throws Exception {
		BookRepository bookRepo=(BookRepository)container.getBean("bookRepository");

		/*Book book1=new Book(1,"Java");
		Book book2=new Book(2,"Oracle");
		Book book3=new Book(3,"Python");


		Author author1=new Author(101,"A");
		Author author2=new Author(102,"B");
		Author author3=new Author(103,"C");

		Set<Author> authorSet1=new HashSet<Author>();
		authorSet1.add(author1);
		authorSet1.add(author2);

		Set<Author> authorSet2=new HashSet<Author>();
		authorSet2.add(author1);
		authorSet2.add(author2);
		authorSet2.add(author3);

		Set<Author> authorSet3=new HashSet<Author>();
		authorSet3.add(author2);
		authorSet3.add(author3);

		book1.setAuthors(authorSet1);
        book2.setAuthors(authorSet2);	
        book3.setAuthors(authorSet3);

        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);*/
		Set<Author> authorSet3=new HashSet<Author>();
		/*authorSet3.add(author2);
		authorSet3.add(author3);
		 */
		Book book3=new Book(3,"Python");

		Author author4=new Author(104,"D");

		authorSet3.add(author4);
		book3.setAuthors(authorSet3);
		bookRepo.save(book3);
		System.out.println("Datasource:"+dataSource);
	

	}

}
