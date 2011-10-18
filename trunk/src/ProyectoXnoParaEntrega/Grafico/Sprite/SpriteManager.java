package ProyectoXnoParaEntrega.Grafico.Sprite;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import ProyectoXnoParaEntrega.Excepciones.CargaRecursoException;
import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;
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
	private int spriteActual;
	private double posX, posY; //Posici�n Actual del Sprite en el Escenario.
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un SpriteManager con spriteActual 0 y carga el sprite.
	 * 
	 * @param nombreSprites Nombres de los archivos de las imagenes para este sprite.
	 * @exception CargaRecursoException Error al cargar el Sprite.
	 */
	public SpriteManager (String[] nombresSprites) throws CargaRecursoException
	{
		listaSprites = nombresSprites;
		spriteActual = 0;
		sprite = new CargadorSprite().obtenerSprite(listaSprites[spriteActual], this);
		posX = posY = -1;
	}
	
	/*COMANDOS*/
	
	/**
	 * Cambia el sprite actual por el indicado en cambio.
	 * 
	 * @param cambio Numero del sprite a cambiar.
	 * @xception
	 */
	public void cambiarSprite (int cambio) throws SpriteException
	{
		if ((cambio < 0) || (cambio >= listaSprites.length))
			throw new SpriteException("Numero de Sprite a cargar incorrecto." + "\n"
					                + "Ingresado: " + cambio + " | M�ximo: " + listaSprites.length);
		spriteActual = cambio;
		sprite = new CargadorSprite().obtenerSprite(listaSprites[spriteActual], this);
	}
	
	/**
	 * Actualiza la posici�n del sprite a la posici�n (X,Y).
	 * 
	 * @param X Nueva posici�n X.
	 * @param Y Nueva posici�n Y.
	 */
	public void actualizar (int X, int Y) throws PosicionIncorrectaException
	{
		if ((X < 0) || (Y < 0))
			throw new PosicionIncorrectaException ("Posici�n ingresada incorrecta." + "\n"
					                             + "No existe posici�n (" + X + "," + Y +").");
		if ((posX == -1) && (posY == -1))
		{//Posici�n Inicial.
			posX = X;
			posY = Y;
		}
		else
		{
			int auxX = (int) posX;
			int auxY = (int) posY;
			if (((posX%auxX) != 0.0) || ((posY%auxY) != 0.0))
			{//Si alguna de los posiciones tiene decimal. Que significa que est� en medio de un movimiento,
				posX = X;
				posY = Y;
			}
			else
			{
				if (posX != X)
					posX += 0.5;
				if (posY != Y)
					posY += 0.5;
			}
		}
	}
	
	/**
	 * M�todo de ImageObserver para Actualizaci�n del Sprite (imagen actual).
	 */
	public boolean imageUpdate (Image img, int infoflags,int x, int y, int w, int h)
	{
		return (infoflags & (ALLBITS|ABORT)) == 0;
    }
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve el Sprite (imagen actual).
	 * 
	 * @return Sprite.
	 */
	public BufferedImage getSprite ()
	{
		return sprite;
	}
	
	/**
	 * Devuelve la posici�n actual del Sprite.
	 * 
	 * @return Posici�n actual del Sprite.
	 */
	public double[] posicion ()
	{
		return new double[] {posX, posY};
	}

}