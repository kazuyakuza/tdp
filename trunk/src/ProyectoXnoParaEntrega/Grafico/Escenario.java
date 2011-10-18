package ProyectoXnoParaEntrega.Grafico;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;
import ProyectoXnoParaEntrega.Logica.Controles.Control;

/**
 * Representación gráfica del lugar donde acontecen todas las situaciones del juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
@SuppressWarnings("serial")
public class Escenario extends Canvas implements Runnable
{
	
	//Variables de Clase
	private final int medidaPixelCelda = 32;//Medida de un lado en pixeles de una celda del ABG.
	
	//Variables de Instancia
	private VentanaPrincipal ventanaPrincipal;
	private BufferedImage fondo;
	private BufferStrategy bufferStrategy;
	private BloqueGrafico anterior, actual, siguiente;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Escenario vacío.
	 * 
	 * @param vP Ventana Principal del Juego.
	 */
	public Escenario (VentanaPrincipal vP)
	{
		super();
		ventanaPrincipal = vP;
		fondo = null;
		anterior = null;
		actual = null;
		siguiente = null;
		
		metodosGraficos();
	}
	
	/**
	 * Métodos Gráficos llamados en el Constructor.
	 */
	private void metodosGraficos ()
	{
		this.setIgnoreRepaint(true);
		this.createBufferStrategy(2);
		bufferStrategy = getBufferStrategy();
		
		//Pone transparente el cursor.
		BufferedImage cursor = new CargadorSprite().crearCombatible(10, 10, Transparency.BITMASK);
		Toolkit t = Toolkit.getDefaultToolkit();
		Cursor c = t.createCustomCursor(cursor, new Point(5,5), "null");
		this.setCursor(c);
	}
	
	/*COMANDOS*/
	
	/**
	 * Agrega el Control c usado por el usuario al escenario.
	 * 
	 * @param c Control del usuario.
	 */
	public void agregarControl (Control c)
	{
		this.addKeyListener(c);
	}
	
	/**
	 * Cambia el BloqueGrafico anterior por el pasado por parámetro bg.
	 * 
	 * @param bg Nuevo BloqueGrafico.
	 */
	public void setBloqueGraficoAnterior (BloqueGrafico bg)
	{
		anterior = bg;
	}
	
	/**
	 * Devuelve el BloqueGrafico anterior.
	 * 
	 * @return BloqueGrafico anterior.
	 */
	public BloqueGrafico getBloqueGraficoAnterior ()
	{
		return anterior;
	}
	
	/**
	 * Cambia el BloqueGrafico actual por el pasado por parámetro bg.
	 * 
	 * @param bg Nuevo BloqueGrafico.
	 */
	public void setBloqueGraficoActual (BloqueGrafico bg)
	{
		actual = bg;
	}
	
	/**
	 * Devuelve el BloqueGrafico actual.
	 * 
	 * @return BloqueGrafico actual.
	 */
	public BloqueGrafico getBloqueGraficoActual ()
	{
		return actual;
	}
	
	/**
	 * Cambia el BloqueGrafico siguiente por el pasado por parámetro bg.
	 * 
	 * @param bg Nuevo BloqueGrafico.
	 */
	public void setBloqueGraficosiguiente (BloqueGrafico bg)
	{
		siguiente = bg;
	}
	
	/**
	 * Devuelve el BloqueGrafico siguiente.
	 * 
	 * @return BloqueGrafico siguiente.
	 */
	public BloqueGrafico getBloqueGraficosiguiente ()
	{
		return siguiente;
	}
	
	/**
	 * 
	 */
	public void limpiar ()
	{
		fondo = null;
		anterior = null;
		actual = null;
		siguiente = null;
	}
	
	/*Métodos en Ejecución*/
	
	/**
	 * 
	 */
	public void run ()
	{
		
	}
	
	/**
	 * 
	 */
	public void imprimirBloque () throws PosicionIncorrectaException
	{
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		for (SpriteManager sp: sprites)
		{
			int x = (int) (sp.posicion()[0] * medidaPixelCelda);
			int y = (int) (sp.posicion()[1] * medidaPixelCelda);
			g.drawImage(sp.getSprite(), x, y, e);
		}
	}

}