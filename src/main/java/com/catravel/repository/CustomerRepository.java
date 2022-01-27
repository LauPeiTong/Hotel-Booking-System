package com.catravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query(value = "SELECT * from customer WHERE email = :email AND password = :password", nativeQuery = true)
	public Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query(value = "SELECT count(*) from customer WHERE email = :email", nativeQuery = true)
	public Integer findByEmail(@Param("email") String email);
	
	
}
