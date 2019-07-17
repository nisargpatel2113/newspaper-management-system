/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.newspaper.model.Customer;

/**
 * @author nisargkp
 *
 */
@RepositoryRestResource(itemResourceRel = "customer", path = "customer", exported = true)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
