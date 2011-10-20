package ProyectoXnoParaEntrega.Logica.Mapa;

/**
 * Representa un Nivel del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Nivel
{
	
	//Atributos de Clase
	protected Mapa mapa;
	protected Bloque bloqueActual; //Bloque en el que está el Jugador.
	protected int id;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea el Nivel i.
	 * 
	 * @param i Nivel a inicializar.
	 */
	public Nivel (int i)
	{
		switch (i)
		{
			case 1: crearNivel1 ();
		}	
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	public void setBloqueActual (Bloque bloque)
	{
		bloqueActual = bloque;
	}
	
	/**
	 * Crea el Nivel 1.
	 */
	private void crearNivel1 ()
	{
		//mapa = new Mapa ();
	}
	
	/* CONSULTAS*/
	
	/**
	 * Devuelve el mapa correspondiente al nivel.
	 * 
	 * @return el mapa del nivel.
	 */
	public Mapa getMapa ()
	{
		return mapa;
	}
	
	/**
	 * Retorna el bloque actual donde se encuentra el personaje del jugador dentro del nivel.
	 * 
	 * @return el bloque actual donde se encuentra el jugador. 
	 */
	public Bloque getBloqueActual ()
	{
		return bloqueActual;
	}

}