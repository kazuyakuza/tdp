package ProyectoXnoParaEntrega.Logica;

import java.util.Iterator;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;

/**
 * Representa a la gravedad en el juego, provoca la ca�da de los actores que no se encuentran sobre una celda s�lida (ocupada).
 * 
 * Proyecto X
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */

public class Gravedad implements Runnable
{
	/* Atributos de Instancia */
	protected ControlCentral controlCentral;
	
	/* CONTRUCTOR */
	
	/**
	 * Crea la gravedad con el control central del juego.
	 * @param cc es el control central del juego.
	 */
	public Gravedad (ControlCentral cc)
	{
		controlCentral = cc;
	}
	
	/**
	 * Provoca la ca�da del actor a s� no se encuentra sobre una celda s�lida (ocupada).	
	 * @param a es el actor al cual la gravedad debe afectar.
	 */
	public void run()
	{		
		while (true)
		{			
			Iterator <Actor> actores = controlCentral.getActores().iterator();			
			while (actores.hasNext())
			{
				afectar(actores.next());				
			}			
		}
	}
	
	/**
	 * 
	 */
	public void afectar (Actor a)
	{
		if (a.bajoGravedad())
		{
			a.caer();
			//Si el actor se encuentra en una fila por debajo del nivel del piso, entonces debe morir por caer al precipicio.
			if (a.getCeldaActual().getPosicion()[0] > a.getCeldaActual().getBloque().getNivelPiso())
				a.morir();
		}
	}
}
