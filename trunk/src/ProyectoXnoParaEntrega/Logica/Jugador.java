package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Logica.Personajes.Seleccionable;

/**
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
	protected Seleccionable personaje;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public Jugador (String nom)
	{
		nombre = nom;
		monedas = puntos = 0;
		vidas = vidasInicial;
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	public void agregarMoneda ()
	{
		if (monedas != maxMonedas)
			monedas++;
		else
		{
			monedas = 0;
			vidas++;
		}
	}
	
	/**
	 * 
	 */
	public void agregarVida ()
	{
		vidas++;
	}
	
	/**
	 * 
	 */
	public void quitarVida ()
	{
		vidas--;
	}
	
	/**
	 * 
	 */
	public void agregarPuntos (int pts)
	{
		puntos += pts;
	}
	
	/*CONSULTAS*/
	
	/**
	 * 
	 */
	public int monedas ()
	{
		return monedas;
	}
	
	/**
	 * 
	 */
	public int puntos ()
	{
		return puntos;
	}
	
	/**
	 * 
	 */
	public int vidas ()
	{
		return vidas;
	}
	
	/**
	 * 
	 */
	public String nombre ()
	{
		return nombre;
	}

}