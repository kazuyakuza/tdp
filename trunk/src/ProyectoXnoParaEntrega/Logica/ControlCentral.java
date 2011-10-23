package ProyectoXnoParaEntrega.Logica;

import java.util.Iterator;

import ProyectoXnoParaEntrega.Grafico.BloqueGrafico;
import ProyectoXnoParaEntrega.Grafico.Escenario;
import ProyectoXnoParaEntrega.Grafico.VentanaPrincipal;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;
import ProyectoXnoParaEntrega.Logica.Controles.Control;
import ProyectoXnoParaEntrega.Logica.Controles.Teclado;
import ProyectoXnoParaEntrega.Logica.Mapa.Bloque;
import ProyectoXnoParaEntrega.Logica.Mapa.Nivel;
import ProyectoXnoParaEntrega.Logica.NoPersonajes.Especiales.Llegada;
import ProyectoXnoParaEntrega.Logica.Personajes.Mario;
import ProyectoXnoParaEntrega.Logica.Personajes.MarioChico;

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
	
	//Variables de Clase
	public static final int velocidad = 40;
	
	//Variables de Instancia
	private VentanaPrincipal ventanaPrincipal;
	private Escenario escenario;
	private CargadorSprite cargadorSprite;
	private Jugador jugador;
	private Nivel nivel;
	private PositionList<Actor> actores;
	private Gravedad gravedad;
	
	//Threads
	private Thread Tactual, Tescenario, Tjugador, Tgravedad;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Control Central con el Escenario e, para el usuario de nombre nJ, en la Ventana Principal ventana.
	 * 
	 * @param ventana Ventana Principal donde se va a ejecutar el Juego.
	 * @param nJ Nombre Jugador.
	 * @param e Escenario donde llevar a cabo la parte gráfica el juego.
	 */
	public ControlCentral (VentanaPrincipal ventana, String nJ, Escenario e)
	{
		//try
		//{
			Tactual = null;
			ventanaPrincipal = ventana;
			escenario = e;
			
			cargadorSprite = new CargadorSprite ();
		
			Mario PJ = new MarioChico (cargadorSprite);
			Control c = new Teclado();
			jugador = new Jugador (nJ, PJ, c, this);
			PJ.setJugador(jugador);
			
			actores = null;
			
			nivel = new Nivel(1);
			
			gravedad = new Gravedad(this);
			
			ventanaPrincipal.agregarEscenario(e);
			escenario.inicializarGrafica();
			escenario.agregarControl(c);
			ventanaPrincipal.repaint();
			
			//Crear y Asignar Threads
			Tescenario = new Thread(escenario);
			Tjugador = new Thread (jugador);
			Tgravedad = new Thread (gravedad);
		/*}
		catch (Exception exception)
		{
			ventanaPrincipal.mensajeError("Error", exception.getMessage(), true);
		}*/
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
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve el Jugador del juego.
	 * 
	 * @return Jugador del juego.
	 */
	public Jugador getJugador ()
	{
		return jugador;
	}
	
	/**
	 * Devuelve un iterador de los Actores actuales en Juego.
	 * 
	 * @return Iterador de los Actores actuales en Juego.
	 */
	public Iterator<Actor> getActores ()
	{
		return actores.iterator();
	}
	
	/*Métodos en Ejecución*/
	
	/**
	 * Run para el Thread de esta clase.
	 */
	public void run ()
	{
		//try
		//{
			//Inicialización Lógica.
			actores = nivel.inicializarNivel((Actor) jugador.personaje, this, cargadorSprite);
			
			//Inicialización Gráfica.
			Bloque bloqueActual = nivel.getBloqueActual();
			BloqueGrafico bloqueGrafico = new BloqueGrafico (bloqueActual.getFilas(), bloqueActual.getColumnas());
			//Agregando Piso
			bloqueGrafico.setNivelPiso(bloqueActual.getNivelPiso());
			for (Actor a: actores)
				bloqueGrafico.agregarSprite(a.spriteManager);
			escenario.agregarFondo(nivel.fondo(), cargadorSprite);
			escenario.setBloqueGraficoActual(bloqueGrafico);
			
			//Start Thread's
			Tescenario.start();
			Tjugador.start();
			Tgravedad.start();
			
			//Control Thread's
			//controlThreads();
		/*}
		catch (Exception exception)
		{
			ventanaPrincipal.mensajeError("Error", exception.getMessage(), true);
		}*/
	}
	
	/**
	 * 
	 */
	/*public void controlThreads ()
	{
		long startTime = 0;
		while (true)
		{
			startTime = System.currentTimeMillis();
			try {
				Tjugador.sleep(1000/velocidad);
				Tgravedad.sleep(1000/velocidad);
			    Tescenario.sleep(1000/velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	/**
	 * Inidica el tiempo de espera de actualización del Thread ingresado.
	 * 
	 * @param t Thread a pausar.
	 */
	/*public void esperar (Thread t)
	{
		long startTime = System.currentTimeMillis();
		do
		{
			Thread.yield();
		}
		while (System.currentTimeMillis()-startTime < (1000/velocidad));
	}*/
	
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
	
	/**
	 * Reinicia el nivel a una posición inicial.
	 */
	public void reiniciarNivel ()
	{
		
	}
	
	/**
	 * 
	 */
	public void ganarNivel ()
	{
		
	}

}