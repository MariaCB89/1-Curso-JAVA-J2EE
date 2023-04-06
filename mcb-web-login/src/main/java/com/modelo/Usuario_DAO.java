package com.modelo;
import java.util.Date;
/**
 * DAO de acceso a la tabla de Usuarios
 * @author María
 *
 */

public class Usuario_DAO {
	
	
	/**
	 * Proceso de consulta de la BBDD por la clave primaria 
	 * de la tabla
	 * 
	 * @param nombre_usuario
	 * @return
	 */

	public Usuarios consultar_PorNombre(String nombre_usuario) {
		Usuarios usuario_consultado=null;
		//SIMULACION DEL RESULTADO DE LA CONSULTA
		if (nombre_usuario.equals("maria")) {
			usuario_consultado=new Usuarios();
			usuario_consultado.setNombreUsuario("maria");
			usuario_consultado.setPassword("admin");
			usuario_consultado.setFechaAlta(new Date());
			usuario_consultado.setRol("1");
			usuario_consultado.setIdioma("es");
		}
		
		//RETORNO DE LA INFORMACIÓN OBTENIDA EN LA BBDD
		
		return usuario_consultado;
	} 
	
	
}
