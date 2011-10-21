package ProyectoXnoParaEntrega.Logica.Mapa;

import java.util.Iterator;

import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;

import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.Position;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;
import ProyectoXnoParaEntrega.Logica.Actor;

/**
 * Representa un espacio en el mapa del Juego.
 * Un espacio es una porción del Mapa que esta totalmende delimitada, y es única en el Mapa.
 * La celda puede contener actores, o estar totalmente ocupada.
 * Si una Celda está totalmente ocupada, ningún otro Actor puede ingresar a la Celda.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Celda
{
	
	//Variables de Instancia
	protected boolean totalmenteOcupada;
	protected int posFila, posColumna;
	protected PositionList<Actor> actores;
	protected Bloque bloque;
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea una Celda con los datos ingresados.
	 * 
	 * @param ocupada Si está totalmente ocupada o no la celda.
	 * @param file Fila de la celda en el Mapa.
	 * @param columna Columna de la celda en el Mapa.
	 * @exception PosicionIncorrectaException Si se intenta asignar una posición incorrecta a la nueva Celda.
	 */
	public Celda (boolean ocupada, int fila, int columna) throws PosicionIncorrectaException
	{
		if ((fila < 0) || (columna < 0))
			throw new PosicionIncorrectaException ("Imposible asignar la posición (" + fila + "," + columna + ") a la nueva Celda.");
		totalmenteOcupada = ocupada;
		posFila = fila;
		posColumna = columna;
		actores = new ListaPositionSimple<Actor> ();
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega un Actor a la Celda.
	 * 
	 * @param actor Actor a agregar.
	 * @exception NullPointerException Si se ingresa un Actor igual a null.
	 * @exception AccionActorException Si se intenta agregar un Actor a una Celda totalmente ocupada.
	 */
	public void agregarActor (Actor actor) throws NullPointerException, AccionActorException
	{
		if (actor == null)
			throw new NullPointerException ("El Actor que está intentando agregar a la Celda es null.");
		if (totalmenteOcupada)
			throw new AccionActorException("Imposible agregar Actor a la celda de posición (" + posFila + "," + posColumna + ")." + "\n"
					                     + "La celda está totalmente ocupada.");
		actores.addLast(actor);
	}
	
	/**
	 * Saca el Actor pasado por parámetro.
	 * 
	 * @param actor Actor a sacar de la Celda.
	 * @return Actor sacado de la Celda.
	 * @exception NullPointerException Si se ingresa un Actor igual a null.
	 */
	public Actor sacarActor (Actor actor) throws NullPointerException
	{
		if (actor == null)
			throw new NullPointerException ("El Actor que está intentando agregar a la Celda es null.");
		Position<Actor> p = actores.first();
		while (p.element() != actor)
			p = actores.next(p);
		return actores.remove(p);
	}
	
	/**
	 * Setea si esta totalmenteOcupada o no la Celda.
	 * 
	 * @param ocupada True: la celda esta totalmente ocupada.
	 */
	public void setOcupada (boolean ocupada)
	{
		totalmenteOcupada = ocupada;
	}
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve un Iterador con los Actores de la Celda.
	 * 
	 * @return Iterador con los Actores de la Celda.
	 */
	public Iterator<Actor> getActores ()
	{
		return actores.iterator();
	}
	
	/**
	 * Devuelve el estado de la Celda.
	 * 
	 * @return True:  si la Celda está totalmente ocupada.
	 *         False: demas casos.
	 */
	public boolean getOcupada ()
	{
		return totalmenteOcupada;
	}
	
	/**
	 * Devuelve un arreglo de dos componentes con la posición de la Celda.
	 * Componente [0] = posFila.
	 * Componente [1] = posColumna.
	 * 
	 * @return Arreglo de dos componentes con {posFila, posColumna};
	 */
	public int[] getPosicion ()
	{
		return new int[] {posFila, posColumna};
	}
	
	/**
	 * Retorna el bloque al que pertenece la celda.
	 * @return es el bloque al que pertenece la celda.
	 */
	public Bloque getBloque ()
	{
		return bloque;
	}

}