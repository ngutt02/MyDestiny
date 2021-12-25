package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

	Passenger findByEmialId(String emailId);
	@Query("select passenger from Passenger passenger where passenger.seatNumber between ?1 and ?2")
	List<Passenger> getPassengerBetweenSeatNumber(Integer s1,Integer s2);
	@Query(value="select * from passenger where last_name=:begin and first_name=:end ", nativeQuery=true)
	List<Passenger> getPassengerByFirstName(@Param("begin")String ln,@Param("end")String fn);
	List<Passenger> byFirstName();
	List<Passenger> byLastName();
	List<Passenger> byEmailId(@Param("begin")String email);
	List<Passenger> byEmailId1();
	List<Passenger> findByFirstNameLike(String s1);
	List<Passenger> findByFirstNameStartingWith(String s1);
	List<Passenger> findByEmialIdContaining(String email);
}
