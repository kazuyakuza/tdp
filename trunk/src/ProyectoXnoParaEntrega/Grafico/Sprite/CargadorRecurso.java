package ProyectoXnoParaEntrega.Grafico.Sprite;

import java.net.URL;

import ProyectoXnoParaEntrega.Excepciones.CargaRecursoException;

/**
 * Clase utilizada para cargar Recursos del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public abstract class CargadorRecurso
{
	
	//Variables de Clase
	private String dirRecursos = "ProyectoXnoParaEntrega/Recursos/";
	
	/*COMANDOS*/
	
	/**
	 * Devuelve el recurso de nombre nom.
	 * 
	 * @param nom Nombre del recurso a devolver.
	 * @return Recurso de nombre nom.
	 */
	public Object obtenerRecurso (String nom) throws CargaRecursoException
	{
		Object res = cargarRecurso(dirRecursos + nom);
		return res;
	}
	
	/**
	 * Genera la URL necesaria para cargar el recurso de direccion dir.
	 * 
	 * @param dir Dirección del recurso a cargar.
	 * @return Recurso que está en la dirección dir.
	 */
	private Object cargarRecurso (String dir) throws CargaRecursoException
	{
		URL url = null;
		url = getClass().getClassLoader().getResource(dir);
		return cargarRecurso(url);
	}
	
	/**
	 * Lee la url del recurso a cargar, y lo devuelve.
	 * 
	 * @param url Dirección del recurso a cargar.
	 * @return Recurso de dirección url.
	 * @exception CargaRecursoException Si hay un error al leer la URL.
	 */
	public abstract Object cargarRecurso (URL url) throws CargaRecursoException;

}