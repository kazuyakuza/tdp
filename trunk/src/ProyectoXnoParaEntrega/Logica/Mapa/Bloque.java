package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;
import ProyectoXnoParaEntrega.Excepciones.BoundaryViolationException;
import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;

/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Bloque
{
	
	//Variables de Instancia
	protected Celda[][] ABD;	
	
	//CONSTRUCTOR
	
	/**
	 * 
	 */
	public Bloque (int x, int y)
	{
		ABD = (Celda[][]) new PositionList[x][y];
		crearCeldas();
				
	}
	
	//COMANDOS
	
	/**
	 * 
	 */
	private void crearCeldas ()
	{
		for (int i=0; i<getFilas(); i++)
			for (int j=0; j<getColumnas(); j++)
				ABD[i][j] = new Celda (i,j);
	}
	
	//CONSULTAS
	
	/**
	 * 
	 */
	public int getFilas ()
	{
		return ABD.length;
	}
	
	/**
	 * 
	 */
	public int getColumnas ()
	{
		return ABD[0].length;
	}
	
	/**
	 * 
	 */
	public Celda getSiguiente (Celda c) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (c == null)
			throw new PosicionIncorrectaException("La celda no es válida.");
		else if (c.getPosColumna() == ABD.length)
				 throw new BoundaryViolationException ("Es la última celda de la fila, no tiene siguiente.");
			 else
				 return ABD[c.getPosFila()][c.getPosColumna()+1];			
	}
	/**
	 * 
	 */
	public Celda getAnterior (Celda c) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (c == null)
			throw new PosicionIncorrectaException("La celda no es válida.");
		else if (c.getPosColumna() == 0)
				 throw new BoundaryViolationException ("Es la primera celda de la fila, no tiene anterior.");
			 else
				 return ABD[c.getPosFila()][c.getPosColumna()-1];	
	}
	/**
	 * 
	 */
	public Celda getSuperior (Celda c) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (c == null)
			throw new PosicionIncorrectaException("La celda no es válida.");
		else if (c.getPosFila() == 0)
				 throw new BoundaryViolationException ("Es la primera celda de la fila, no tiene anterior.");
			 else
				 return ABD[c.getPosFila()-1][c.getPosColumna()];	
	}
	
	/**
	 * 
	 */
	public Celda getInferior (Celda c) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (c == null)
			throw new PosicionIncorrectaException("La celda no es válida.");
		else if (c.getPosFila() == ABD.length)
				 throw new BoundaryViolationException ("Es la primera celda de la fila, no tiene anterior.");
			 else
				 return ABD[c.getPosFila()+1][c.getPosColumna()];	
	}
	
	/**
	 * 
	 */
	public Celda getCelda (int x, int y)
	{
		return ABD[x][y];
	}

}