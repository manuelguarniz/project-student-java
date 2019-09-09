package com.logica.seguridad;
import com.datos.seguridad.SEG_UsuarioDL;
import com.entidades.seguridad.SEG_UsuarioEL;

public class SEG_UsuarioBL {
	//Singleton
	public static SEG_UsuarioBL _Instancia;
	private SEG_UsuarioBL(){};
	public static SEG_UsuarioBL Instancia(){
		if(_Instancia==null){
			_Instancia = new SEG_UsuarioBL();
		}
		return _Instancia;
	}
	//endSingleton	
	
	public SEG_UsuarioEL VerificarAcceso(String _Usuario, String _Passw)
															throws Exception{
		try {
			SEG_UsuarioEL u = SEG_UsuarioDL.Instancia().VerificarAcceso(_Usuario, _Passw);
			if(u==null){
				throw new Exception("Usuario o PAssword no Valido!");				
			}else{
				if(!u.isActivo()){
					throw new Exception("Usuario ha sido dado de baja!");
				}				
			}
			return u;
		} catch (Exception e) {
			throw e;
		}
	}		
}
