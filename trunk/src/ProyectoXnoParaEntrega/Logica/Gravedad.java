package ProyectoXnoParaEntrega.Logica;

import java.util.Iterator;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;

/**
 * Representa a la gravedad en el juego, provoca la caída de los actores que no se encuentran sobre una celda sólida (ocupada).
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
	 * Provoca la caída del actor a sí no se encuentra sobre una celda sólida (ocupada).	
	 * @param a es el actor al cual la gravedad debe afectar.
	 */
	public void run()
	{		
		while (true)
		{			
			Iterator <Actor> actores = controlCentral.getActores().iterator();
			Actor actor;
			while (actores.hasNext())
			{
				actor = actores.next();
				if (actor.bajoGravedad())
				{
					actor.caer();
					//Si el actor se encuentra en una fila por debajo del nivel del piso, entonces debe morir por caer al precipicio.
					if (actor.getCeldaActual().getPosicion()[0] > actor.getCeldaActual().getBloque().getNivelPiso())
						actor.morir();
				}
			}
			
			
		}
	}
}
