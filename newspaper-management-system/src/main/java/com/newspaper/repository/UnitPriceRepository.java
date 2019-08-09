/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspaper.model.UnitPrice;

/**
 * @author tarkhand
 *
 */
@RepositoryRestResource(collectionResourceRel = "unit-price", path = "unit-price", exported = true)
@CrossOrigin(allowCredentials = "false", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH })
public interface UnitPriceRepository extends PagingAndSortingRepository<UnitPrice, Long> {

}
