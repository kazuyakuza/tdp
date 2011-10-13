package ProyectoXnoParaEntrega.Grafico;

import java.awt.Canvas;
import java.awt.image.BufferedImage;

import sun.awt.windows.ThemeReader;

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
	
	//Variables de Instancia
	private VentanaPrincipal ventanaPrincipal;
	private BufferedImage fondo;
	
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
	 * 
	 */
	public void limpiar ()
	{
		
	}
	
	/*Métodos en Ejecución*/
	
	/**
	 * 
	 */
	public void run ()
	{
		
	}

}