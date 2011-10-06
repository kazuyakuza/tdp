package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Grafico.Escenario;

/**
 * Representación gráfica del lugar donde acontecen todas las situaciones del juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class ControlCentral implements Runnable
{
	
	//Variables de Instancia
	private Escenario escenario;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public ControlCentral (String nB, Escenario e)
	{
		escenario = e;
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	public void run ()
	{
		
	}

}