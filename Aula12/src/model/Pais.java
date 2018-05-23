package model;

import java.io.Serializable;

public class Pais {
	
	
	private int PaisId;
	private String PaisNome;
	private long PaisPopulacao;
	private double PaisArea;
	
	public Pais() {
	}
	
	public  int getPaisId() {
		return PaisId;
	}
	public void setPaisId(int PaisId) {
		this.PaisId = PaisId;
	}
	
	public String getPaisNome() {
		return PaisNome;
	}
	public void setPaisNome(String PaisNome) {
		this.PaisNome = PaisNome;
	}
	
	public long getPaisPopulacao() {
		return PaisPopulacao;
	}
	public void setPaisPopulacao(Long PaisPopulacao) {
		this.PaisPopulacao = PaisPopulacao;
	}
	
	public double getPaisArea() {
		return PaisArea;
	}	
	public void setPaisArea(double PaisArea) {
		this.PaisArea = PaisArea;
	}

	public void setPaisId(String paisId) {

	}
	
	
}