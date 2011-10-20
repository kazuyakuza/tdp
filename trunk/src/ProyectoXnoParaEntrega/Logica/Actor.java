package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;

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
	private SpriteManager spriteManager;
	//private SoundManager soundManager;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Recibe los nombres de los Sprites para el Actor actual, y crea el SpriteManager.
	 * 
	 * @param nombresSprites Nombres de los archivos de las imagenes del Sprite para este Actor.
	 */
	protected Actor (String[] nombresSprites, CargadorSprite cargadorSprite)
	{
		spriteManager = new SpriteManager (nombresSprites, cargadorSprite);
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

}