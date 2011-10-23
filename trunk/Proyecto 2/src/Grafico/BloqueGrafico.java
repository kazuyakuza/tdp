package ProyectoXnoParaEntrega.Grafico;

import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;
import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.Position;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;

/**
 * Representación un bloque gráfico de un nivel del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class BloqueGrafico
{
	
	//Variables de Instancia
	protected PositionList<SpriteManager> sprites;
	protected int maxX, maxY, nivelPiso;
	//maxX = máxima posición posible en el eje X.
	//maxY = máxima posición posible en el eje Y.
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea un bloqueGrafico de dimensiones mX y mY.
	 * 
	 * @param mX Máximo X (Largo).
	 * @param mY Máximo Y (Alto).
	 */
	public BloqueGrafico (int mX, int mY)
	{
		maxX = mX;
		maxY = mY;
		nivelPiso = maxY;
		sprites = new ListaPositionSimple<SpriteManager> ();
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega un Sprite al Bloque.
	 * 
	 * @param sp Sprite a agregar.
	 */
	public void agregarSprite (SpriteManager sp) throws PosicionIncorrectaException
	{
		if ((sp.posicion()[0] > maxX) || (sp.posicion()[1] > maxY))
			throw new PosicionIncorrectaException ("Posición ingresada incorrecta." + "\n"
                                                 + "No existe posición (" + sp.posicion()[0] + "," + sp.posicion()[1] +").");
		sprites.addLast(sp);
	}
	
	/**
	 * Agrega los Sprites al Bloque.
	 * 
	 * @param sps Sprites a agregar.
	 */
	public void agregarSprites (PositionList<SpriteManager> sps) throws PosicionIncorrectaException
	{
		for (SpriteManager sp: sps)
			agregarSprite(sp);
	}
	
	/**
	 * Elimina un Sprite del Bloque.
	 * 
	 * @param sp Sprite a Eliminar.
	 */
	public void eliminarSprite (SpriteManager sp)
	{
		Position<SpriteManager> aux = sprites.first();
		while (aux.element() != sp)
			aux = sprites.next(aux);
		sprites.remove(aux);
	}
	
	/**
	 * Actualiza el nivel del piso del bloque.
	 * 
	 * @param nPiso Nuevo nivel del piso.
	 */
	public void setNivelPiso (int nPiso)
	{
		nivelPiso = nPiso;
	}
	
	/**
	 * Elimina todos los sprites del bloque.
	 */
	public void limpiar ()
	{
		while (! sprites.isEmpty())
			sprites.remove(sprites.first());
	}
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve maxX.
	 * 
	 * @return maxX.
	 */
	public int getMaxX ()
	{
		return maxX;
	}
	
	/**
	 * Devuelve maxY.
	 * 
	 * @return maxY.
	 */
	public int getMaxY ()
	{
		return maxY;
	}
	
	/**
	 * Devuelve el nivel del Piso.
	 * 
	 * @return Nivel del Piso.
	 */
	public int getNivelPiso ()
	{
		return nivelPiso;
	}

}