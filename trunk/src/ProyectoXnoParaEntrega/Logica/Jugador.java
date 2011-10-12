package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Logica.Personajes.PjSeleccionable;

/**
 * Representa a la Persona Jugador que juega el Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Jugador
{
	
	//Variables de Clase
	private static int vidasInicial = 5;
	private static int maxMonedas = 100;
	
	//Variables de Instancia
	protected int monedas, puntos, vidas;
	protected String nombre;
	protected PjSeleccionable personaje;
	protected boolean muerto;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Jugador con su respectivo nombre y personaje.
	 * 
	 * @param nom Nombre del Jugador.
	 * @param pj Personaje del Jugador.
	 */
	public Jugador (String nom, PjSeleccionable pj)
	{
		nombre = nom;
		personaje = pj;
		monedas = puntos = 0;
		vidas = vidasInicial;
		muerto = false;
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega una Moneda al Jugador.
	 * 
	 * Si la cantidad de Monedas es igual a 100, se suma una vida y la cantidad de monedas pasa a ser 0.
	 */
	public void agregarMoneda ()
	{
		monedas++;
		if (monedas == maxMonedas)
		{
			monedas = 0;
			agregarVida();
		}
	}
	
	/**
	 * Agrega una vida al Jugador.
	 */
	public void agregarVida ()
	{
		vidas++;
	}
	
	/**
	 * Quita una vida al Jugador.
	 */
	public void quitarVida ()
	{
		vidas--;
		if (vidas == 0)
			muerto = true;
	}
	
	/**
	 * Actualiza la cantidad de puntos del Jugador, sumando pts a sus puntos actuales.
	 * 
	 * @param pts Cantidad de puntos a sumar. (Restar si pts<0)
	 */
	public void asignarPuntos (int pts)
	{
		puntos += pts;
	}
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve la cantidad de monedas actual del Jugador.
	 * 
	 * @return Cantidad de monedas del Jugador.
	 */
	public int monedas ()
	{
		return monedas;
	}
	
	/**
	 * Devuelve la cantidad de puntos actual del Jugador.
	 * 
	 * @return Cantidad de puntos del Jugador.
	 */
	public int puntos ()
	{
		return puntos;
	}
	
	/**
	 * Devuelve la cantidad de vidas actual del Jugador.
	 * 
	 * @return Cantidad de vidas del Jugador.
	 */
	public int vidas ()
	{
		return vidas;
	}
	
	/**
	 * Devuelve el estado del Jugador.
	 * 
	 * @return True:  si vidas > 0.
	 *         False: si vidas = 0.
	 */
	public boolean muerto ()
	{
		return muerto;
	}
	
	/**
	 * Devuelve el nombre del Jugador.
	 * 
	 * @return Nombre del Jugador.
	 */
	public String nombre ()
	{
		return nombre;
	}
	
	/**
	 * Devuelve el Personaje actual del Jugador.
	 * 
	 * @return Personaje del Jugador.
	 */
	public PjSeleccionable personaje ()
	{
		return personaje;
	}

}