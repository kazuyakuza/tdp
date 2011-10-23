package ProyectoXnoParaEntrega.Logica.NoPersonajes;

import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Excepciones.ColisionException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Actor;

/**
 * Representa al Piso en el Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Piso extends Actor implements Estructura
{
	
	//Variables de Clase
	private static final String dirRecursos = "Estructuras/";
	private static final String [] nombresSprites = {dirRecursos + "Piso.png"};

	/**
	 * Crea una Plataforma Irrompible.
	 * 
	 * @param cargadorSprite Clase para cargar los sprites.
	 */
	public Piso(CargadorSprite cargadorSprite)
	{
		super(nombresSprites, cargadorSprite);
	}
	
	/*COMANDOS*/
	
	/**
	 * Si la Gravedad afecta a este Actor, entonces llamar� a este m�todo para afectarlo.
	 * 
	 * @param efecto Efecto de la Gravedad sobre este Actor.
	 */
	public void efectoGravedad (int efecto)
	{
		PG = 0;
	}
	
	/*COMANDOS IMPLEMENTADOS*/

	/**
	 * Realiza la Acci�n caer, producida por el efecto de la Gravedad.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al caer.
	 */
	public void caer() throws AccionActorException
	{
		/*No hace nada, nunca ocurre.*/
	}
	
	/**
	 * Realiza la acci�n de morir del Actor.
	 * 
	 * No tiene ning�n efecto con Piso.
	 */
	public void morir()
	{
		/*No hace nada, nunca ocurre.*/
	}

	/**
	 * Realiza la acci�n de colisionar con otro Actor.
	 * 
	 * @exception ColisionException Si se produce alg�n error en la colisi�n.
	 */
	public void colisionar (Actor a) throws ColisionException
	{
		/*No hace nada, no tiene efecto sobre Actores que no sean Personajes.*/
	}
	
	/**
	 * Realiza la acci�n de colisionar con otro Personaje Seleccionable.
	 * 
	 * @exception ColisionException Si se produce alg�n error en la colisi�n.
	 */
	public void colisionarPj (Actor actorJugador) throws ColisionException
	{
		/*No hace nada, no tiene efecto sobre Actores que no sean Personajes.*/
	}

}