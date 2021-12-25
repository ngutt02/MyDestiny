package com.pack;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.entity.Passport;
import com.pack.entity.Person;
import com.pack.repository.PassportRepository;

@SpringBootApplication
public class DataJpaOneToOneApplication implements CommandLineRunner {

	
	@Autowired
	ApplicationContext container;
	public static void main(String[] args) {
		SpringApplication.run(DataJpaOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		PassportRepository passportRepo=(PassportRepository)container.getBean("passportRepository");
	    Passport passport=new Passport();
	    Person person=new Person();
	    person.setPersomId(10101);
	    person.setPersonName("Scott");
	    
	    passport.setPassportId(9911201);
	   try {
		   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		   java.util.Date expDate=sdf.parse("12-05-2020");
		   passport.setExpDate(expDate);
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	passport.setPerson(person);
	passportRepo.save(passport);
	}

}
