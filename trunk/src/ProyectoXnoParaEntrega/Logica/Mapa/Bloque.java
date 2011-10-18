package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Logica.Actor;
import TDALista.ListaPositionSimple;
import TDALista.PositionList;

/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Bloque
{
	
	//Variables de Instancia
	protected PositionList<Actor>[][] ABD;
	
	//CONSTRUCTOR
	
	/**
	 * 
	 */
	public Bloque (int x, int y)
	{
		ABD = (PositionList<Actor>[][]) new PositionList[x][y];
		crearListas ();
	}
	
	//COMANDOS
	
	/**
	 * 
	 */
	private void crearListas ()
	{
		for (int i=0; i<cantX(); i++)
			for (int j=0; j<cantY(); j++)
				ABD[i][j] = new ListaPositionSimple<Actor> ();
	}
	
	//CONSULTAS
	
	/**
	 * 
	 */
	public int cantX ()
	{
		return ABD.length;
	}
	
	/**
	 * 
	 */
	public int cantY ()
	{
		return ABD[0].length;
	}
	
	/**
	 * 
	 */
	public PositionList<Actor> celda (int x, int y)
	{
		return ABD[x][y];
	}

}