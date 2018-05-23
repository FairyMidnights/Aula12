package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String UNome;
	private String USenha;

	public String getUSenha() {
		return USenha;
	}

	public void setUSenha (String USenha) {
		this.USenha = USenha;
	}

	public String getUNome() {
		return UNome;
	}

	public void setUNome(String UNome) {
		this.UNome = UNome;
	}

	@Override
	public String toString() {
		return "Usuario [UNome=" + UNome + ", USenha=" + USenha
				+ "]";
	}
}