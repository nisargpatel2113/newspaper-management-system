package com.newspaper.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspaper.model.Users;

@RepositoryRestResource(collectionResourceRel = "users", path = "users", exported = true)
@CrossOrigin(allowCredentials = "false", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH })
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
	@Query(value = "SELECT users FROM Users users WHERE users.username = ?1")
	public Users findByUsername(String username);
}
