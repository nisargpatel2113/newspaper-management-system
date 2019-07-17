package com.newspaper.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newspaper.model.NewspaperType;

/**
 * @author tarkhand
 *
 */
public interface NewspaperTypeRepository extends PagingAndSortingRepository<NewspaperType, Long> {

}
