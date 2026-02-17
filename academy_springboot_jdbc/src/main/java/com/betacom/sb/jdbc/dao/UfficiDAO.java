package com.betacom.sb.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.sb.jdbc.models.Uffici;

@Repository
public class UfficiDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	

	public UfficiDAO(DataSource datasource) {
		
		this.jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	// select without params
	public List<Uffici> getUffici(){
		return jdbcTemplate.query("select * from uffici", BeanPropertyRowMapper.newInstance(Uffici.class));
	}
	
	// select with Id
	public List<Uffici> getUfficiById(Integer id){
		SqlParameterSource param = new MapSqlParameterSource("id", id); 
		
		String sql = "select * from uffici where id_ufficio =:id";
		
		return jdbcTemplate.query(sql, param, BeanPropertyRowMapper.newInstance(Uffici.class));
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int addUfficio(String nome) {
		SqlParameterSource param = new MapSqlParameterSource("nome", nome);
		
		String sql = "insert into uffici (nome_ufficio) values (:nome)";
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int i = jdbcTemplate.update(sql, param, keyHolder, new String[] {"nome_ufficio"});
		
		return keyHolder.getKey().intValue();
		
	}
	
	public int updateUfficio(int id, String nome) {
		SqlParameterSource param = new MapSqlParameterSource("nome", nome);
		
		String sql = "update uffici set nome_ufficio=:nome where id_ufficio = " +id;
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int i = jdbcTemplate.update(sql, param, keyHolder, new String[] {"nome_ufficio"});
		
		return id;
		
	}
	
	
}
