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
 * Un espacio es una porci�n del Mapa que esta totalmende delimitada, y es �nica en el Mapa.
 * La celda puede contener actores, o estar totalmente ocupada.
 * Si una Celda est� totalmente ocupada, ning�n otro Actor puede ingresar a la Celda.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Celda
{
	
	//Variables de Instancia
	protected boolean totalmenteOcupada; //True = ning�n otro Actor puede ingresar a la Celda.
	protected int posFila, posColumna; //Posici�n en su Bloque.
	protected PositionList<Actor> actores; //Actores actuales en la Celda.
	protected Bloque bloque; //Bloque al que pertenece la Celda.
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea una Celda con los datos ingresados.
	 * 
	 * @param ocupada Si est� totalmente ocupada o no la celda.
	 * @param file Fila de la celda en el Mapa.
	 * @param columna Columna de la celda en el Mapa.
	 * @param b Bloque al que pertenece la Celda.
	 * @exception PosicionIncorrectaException Si se intenta asignar una posici�n incorrecta a la nueva Celda.
	 */
	public Celda (boolean ocupada, int fila, int columna, Bloque b) throws PosicionIncorrectaException
	{
		if ((fila < 0) || (columna < 0))
			throw new PosicionIncorrectaException ("Imposible asignar la posici�n (" + fila + "," + columna + ") a la nueva Celda.");
		totalmenteOcupada = ocupada;
		posFila = fila;
		posColumna = columna;
		bloque = b;
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
			throw new NullPointerException ("El Actor que est� intentando agregar a la Celda es null.");
		if (totalmenteOcupada)
			throw new AccionActorException("Imposible agregar Actor a la celda de posici�n (" + posFila + "," + posColumna + ")." + "\n"
					                     + "La celda est� totalmente ocupada.");
		actores.addLast(actor);
	}
	
	/**
	 * Saca el Actor pasado por par�metro.
	 * 
	 * @param actor Actor a sacar de la Celda.
	 * @return Actor sacado de la Celda.
	 * @exception NullPointerException Si se ingresa un Actor igual a null.
	 */
	public Actor sacarActor (Actor actor) throws NullPointerException
	{
		if (actor == null)
			throw new NullPointerException ("El Actor que est� intentando agregar a la Celda es null.");
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
	 * @return True:  si la Celda est� totalmente ocupada.
	 *         False: demas casos.
	 */
	public boolean isOcupada ()
	{
		return totalmenteOcupada;
	}
	
	/**
	 * Devuelve un arreglo de dos componentes con la posici�n de la Celda.
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
	 * Devuelve la posici�n horizontal (eje x) de la Celda.
	 * 
	 * @return La posici�n horizontal de la Celda.
	 */
	public int getPosFila ()
	{
		return posFila;
	}
	
	/**
	 * Devuelve la posici�n vertical (eje y) de la Celda.
	 * 
	 * @return La posici�n vertical de la Celda.
	 */
	public int getPosColumna ()
	{
		return posColumna;
	}
	
	/**
	 * Devuelve el Bloque al que pertenece la Celda.
	 * 
	 * @return Bloque al que pertenece la Celda.
	 */
	public Bloque getBloque ()
	{
		return bloque;
	}

}