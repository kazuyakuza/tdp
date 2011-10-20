package ProyectoXnoParaEntrega.Logica.Mapa;

/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Nivel
{
	
	//Atributos de Clase
	protected Mapa mapa;
	protected Bloque bloqueActual;
	protected int id;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public Nivel (int i)
	{
		/*switch (i)
		{
			case 1: crearNivel1 ();
		}*/
		mapa = new Mapa(1);
		bloqueActual = mapa.bloque(1);
		id = i;
		
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	private void crearNivel1 ()
	{
		//mapa = new Mapa ();
	}
	
	/* CONSULTAS*/
	
	/**
	 * Devuelve el mapa correspondiente al nivel.
	 * @return el mapa del nivel.
	 */
	public Mapa getMapa ()
	{
		return mapa;
	}
	
	/**
	 * Retorna el bloque actual donde se encuentra el personaje del jugador dentro del nivel.
	 * @return el bloque actual donde se encuentra el jugador. 
	 */
	public Bloque getBloqueActual ()
	{
		return bloqueActual;
	}

}