package com.pack;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.entity.Passport;
import com.pack.entity.Person;
import com.pack.repository.PassportRepository;

@SpringBootApplication
public class DataJpaManyToOneWithPrimaryKeyApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext container;
	public static void main(String[] args) {
		SpringApplication.run(DataJpaManyToOneWithPrimaryKeyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PassportRepository passportRepo=(PassportRepository)container.getBean("passportRepository");
		Person p=new Person();
		p.setPersomId(101);
		p.setPersonName("Miller");
		Passport passport = new Passport();
		//passport.setPassportId(989);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date=simpleDateFormat.parse("12-01-1994");

		passport.setExpDate(date);
		passport.setPerson(p);
		passportRepo.save(passport);







	}

}
