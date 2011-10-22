package ProyectoXnoParaEntrega.Logica;

import java.util.Iterator;

import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;
import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Excepciones.ColisionException;

/**
 * Representa a todos los objetos virtuales que pueden desarrolar una "actuación" dentro del juego.
 * Por "actuación" se entiende a algún tipo de interacción entre el Juego en si, otro objecto del juego, o el Jugador del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public abstract class Actor
{
	
	//Variables de Instancia
	  //Grafica y Sonido
	protected SpriteManager spriteManager;
	//private SoundManager soundManager;
	  //Logica
	protected Celda celdaActual; 
	protected boolean bajoGravedad; //Estado que representa cuando el Actor puede ser afectado o no por la Gravedad.
	
	/*CONSTRUCTOR*/
	
	/**
	 * Recibe los nombres de los Sprites para el Actor actual, y crea el SpriteManager.
	 * El SpriteManager carga los sprites con el CargadorSprite pasado por parámetro.
	 * 
	 * @param nombresSprites Nombres de los archivos de las imagenes del Sprite para este Actor.
	 * @param cargadorSprite Clase para cargar los sprites.
	 */
	protected Actor (String[] nombresSprites, CargadorSprite cargadorSprite)
	{
		spriteManager = new SpriteManager (nombresSprites, cargadorSprite);
		celdaActual = null;
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
	 * Cambia la Celda Actual por la Celda C.
	 * 
	 * @param c Nueva Celda Actual.
	 */
	public void setCeldaActual (Celda c)
	{
		celdaActual = c;
		spriteManager.actualizar(celdaActual.getPosicion());
	}
	
	/**
	 * Provoca las colisiones con los Actores en la Celda c.
	 * Mueve Actor a la Celda c.
	 * Actualiza el SpriteManager.
	 * 
	 * @param c Celda a la que se mueve el Actor.
	 */
	public void moverseAcelda (Celda c)
	{
		producirColisiones(c);
		celdaActual = c;
		spriteManager.actualizar(celdaActual.getPosicion());
	}
	
	/**
	 * Realiza las colisiones del Actor actual con los Actores que se encuentran en la Celda c.
	 * 
	 * @param c Celda con los Actores a colisionar con el Actor actual. 
	 */
	private void producirColisiones (Celda c)
	{
		Iterator <Actor> actores = c.getActores();
		while (actores.hasNext())
			actores.next().colisionarPj(this);		
	}
	
	/**
	 * Setea el estado del Actor, si puede ser afectado o no por la Gravedad, a v.
	 * 
	 * @param v Nuevo estado del Actor bajo los efectos de la Gravedad.
	 */
	public void setBajoGravedad (boolean v)
	{
		bajoGravedad = v;
	}
	
	/*COMANDOS ABSTRACTOS*/
	
	/**
	 * Realiza la acción de colisionar con otro Actor a.
	 * 
	 * @param a Actor con el que se va a colisionar.
	 * @exception ColisionException Si se produce algún error en la colisión.
	 */
	public abstract void colisionar (Actor a) throws ColisionException;
	
	/**
	 * Realiza la acción de colisionar con un Personaje Seleccionable de un Jugador.
	 * 
	 * @param actorJugador Actor con el que se va a colisionar.
	 * @exception ColisionException Si se produce algún error en la colisión.
	 */
	public abstract void colisionarPj (Actor actorJugador) throws ColisionException;
	
	/**
	 * Realiza la Acción caer, producida por el efecto de la Gravedad.
	 * 
	 * @exception AccionActorException Si se produce algún error al caer.
	 */
	public abstract void caer () throws AccionActorException;
	
	/**
	 * Realiza la acción de morir del Actor.
	 */
	public void morir()
	{
		spriteManager.setEliminar();
		celdaActual.sacarActor(this);
		
		spriteManager = null;
		celdaActual = null;
	}
	
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
	 * Devuelve la celda actual del Actor.
	 * 
	 * @return Celda actual del Actor.
	 */
	public Celda getCeldaActual ()
	{
		return celdaActual;
	}
	
	/**
	 * Devuelve el estado del Actor en cuanto a si es afectable a la Gravedad.
	 * 
	 * @return True:  si el Actor es afectable por la Gravedad.
	 *         False: caso contrario.
	 */
	public boolean bajoGravedad ()
	{
		return bajoGravedad;
	}

}