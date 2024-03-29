package ProyectoX.Grafico;

import ProyectoX.Excepciones.PosicionIncorrectaException;
import ProyectoX.Excepciones.SpriteException;
import ProyectoX.Grafico.Sprite.SpriteManager;
import ProyectoX.Librerias.TDALista.ListaPositionSimple;
import ProyectoX.Librerias.TDALista.Position;
import ProyectoX.Librerias.TDALista.PositionList;

/**
 * Representaci�n un bloque gr�fico de sprites.
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
	//maxX = m�xima posici�n posible en el eje X.
	//maxY = m�xima posici�n posible en el eje Y.
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea un BloqueGr�fico de dimensiones mX y mY.
	 * 
	 * @param mX M�ximo X (Largo).
	 * @param mY M�ximo Y (Alto).
	 */
	public BloqueGrafico (int mX, int mY)
	{
		maxX = mX;
		maxY = mY;
		nivelPiso = maxY - 2;
		sprites = new ListaPositionSimple<SpriteManager> ();
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega un Sprite al Bloque.
	 * 
	 * @param sp Sprite a agregar.
	 * @exception PosicionIncorrectaException Si la posici�n del SpriteManager a ingresar no corresponde con las posiciones posibles de este BloqueGr�fico.
	 */
	public void agregarSprite (SpriteManager sp) throws PosicionIncorrectaException
	{
		if ((sp.posicion()[0] > maxX) || (sp.posicion()[1] > maxY))
			throw new PosicionIncorrectaException ("Posici�n ingresada incorrecta." + "\n" +
                                                   "No existe posici�n (" + sp.posicion()[0] + "," + sp.posicion()[1] +")." + "\n" +
                                                   "maxX = " + maxX + " maxY = " + maxY);
		sprites.addLast(sp);
	}
	
	/**
	 * Agrega los Sprites al BloqueGr�fico.
	 * 
	 * @param sps Sprites a agregar.
	 * @exception PosicionIncorrectaException Si la posici�n del SpriteManager a ingresar no corresponde con las posiciones posibles de este BloqueGr�fico.
	 */
	public void agregarSprites (PositionList<SpriteManager> sps) throws PosicionIncorrectaException
	{
		for (SpriteManager sp: sps)
			agregarSprite(sp);
	}
	
	/**
	 * Elimina un Sprite del BloqueGr�fico.
	 * 
	 * @param sp Sprite a Eliminar.
	 * @exception SpriteException Si se ingresa un SpriteManager que no pertenece al BloqueGrafico.
	 */
	public void eliminarSprite (SpriteManager sp) throws SpriteException
	{
		Position<SpriteManager> aux = sprites.first();
		while ((aux != sprites.last()) && (aux.element() != sp))
			aux = sprites.next(aux);
		if (aux.element() != sp)
			throw new SpriteException ("El SpriteManager que se intenta eliminar no pertenece al BloqueGrafico actual.");
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