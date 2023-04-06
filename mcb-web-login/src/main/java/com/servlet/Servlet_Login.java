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
		//mcb-pero request lo cambio por petici�n y response por respuesta
	//PROPIEDADES LOCALES DEL METODO
		boolean valido=true;
		String salida="jsp/login.jsp";
		String error_nombre=null; //aqui guardar� el texto que quiero que se vea cuando haya error en el nombre
		String error_clave=null; //aqui guardar� el texto que quiero que se vea cuando haya error en el nombre
	//LO DESCRITO A PARTIR DE AQUI SIRVE PARA EL 99% DE CASOS DE LOGIN
	//1� CAPTURO LO PAR�METROS DE LA PETICI�N. Con contexto > petici�n almacenado en una objeto tipo String que es lo unico que mueve el protc. html
	   String nombre_usuario=peticion.getParameter("nombre_usuario");
	   String clave_usuario=peticion.getParameter("clave_usuario");
	//2� CONVERSION - no necesaria en este caso
	//3� VALIDACION -hay que hacerla CASI siempre

	   if(nombre_usuario.isEmpty()) { //isEmpty devuelve true si el string est� vac�o
		//GESTION DE ERROR
		  error_nombre="Por favor, introduce tu nombre de usuario.";
		  valido=false;
		  }
	   
	   if (clave_usuario.equals("")){//equals tambi�n es true si est� vacio
		   
		//GESTION DE ERROR
		   error_clave="Por favor, introduce tu contrase�a.";
		   valido=false;   
	   		}else if (clave_usuario.length()<5) {
	   		error_clave="La contrase�a contener, m�nimo, 5 caracteres.";
	   		valido=false;
	   		}
			
	   //4�LOGICA O NEGOCIO
	  
		if (valido) {
			//USO DE LA CAPA MODELO PARA CONSULTAR LOS DATOS EN LA BBDD
		
			IUsuario_Fachada usuario_fachada = new Usuario_Fachada();
			Usuarios usuario_consultado = usuario_fachada.consultar_PorNombre(nombre_usuario);
			//LOGICA DE COMPROBACI�N DE DATOS
			if (usuario_consultado!=null) {
				
				//USUARIO EXISTE
				if(usuario_consultado.getPassword().equals(clave_usuario)) {
				
				//CREDENCIALES CORRECTAS	 
				salida="jsp/menu.jsp";	
				//INICIO DEL SEGUIMIENTO DE LA SESI�N
				//GUARDAMOS EL ATRIB. EN EL CONTEXTO NECESARIO
				peticion.getSession().setAttribute("usuario", usuario_consultado);
				
				}else {
				
				
				//ERROR - CLAVE ERRONEA PARA EL USUARIO
				error_clave="Contrase�a incorrecta";
				}
				
			}else {
				//ERROR-USUARIO NO EXISTE
				 error_nombre="No hay ning�n usuario registrado con ese nombre";
				
			}
		
			
		}
		
		//LA POSIBLE INFO ACERCA DE LOS ERRORES SE PASAN COMO ATRIBUTOS DE PETICI�N A LA P�GINA JSP
		
		if(error_nombre !=null || error_clave != null) {
			
		  peticion.setAttribute("error_nombre",error_nombre);
		  peticion.setAttribute("error_clave",error_clave);
			
			
		}
		
		
	   //5�NAVEGACION
		
		RequestDispatcher navegacion=peticion.getRequestDispatcher(salida);
		navegacion.forward(peticion,respuesta);
		
	}
	   
	
}


