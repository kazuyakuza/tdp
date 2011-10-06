package ProyectoXnoParaEntrega.Grafico;

import java.awt.Canvas;
import java.awt.image.BufferedImage;

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
	 * 
	 */
	public void run()
	{
		
	}

}