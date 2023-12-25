package com.example.bvnk_client_service.populator;

import org.hibernate.query.sqm.sql.ConversionException;
import org.springframework.stereotype.Component;


@Component
public interface Populator {

	/**
 * Populates the properties of the target object from the properties of the source object.
 *
 * @param source the source object
 * @param target the target object
 * @throws ConversionException if there is an error during the population process
 */
void populate(Object source, Object target) throws ConversionException;
}
