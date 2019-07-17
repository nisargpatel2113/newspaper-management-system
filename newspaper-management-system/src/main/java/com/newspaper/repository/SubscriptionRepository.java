/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.newspaper.model.Subscription;

/**
 * @author nisargkp
 *
 */
@RepositoryRestResource(itemResourceRel = "subscription", path = "subscription", exported = true)
public interface SubscriptionRepository extends PagingAndSortingRepository<Subscription, Long> {

}
