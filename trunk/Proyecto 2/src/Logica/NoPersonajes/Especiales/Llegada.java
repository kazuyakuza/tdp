package ProyectoXnoParaEntrega.Logica.NoPersonajes.Especiales;

import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Excepciones.ColisionException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Logica.ControlCentral;

/**
 * Representa al lugar de llegada para ganar un Nivel.
 * Cuando un PjSeleccionable colisiona (se ubica en la misma celda) con una Llegada, el Jugador gana y termina el Nivel.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */

public class Llegada extends Actor
{
	
	//Atributos de Clase
	private static final String dirRecursos = "Objetos/";
	private static final String [] nombresSprites = {dirRecursos + "Vine2.gif", dirRecursos + "Goal Flag.gif"};
	
	//Atributos de Instancia
	private ControlCentral controlCentral;
	
	/*CONTRUCTOR*/
	
	/**
	 * Crea una Llegada.
	 * 
	 * @param cc ControlCentral del Juego.
	 * @param cargadorSprite Clase para cargar los sprites.
	 */
	public Llegada (ControlCentral cc, CargadorSprite cargadorSprite)
	{
		super (nombresSprites, cargadorSprite);
		controlCentral = cc;
	}
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Realiza la acci�n de colisionar con otro Actor a.
	 * No tiene ning�n efecto con Llegada.
	 * 
	 * @param a Actor con el que se va a colisionar.
	 * @exception ColisionException Si se produce alg�n error en la colisi�n. 
	 */
	public void colisionar (Actor a) throws ColisionException
	{
		/*No hace nada, no tiene efecto sobre Actores que no sean Personajes.*/
	}
	
	/**
	 * Realiza la acci�n de colisionar con un Personaje Seleccionable de un Jugador.
	 * 
	 * @param actorJugador Actor con el que se va a colisionar.
	 * @exception ColisionException Si se produce alg�n error en la colisi�n.
	 */
	public void colisionarPj (Actor actorJugador) throws ColisionException
	{
		controlCentral.ganarNivel();
	}
	
	/**
	 * Si la Gravedad afecta a este Actor, entonces llamar� a este m�todo para afectarlo.
	 * 
	 * @param efecto Efecto de la Gravedad sobre este Actor.
	 */
	public void efectoGravedad (int efecto)
	{
		PG = 0;
	}
	
	/**
	 * Realiza la Acci�n caer, producida por el efecto de la Gravedad.
	 * No tiene ning�n efecto con Llegada.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al caer.
	 */
	public void caer () throws AccionActorException
	{
		/*No hace nada, nunca ocurre.*/
	}
	
	/**
	 * Realiza la acci�n de morir del Actor.
	 * 
	 * No tiene ning�n efecto con Llegada.
	 */
	public void morir()
	{
		/*No hace nada, nunca ocurre.*/
	}
	
}