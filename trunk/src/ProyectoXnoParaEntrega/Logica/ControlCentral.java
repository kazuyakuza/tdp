package ProyectoXnoParaEntrega.Logica;

import sun.awt.windows.ThemeReader;
import ProyectoXnoParaEntrega.Grafico.Escenario;
import ProyectoXnoParaEntrega.Grafico.VentanaPrincipal;
import ProyectoXnoParaEntrega.Logica.Controles.Control;
import ProyectoXnoParaEntrega.Logica.Controles.Teclado;
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
	private VentanaPrincipal ventanaPrincipal;
	private Escenario escenario;
	private Jugador jugador;
	
	//Threads
	private Thread Tactual, Tescenario, Tjugador; 
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Control Central con el Escenario e.
	 * 
	 * @param ventana Ventana Principal donde se va a ejecutar el Juego.
	 * @param nJ Nombre Jugador.
	 * @param e Escenario donde llevar a cabo el juego.
	 */
	public ControlCentral (VentanaPrincipal ventana, String nJ, Escenario e)
	{
		Tactual = Thread.currentThread();
		ventanaPrincipal = ventana;
		escenario = e;
		
		Tescenario = new Thread(escenario);
		
		PjSeleccionable pjS = new MarioChico ();
		Control c = new Teclado();
		jugador = new Jugador (nJ, pjS, c);
		Tjugador = new Thread (jugador);
	
		
		ventanaPrincipal.agregarEscenario(e);
		
		//Start Thread
		Tescenario.start();
		Tjugador.start();
	}
	
	/*COMANDOS*/
	
	/*Métodos en Ejecución*/
	
	/**
	 * 
	 */
	public void run ()
	{
		
	}

}