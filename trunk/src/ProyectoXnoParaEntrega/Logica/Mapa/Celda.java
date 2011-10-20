package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;

/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Celda 
{
	protected boolean ocupada;
	protected int posFila;
	protected int posColumna;
	protected PositionList <Actor> actores;
	
	/* CONSTRUCTOR */
	
	/**
	 * 
	 */
	public Celda (int x, int y)
	{
		ocupada = false;
		posFila = x;
		posColumna = y;
		actores = new ListaPositionSimple <Actor>();
	}
	
	/* CONSULTAS*/
	
	/**
	 * 
	 */
	public int getPosFila ()
	{
		return posFila;
	}
	
	/**
	 * 
	 */
	public int getPosColumna ()
	{
		return posColumna;
	}
}
