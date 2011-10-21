package ProyectoXnoParaEntrega.Logica.NoPersonajes.Especiales;

import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Logica.ControlCentral;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;

/**
 * Representa al lugar de llegada para ganar un nivel.
 * Cuando un PjSeleccionable colisiona (se ubica en la misma celda) con una Llegada, el jugador gana y pasa de nivel.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */

public class Llegada extends Actor
{
	/*ATRIBUTOS DE CLASE*/
	private static final String dirRecursos = "Objetos/";
	private static final String [] nombresSprites = {dirRecursos+"Vine2.gif",dirRecursos+"Goal Flag.gif"};
	
	/* Atributos de Instancia*/
	protected ControlCentral controlCentral;
	
	/* CONTRUCTOR*/
	
	/**
	 * Crea una Llegada para una celda determinada.
	 * @param cc es el control central del juego.
	 * @param celda es la celda asociada para la llegada.
	 */
	public Llegada (ControlCentral cc, Celda celda, CargadorSprite cargadorSprite)
	{
		super (nombresSprites,cargadorSprite);
		controlCentral = cc;
		celdaActual = celda;		
	}
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Realiza la acci�n de colisionar con otro actor a.
	 * No tiene ning�n efecto con Llegada.
	 * @param a es el actor con el que se v� a colisionar. 
	 */
	public void colisionar (Actor a)
	{
		/*No hace nada, no tiene efecto sobre actores que no sean PjSeleccionable.*/
	}
	
	/**
	 * Realiza la acci�n de colisionar con un personaje del jugador.
	 * @param pj es el actor con el que se v� a colisionar. 
	 */
	public void colisionarPj (Actor actorJugador)
	{
		controlCentral.ganarNivel();
	}
	
	/**
	 * Realiza la Acci�n caer, producida por el efecto de la gravedad. 
	 * No tiene ning�n efecto sobre Llegada.
	 */
	public void caer ()
	{
		/*No hace nada, nunca ocurre.*/
	}
	
	/**
	 * Realiza la acci�n de morir del actor.
	 * No tiene ning�n efecto sobre Llegada.
	 */
	public void morir()
	{
		/*No hace nada, nunca ocurre.*/
	}
}
