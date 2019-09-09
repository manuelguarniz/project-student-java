package com.datos.seguridad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.datos.comun.Conexion;
import com.entidades.comun.CMM_PersonaEL;
import com.entidades.seguridad.SEG_UsuarioEL;

public class SEG_UsuarioDL {
	//Singleton
	public static SEG_UsuarioDL _Instancia;
	private SEG_UsuarioDL(){};
	public static SEG_UsuarioDL Instancia(){
		if(_Instancia==null){
			_Instancia = new SEG_UsuarioDL();
		}
		return _Instancia;
	}
	//endSingleton	
	
	public SEG_UsuarioEL VerificarAcceso(String _Usuario, String _Passw)
															throws Exception{
		Connection cn = null;
		SEG_UsuarioEL u = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spSEG_VerificarAcceso(?,?)}");
			cst.setString(1, _Usuario);
			cst.setString(2, _Passw);
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				u = new SEG_UsuarioEL();
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setLogin(rs.getString("Login"));
					CMM_PersonaEL p = new CMM_PersonaEL();
					p.setNombres(rs.getString("Nombres"));
					p.setApellidos(rs.getString("apellidos"));
					p.setSexo(rs.getString("Sexo"));
				u.setActivo(rs.getBoolean("Activo"));
				u.setPersona(p);
			}
		} catch (Exception e) { throw e;
		}finally{cn.close();}
		return u;
	}
	
}
