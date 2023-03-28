package com.modelo;

/**
 * Fachada de acceso a los procesos de la tabla Usuarios
 * @author María
 *
 */

public class Usuario_Fachada implements IUsuario_Fachada {
	
	/**
	 * Propiedad para definir el DAO de acceso  a los datos
	 */

	private Usuario_DAO usuario_dao;
	
	/**
	 * Constructor de la fachada para Usuarios en la capa modelo
	 */
	
	public Usuario_Fachada() {
		usuario_dao=new Usuario_DAO();
	}
	
	/** 
	 * Proceso de llamada al métod de conulsta de un usuario por 
	 * el nombre 
	 * @param nombre_usuario Nombre del usuario a buscar
	 * @return información encontrada en la BBDD de un usuario concreto
	 */
	
	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		Usuarios usuario_consulta=usuario_dao.consultar_PorNombre(nombre_usuario);
		
		return usuario_consulta;
		
		
	}
}
