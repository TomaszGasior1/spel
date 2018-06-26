package com.tomaszgasior.spring.spel;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class OffersDAO {
	
	private JdbcTemplate jdbc;
	
	
	
	public void setDataSource(DataSource jdbc) {
		this.jdbc = jdbc;
	}



	public List<Offer> getOffers(){
		return null;
	}

}
