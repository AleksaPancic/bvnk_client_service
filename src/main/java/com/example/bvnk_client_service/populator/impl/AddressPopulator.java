package com.example.bvnk_client_service.populator.impl;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.populator.Populator;
import org.hibernate.query.sqm.sql.ConversionException;
import org.springframework.stereotype.Component;


@Component
public class AddressPopulator implements Populator<Address, Address> {

	@Override
	public void populate(final Address source, Address target) throws ConversionException {
		target.setCity(source.getCity());
		target.setStreet(source.getStreet());
		target.setState(source.getState());
		target.setCountry(source.getCountry());
		target.setZip(source.getZip());
	}

}
