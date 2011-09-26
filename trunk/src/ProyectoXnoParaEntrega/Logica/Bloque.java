package ProyectoXnoParaEntrega.Logica;

import TDALista.ListaPositionSimple;
import TDALista.PositionList;

/**
 * 
 */
public class Bloque
{
	
	//Variables de Instancia
	protected PositionList<Actor>[][] ABD;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public Bloque (int x, int y)
	{
		ABD = (PositionList<Actor>[][]) new PositionList[x][y];
		crearListas ();
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	private void crearListas ()
	{
		for (int i=0; i<cantX(); i++)
			for (int j=0; j<cantY(); j++)
				ABD[i][j] = new ListaPositionSimple<Actor> ();
	}
	
	/*CONSULTAS*/
	
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