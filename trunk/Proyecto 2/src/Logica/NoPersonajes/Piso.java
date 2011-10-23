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
	 * Si la Gravedad afecta a este Actor, entonces llamará a este método para afectarlo.
	 * 
	 * @param efecto Efecto de la Gravedad sobre este Actor.
	 */
	public void efectoGravedad (int efecto)
	{
		PG = 0;
	}
	
	/*COMANDOS IMPLEMENTADOS*/

	/**
	 * Realiza la Acción caer, producida por el efecto de la Gravedad.
	 * 
	 * @exception AccionActorException Si se produce algún error al caer.
	 */
	public void caer() throws AccionActorException
	{
		/*No hace nada, nunca ocurre.*/
	}
	
	/**
	 * Realiza la acción de morir del Actor.
	 * 
	 * No tiene ningún efecto con Piso.
	 */
	public void morir()
	{
		/*No hace nada, nunca ocurre.*/
	}

	/**
	 * Realiza la acción de colisionar con otro Actor.
	 * 
	 * @exception ColisionException Si se produce algún error en la colisión.
	 */
	public void colisionar (Actor a) throws ColisionException
	{
		/*No hace nada, no tiene efecto sobre Actores que no sean Personajes.*/
	}
	
	/**
	 * Realiza la acción de colisionar con otro Personaje Seleccionable.
	 * 
	 * @exception ColisionException Si se produce algún error en la colisión.
	 */
	public void colisionarPj (Actor actorJugador) throws ColisionException
	{
		/*No hace nada, no tiene efecto sobre Actores que no sean Personajes.*/
	}

}