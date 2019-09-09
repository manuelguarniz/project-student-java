package com.entidades.seguridad;

import com.entidades.comun.*;

public class SEG_UsuarioEL {
	private int idUsuario;
	private CMM_PersonaEL Persona;
	private String Login;
	private String Password;
	private boolean Activo;
	
		
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public CMM_PersonaEL getPersona() {
		return Persona;
	}
	public void setPersona(CMM_PersonaEL persona) {
		Persona = persona;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public boolean isActivo() {
		return Activo;
	}
	public void setActivo(boolean activo) {
		Activo = activo;
	}

}
