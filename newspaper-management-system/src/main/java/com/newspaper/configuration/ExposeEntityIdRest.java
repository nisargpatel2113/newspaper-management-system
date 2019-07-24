/**
 * 
 */
package com.newspaper.configuration;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author nisargkp
 *
 */
@Component
public class ExposeEntityIdRest implements RepositoryRestConfigurer {

	@Autowired
    private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
	{
		//Class<?>[] classListForExposeId = {Users.class,Subscription.class};
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
	}
}
