package com.example.bvnk_client_service.populator;

import org.hibernate.query.sqm.sql.ConversionException;


@Deprecated
public interface Populator<S, T> {
	void populate(S source, T target) throws ConversionException;

}
