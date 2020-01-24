package it.objectmethod.esempio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.esempio.dao.IDaoNazioni;

@Service
public class DaoNazioniAvanzato extends NamedParameterJdbcDaoSupport implements IDaoNazioni {

	@Autowired
	public DaoNazioniAvanzato(DataSource dataSource)
	{
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<String> getAllContinenti() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT DISTINCT co.Continent" + " FROM country co";
		list = getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

}
