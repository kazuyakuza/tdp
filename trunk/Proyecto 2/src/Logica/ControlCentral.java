package ProyectoXnoParaEntrega.Logica;

import java.util.Iterator;

import ProyectoXnoParaEntrega.Grafico.BloqueGrafico;
import ProyectoXnoParaEntrega.Grafico.Escenario;
import ProyectoXnoParaEntrega.Grafico.VentanaPrincipal;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.Position;
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
	 * @param e Escenario donde llevar a cabo la parte gr�fica el juego.
	 */
	public ControlCentral (VentanaPrincipal ventana, String nJ, Escenario e)
	{
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
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega el Thread que ejecutar� el run de esta clase.
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
		PositionList<Actor> a = new ListaPositionSimple<Actor> ();
		a.addFirst((Actor) jugador.personaje());
		return a.iterator();		
	}
	
	/*M�todos en Ejecuci�n*/
	
	/**
	 * Run para el Thread de esta clase.
	 */
	public void run ()
	{
		actores = nivel.inicializarNivel((Actor) jugador.personaje, this, cargadorSprite);
			
		//Inicializaci�n Gr�fica.
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
	}
			
	/**
	 * Acci�n ESC (escape) del Juego.
	 * 
	 * Abre un men� de salida del Juego.
	 */
	public void ESC ()
	{
		//men� para salir de la partida
	}
	
	/**
	 * Acci�n aceptar del Juego.
	 */
	public void aceptar ()
	{
		//pausa
	}
	
	/**
	 * 
	 */
	public void ganarNivel ()
	{
		Position<Actor> p = actores.first();
		while (p.element() != jugador.personaje())
			p = actores.next(p);
		actores.remove(p);
		
		gravedad.setAfectar(false);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		escenario.setActualizar(false);
		ventanaPrincipal.mensajeError("Fin del Juego", "Ganaste", true);
	}
	
	/**
	 * Reinicia el nivel a una posici�n inicial.
	 */
	public void reiniciarNivel ()
	{
		
	}
	
	/**
	 * 
	 */
	public void perderNivel ()
	{
		Position<Actor> p = actores.first();
		while (p.element() != jugador.personaje())
			p = actores.next(p);
		actores.remove(p);
		
		gravedad.setAfectar(false);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		escenario.setActualizar(false);
		ventanaPrincipal.mensajeError("Perdiste", "Perdiste", true);
	}

}