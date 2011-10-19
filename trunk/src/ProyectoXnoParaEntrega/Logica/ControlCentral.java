package ProyectoXnoParaEntrega.Logica;

import sun.awt.windows.ThemeReader;
import ProyectoXnoParaEntrega.Grafico.Escenario;
import ProyectoXnoParaEntrega.Grafico.VentanaPrincipal;
import ProyectoXnoParaEntrega.Logica.Controles.Control;
import ProyectoXnoParaEntrega.Logica.Controles.Teclado;
import ProyectoXnoParaEntrega.Logica.Personajes.MarioChico;
import ProyectoXnoParaEntrega.Logica.Personajes.PjSeleccionable;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;

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
	private PositionList<Actor> actores;
	
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
		Tactual = null;
		ventanaPrincipal = ventana;
		escenario = e;
		
		PjSeleccionable pjS = new MarioChico ();
		Control c = new Teclado();
		jugador = new Jugador (nJ, pjS, c);
		
		actores = new ListaPositionSimple<Actor> ();
		
		actores.addLast(pjS);
		
		//Metodos Pre Inicialización ("de agregado")
		ventanaPrincipal.agregarEscenario(e);
		escenario.agregarControl(c);
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega el Thread que ejecutará el run de esta clase.
	 * 
	 * @param t Thread para esta clase.
	 */
	public void agregarThread (Thread t)
	{
		if (Tactual == null)
			Tactual = t;
	}
	
	/*Métodos en Ejecución*/
	
	/**
	 * 
	 */
	public void run ()
	{
		Tescenario = new Thread(escenario);
		Tjugador = new Thread (jugador);
		
		//Start Thread's
		Tescenario.start();
		Tjugador.start();
	}
	
	/**
	 * Acción ESC (escape) del Juego.
	 * 
	 * Abre un menú de salida del Juego.
	 */
	public void ESC ()
	{
		//menú para salir de la partida
	}
	
	/**
	 * Acción aceptar del Juego.
	 */
	public void aceptar ()
	{
		//pausa
	}

}