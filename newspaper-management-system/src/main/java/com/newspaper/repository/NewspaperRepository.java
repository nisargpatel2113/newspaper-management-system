/**
 * 
 */
package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newspaper.model.Newspaper;

/**
 * @author tarkhand
 *
 */
public interface NewspaperRepository extends PagingAndSortingRepository<Newspaper, Long> {

}
