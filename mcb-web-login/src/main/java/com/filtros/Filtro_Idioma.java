package com.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filtro_Idioma
 */
@WebFilter(description = "Definición idioma preferido x usuario", urlPatterns = { "/jsp/login.jsp" })
public class Filtro_Idioma implements Filter {
 //PROPIEDADES DE CLASE PARA SU FUNCIONAMIENTO	
	private String idioma_defecto;
	
	/**
	 * Establecemos el idioma por defecto. Se lee este valor del fichero de configuración
	 * web.xml y se establece como opción por defecto
	 */
	 
	public void init(FilterConfig filterConfig) throws ServletException {
		//ESTABLECIMIENTO DE LA RUTA PARA EL RESOURCEBUNDLE CORRESPONDIENTE
		idioma_defecto="com/idiomas/textos_"
			+filterConfig.getServletContext().getInitParameter("idioma_por_defecto");
		System.out.println("SE HA CREADO EL FILTRO DE IDIOMA");
	}

  
	/**
	 * Cargamos el idioma por defecto en base a la elección de idioma del navegador
	 * del cliente que hace la petición. En caso de que no se tenga ese idioma 
	 * se carga el idioma por defecto estrablecido en el método init.
	 * 
	 * @param peticion Objeto que representa la petición. En nuestro caso es
	 * 					un objeto HTTPSERVLETREQUEST.
	 * @param respuesta Objeto que representan la petición. En nuestro caso es 
	 * 					un objeto HTTPSERVELTRESPONSE
	 * @param cadena_peticion Objeto que nos permitirá seguir la secuencia de la
	 * 					petición una vez terminado el proceso
	 */
	
	public void doFilter(ServletRequest peticion, ServletResponse respuesta, FilterChain cadena_peticion) 
			 throws IOException, ServletException {
		String idioma_elegido_peticion=idioma_defecto;
		// CASTEO AL TIPO REQUERIDO		
		HttpServletRequest mi_request=null;
		if(peticion instanceof HttpServletRequest) {
			mi_request=(HttpServletRequest)peticion;
		}
		
		//SACAMOS DE LA PETICION EL IDIOMA PREFERIDO POR EL USUARIO 	
		String idioma_preferido=mi_request.getHeader("accept-language");
		//DIVIDIMOS EL TEXTO EN TANTO IDIOMAS COMO NOS MANDEN EN LA PETICION
		String lista_idiomas[]=idioma_preferido.split(",");
		for (int i=0;i<lista_idiomas.length;i++) {
			if(lista_idiomas[i].substring(0,2).equals("es")) {
				idioma_elegido_peticion="com/idiomas/textos_es";
				break;
			}
			if(lista_idiomas[i].substring(0,2).equals("en")) {
				idioma_elegido_peticion="com/idiomas/textos_en";
				break;
			}
			if(lista_idiomas[i].substring(0,2).equals("fr")) {
				idioma_elegido_peticion="com/idiomas/textos_fr";
				break;
			}
		}
		
		//GUARDAMOS EN LA SESION EL IDIOMA PARA ESE USUARIO
		mi_request.getSession().setAttribute("idioma_elegido",idioma_elegido_peticion);		
		
		cadena_peticion.doFilter(peticion, respuesta);
	}
	
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("SE HA DESTRUIDO EL FILTRO DE IDIOMA");
	}


	
}
