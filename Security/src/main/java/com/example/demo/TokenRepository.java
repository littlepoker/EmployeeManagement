package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer>{
	@Query(value = "from Token t inner join Employee e on t.employee.id = e.id where e.id = :id and (t.valid = true)")
	List<Token> findAllValidTokenByUsers(int id);

	Optional<Token> findByToken(String jwtToken);
	
	@Query (value = "delete from Token t where t.employee.id = :id")
	void deleteByUserId(int id);
}
