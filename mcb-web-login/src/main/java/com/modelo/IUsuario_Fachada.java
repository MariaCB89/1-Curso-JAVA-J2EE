package com.modelo;

public interface IUsuario_Fachada {

	/** 
	 * Proceso de llamada al métod de conulsta de un usuario por 
	 * el nombre 
	 * @param nombre_usuario Nombre del usuario a buscar
	 * @return información encontrada en la BBDD de un usuario concreto
	 */

	Usuarios consultar_PorNombre(String nombre_usuario);

}