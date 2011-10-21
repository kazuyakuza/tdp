package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;
import ProyectoXnoParaEntrega.Logica.Personajes.PjSeleccionable;

/**
 * Representa a todos los objetos digitales que pueden desarrolar una "actuación" dentro del juego.
 * Por "actuación" nos referimos a algún tipo de interacción entre el Juego en si, otro objecto del juego, o el Jugador del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public abstract class Actor
{
	
	//Variables de Instancia
	protected SpriteManager spriteManager;
	//private SoundManager soundManager;
	
	protected Celda celdaActual; 
	protected boolean bajoGravedad; //Estado que representa cuándo el actor puede ser afectado o no por la gravedad. 
	
	/*CONSTRUCTOR*/
	
	/**
	 * Recibe los nombres de los Sprites para el Actor actual, y crea el SpriteManager.
	 * 
	 * @param nombresSprites Nombres de los archivos de las imagenes del Sprite para este Actor.
	 */
	protected Actor (String[] nombresSprites, CargadorSprite cargadorSprite)
	{
		spriteManager = new SpriteManager (nombresSprites, cargadorSprite);
		bajoGravedad = false;
	}
	
	/*COMANDOS*/
	
	/**
	 * Cambia el SpriteManager actual por el nuevo sp.
	 * 
	 * @param sp Nuevo SpriteManager.
	 */
	public void setSpriteManager (SpriteManager sp)
	{
		spriteManager = sp;
	}
	
	/**
	 * Setea la celda actual del actor con c.
	 * @param c es la celda con la que se setea como actual para el actor.
	 */
	public void setCeldaActual (Celda c)
	{
		celdaActual = c;
	}
	 /**
	  * Setea el estado del actor, si puede ser afectado o no por la gravedad, a v.
	  * @param v es el nuevo estado del actor bajo los efectos de la gravedad.
	  */
	public void setBajoGravedad (boolean v)
	{
		bajoGravedad = v;
	}
	
	/*COMANDOS ABSTRACTOS*/
	
	/**
	 * Realiza la acción de colisionar con otro actor a.
	 * @param a es el actor con el que se vá a colisionar. 
	 */
	public abstract void colisionar (Actor a);
	
	/**
	 * Realiza la acción de colisionar con un personaje del jugador.
	 * @param pj es el actor con el que se vá a colisionar. 
	 */
	public abstract void colisionarPj (PjSeleccionable pj);
	
	/**
	 * Realiza la Acción caer, producida por el efecto de la gravedad. 
	 */
	public abstract void caer ();
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve el SpriteManager actual.
	 * 
	 * @return SpriteManager actual.
	 */
	public SpriteManager getSpriteManager ()
	{
		return spriteManager;
	}
	
	/**
	 * Devuelve la celda actual del actor.
	 * @return la celda actual.
	 */
	public Celda getCeldaActual ()
	{
		return celdaActual;
	}
	
	/**
	 * Devuelve el estado del actor en cuanto si es afectable a la gravedad.
	 * @return true si el actor es afectable por la gravedad, en caso contrario, false. 
	 */
	public boolean bajoGravedad ()
	{
		return bajoGravedad;
	}

}