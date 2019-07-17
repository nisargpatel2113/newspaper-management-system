/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newspaper.model.UnitPrice;

/**
 * @author tarkhand
 *
 */
public interface UnitPriceRepository extends PagingAndSortingRepository<UnitPrice, Long> {

}
