package ProyectoXnoParaEntrega.Grafico.Sprite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.imageio.ImageIO;

import ProyectoXnoParaEntrega.Excepciones.CargaRecursoException;

/**
 * Clase utilizada para cargar Sprites (imágenes del Juego).
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class CargadorSprite extends CargadorRecurso
{
	
	//Variables de Clase
	private String dirSprites = "Personajes";
	
	/*COMANDOS*/

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public BufferedImage obtenerSprite (String nombre)
	{
		BufferedImage loaded = (BufferedImage) obtenerRecurso(nombre);
        BufferedImage compatible = createCompatible(loaded.getWidth(),loaded.getHeight(),Transparency.BITMASK); 
        Graphics g = compatible.getGraphics();
        g.drawImage(loaded,0,0,this);
        return compatible;
	}
	
	/**
	 * Devuelve el recurso de nombre nom.
	 * 
	 * @param nom Nombre del recurso a devolver.
	 * @return Recurso de nombre nom.
	 */
	public Object obtenerRecurso (String nom) throws CargaRecursoException
	{
		Object res = super.obtenerRecurso("Personajes/" + nom);
		return res;
    }
	
	/**
	 * Lee la url del recurso a cargar, y lo devuelve.
	 * 
	 * @param url Dirección del recurso a cargar.
	 * @return Recurso de dirección url.
	 * @exception CargaRecursoException Si hay un error al leer la URL.
	 */
	public Object cargarRecurso (URL url) throws CargaRecursoException
	{
		try
		{
			return ImageIO.read(url);
		}
		catch (Exception e)
		{
			throw new CargaRecursoException ("Error al Carga un Recurso Imagen: " + e.getMessage());
		}
	}

}