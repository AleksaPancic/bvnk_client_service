package com.example.bvnk_client_service.populator;

import org.hibernate.query.sqm.sql.ConversionException;


/**
 * Interface for populating a target object with data from a source object.
 *
 * @param <S> the type of the source object
 * @param <T> the type of the target object
 */
public interface Populator<S, T> {

	/**
	 * Populates the target object with data from the source object.
	 *
	 * @param source the source object
	 * @param target the target object
	 *
	 * @throws ConversionException if there is an error converting data
	 */
	void populate(S source, T target) throws ConversionException;

}
