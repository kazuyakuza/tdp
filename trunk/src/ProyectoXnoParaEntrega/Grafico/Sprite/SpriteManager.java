package ProyectoXnoParaEntrega.Grafico.Sprite;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import ProyectoXnoParaEntrega.Excepciones.SpriteException;

/**
 * Controla su Sprite cargado.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class SpriteManager implements ImageObserver
{
	
	//Variables de Instancia
	private BufferedImage sprite;
	private String[] listaSprites;
	private int spriteActual, posX, posY; //Posición del Sprite en la Matriz Gráfica de la clase Escenario.
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public SpriteManager (String[] nombresSprites)
	{
		listaSprites = nombresSprites;
		spriteActual = 0;
		sprite = new CargadorSprite().obtenerSprite(listaSprites[spriteActual], this);
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	public void cambiarSprite (int cambio) throws SpriteException
	{
		if ((cambio < 0) || (cambio >= listaSprites.length))
			throw new SpriteException("Numero de Sprite a cargar incorrecto." + "\n"
					                + "Ingresado: " + cambio + " | Máximo: " + listaSprites.length);
		spriteActual = cambio;
		sprite = new CargadorSprite().obtenerSprite(listaSprites[spriteActual], this);
	}
	
	/**
	 * 
	 */
	public boolean imageUpdate (Image img, int infoflags,int x, int y, int w, int h)
	{
		return (infoflags & (ALLBITS|ABORT)) == 0;
    }

}