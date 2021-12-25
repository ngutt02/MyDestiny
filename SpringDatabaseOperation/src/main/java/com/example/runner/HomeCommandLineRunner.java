package com.example.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.entity.Passenger;
import com.example.repository.PassengerRepository;
@Component
public class HomeCommandLineRunner implements CommandLineRunner {

	@Autowired
	ApplicationContext container;
	@Override
	public void run(String... args) throws Exception {
		PassengerRepository repo=(PassengerRepository)container.getBean("passengerRepository");

		Optional<Passenger> opt=repo.findById(1243);
		Passenger passenger=opt.get();
		System.out.println(passenger);
		
		/*List<Passenger> psList=repo.findAll();
		psList.forEach(p1->System.out.println(p1));*/

		/*Passenger p=repo.findByEmialId("abc@gmail.com");
		System.out.println(p);*/

		/*List<Passenger> list=repo.getPassengerBetweenSeatNumber(780, 789);
                list.forEach(p2->System.out.println(p2)); */


		/*List<Passenger> list2=repo.byFirstName();

		list2.forEach(p3->System.out.println(p3)); */


		/*List<Passenger> list3=repo.byLastName();
		list3.forEach(p4->System.out.println(p4));*/


		List<Passenger> list4=repo.byEmailId("abc@gmail.com");
		list4.forEach(p5->System.out.println(p5));


		/*List<Passenger> list5=repo.byEmailId1();
		list5.forEach(p6->System.out.println(p6));*/

		/*List<Passenger> list6=repo.getPassengerByFirstName("goshling","james");
		list6.forEach(p7->System.out.println(p7));*/

		/*List<Passenger>  list7=repo.findByFirstNameLike("james");
		list7.forEach(p8->System.out.println(p8));*/

		/*List<Passenger> list8=repo.findByFirstNameStartingWith("ja");
		list8.forEach(p9->System.out.println(p9));*/
		
		/*List<Passenger> list9=repo.findByEmialIdContaining("gmail");
		list9.forEach(p10->System.out.println(p10));*/
	}

}
