package com.betacom.sb.jdbc.components;

import java.util.List;

import org.springframework.stereotype.Component;

import com.betacom.sb.jdbc.dao.UfficiDAO;
import com.betacom.sb.jdbc.models.Uffici;

@Component
public class BusinessComponents {

	
	private final UfficiDAO uDao;
	
	public BusinessComponents(UfficiDAO uDao) {
		this.uDao= uDao;
	}
	
	public void listUffici() {
		
		List<Uffici> lU = uDao.getUffici(); 
		lU.forEach( u-> System.out.println(u) );
		
		lU = uDao.getUfficiById(3);
		lU.forEach( u-> System.out.println(u));
		
		int id =uDao.addUfficio("prova");
		System.out.println("id generato= " + id);
		
		int updateUfficio = uDao.updateUfficio(id, "Nome Aggiornato");
		System.out.println("updateUfficio "+ updateUfficio);
		
		
		
		
	}
}
