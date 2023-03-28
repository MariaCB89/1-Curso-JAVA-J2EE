package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.IUsuario_Fachada;
import com.modelo.Usuario_Fachada;
import com.modelo.Usuarios;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet(description = "Proceso de login en la App", urlPatterns = { "/Login" }) //mcb-urlPatterns es "/Login" porque es lo que puse en <form action="Login" method="post"> en el login.jps
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /** public Servlet_Login() {//mcb-El constructor no lo necesitamos
       * super();}
        // TODO Auto-generated constructor stub*/
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub 
		//mcb-pero request lo cambio por petición y response por respuesta
	//PROPIEDADES LOCALES DEL METOD
		boolean valido=true;
		String salida="jsp/login.jsp";
	//LO DESCRITO A PARTIR DE AQUI SIRVE PARA EL 99% DE CASOS DE LOGIN
	//1º CAPTURO LO PARÁMETROS DE LA PETICIÓN. Con contexto > petición almacenado en una objeto tipo String que es lo unico que mueve el protc. html
	   String nombre_usuario=peticion.getParameter("nombre_usuario");
	   String clave_usuario=peticion.getParameter("clave_usuario");
	//2º CONVERSION - no necesaria en este caso
	//3º VALIDACION -hay que hacerla CASI siempre

	   if(nombre_usuario.isEmpty()) { //isEmpty devuelve true si el string está vacío
		//GESTION DE ERROR
		  valido=false;
		  }
	   
	   if (clave_usuario.equals("")){//equals también es true si está vacio
		   
		//GESTION DE ERROR
		   valido=false;   
	   		}else if (clave_usuario.length()<5) {
	   		valido=false;}
			
	   //4ºLOGICA O NEGOCIO
	  
		if (valido) {
			//USO DE LA CAPA MODELO PARA CONSULTAR LOS DATOS EN LA BBDD
		
			IUsuario_Fachada usuario_fachada = new Usuario_Fachada();
			Usuarios usuario_consultado = usuario_fachada.consultar_PorNombre(nombre_usuario);
			//LOGICA DE COMPROBACIÓN DE DATOS
			if (usuario_consultado!=null) {
				//USUARIO EXISTE
				if(usuario_consultado.getPassword().equals(clave_usuario)) {
					
					
					
				}
				
			}else {
				//ERROR-USUARIO NO EXISTE
				
				
			}
			salida="jsp/menu.jsp";
			
		}
	   //5ºNAVEGACION
		
		RequestDispatcher navegacion=peticion.getRequestDispatcher(salida);
		navegacion.forward(peticion,respuesta);
		
	}
	   
	
}


