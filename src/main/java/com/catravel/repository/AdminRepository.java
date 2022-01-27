package com.catravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query(value = "SELECT * from admin WHERE email = :email AND password = :password", nativeQuery = true)
	public Admin findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}

