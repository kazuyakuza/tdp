package ProyectoXnoParaEntrega.Logica.NoPersonajes.Plataformas;

import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Excepciones.ColisionException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Actor;

/**
 * Representa a una Plataforma Irrompible en el Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Irrompible extends Actor implements Plataforma
{
	
	//Variables de Clase
	private static final String dirRecursos = "Estructuras/Plataformas/";
	private static final String [] nombresSprites = {dirRecursos + "Empty-Block.gif"};

	/**
	 * Crea una Plataforma Irrompible.
	 * 
	 * @param cargadorSprite Clase para cargar los sprites.
	 */
	public Irrompible(CargadorSprite cargadorSprite)
	{
		super(nombresSprites, cargadorSprite);
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