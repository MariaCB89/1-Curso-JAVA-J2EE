package com.modelo;

import java.util.Date;

/**DTO para la tabla de Usuarios. Usado en el proceso de login
 * @author María
 *@since 28/03/23
 */

public class Usuarios { 
	//PROPIEDADES DE CLASE. TIENEN QUE SER PRIVADAS (campos de la BBDD)
	private String nombreUsuario;
	private String carpetaDocumentacion;
	private Date fechaAlta;
	private Date fechaBaja;
	private String idioma;
	private String password;
	private String rol;
	
	//METODOS ACCESORES DE LAS PROPIEDADES DE CLASE
	//ESTO SE GENERA CON Source-Getters and Setters
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCarpetaDocumentacion() {
		return carpetaDocumentacion;
	}
	public void setCarpetaDocumentacion(String carpetaDocumentacion) {
		this.carpetaDocumentacion = carpetaDocumentacion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}
