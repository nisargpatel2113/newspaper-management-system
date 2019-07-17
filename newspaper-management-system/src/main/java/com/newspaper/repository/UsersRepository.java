package com.newspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.newspaper.model.Users;


@RepositoryRestResource(collectionResourceRel = "users", path = "users", exported = true)
public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query(value = "SELECT users FROM Users users WHERE users.username = ?1")
	public Users findByUsername(String username);
}
