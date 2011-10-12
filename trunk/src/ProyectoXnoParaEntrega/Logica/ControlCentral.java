package ProyectoXnoParaEntrega.Logica;

import ProyectoXnoParaEntrega.Grafico.Escenario;
import ProyectoXnoParaEntrega.Logica.Personajes.MarioChico;
import ProyectoXnoParaEntrega.Logica.Personajes.PjSeleccionable;

/**
 * Representa al Control Central del Juego.
 * 
 * Controla las situaciones que suceden en el Juego.
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
	private Jugador jugador;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Control Central con el Escenario e.
	 * 
	 * @param nJ Nombre Jugador.
	 * @param e Escenario donde llevar a cabo el juego.
	 */
	public ControlCentral (String nJ, Escenario e)
	{
		escenario = e;
		PjSeleccionable pjS = new MarioChico ();
		jugador = new Jugador (nJ, pjS);
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	public void run ()
	{
		
	}

}