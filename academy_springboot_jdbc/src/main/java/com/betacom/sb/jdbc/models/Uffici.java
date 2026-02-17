package com.betacom.sb.jdbc.models;

public class Uffici {

	private int id_ufficio;
	private String nome_ufficio;
	public int getId_ufficio() {
		return id_ufficio;
	}
	public void setId_ufficio(int id_ufficio) {
		this.id_ufficio = id_ufficio;
	}
	public String getNome_ufficio() {
		return nome_ufficio;
	}
	public void setNome_ufficio(String nome_ufficio) {
		this.nome_ufficio = nome_ufficio;
	}
	@Override
	public String toString() {
		return "Uffici [id_ufficio=" + id_ufficio + ", nome_ufficio=" + nome_ufficio + "]";
	}
	
	

	
	
}
