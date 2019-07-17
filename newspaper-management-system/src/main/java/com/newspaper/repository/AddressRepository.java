/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.newspaper.model.Address;

/**
 * @author nisargkp
 *
 */

@RepositoryRestResource(itemResourceRel = "address", path = "address", exported = true)
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
