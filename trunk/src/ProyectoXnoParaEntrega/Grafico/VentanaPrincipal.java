package ProyectoXnoParaEntrega.Grafico;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ProyectoXnoParaEntrega.Logica.ControlCentral;

/**
 * Representa la Ventana Principal del juego donde se ejecuta el mismo.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame
{
	
	//Variables de Clase
	private int largo = 640;
	private int alto = 480;
	
	private String version = "Versión 0.1";
	private String[] autores = {"Javier Eduardo Barrocal","Pablo Isaias Chacar"};
	private String infoExtra = "";
	private String tituloJuego = "Mario TDP 2011";
	
	//Variables de Instancia
	private Menu menu;
	private PedirDatosJugador pnj;
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea una Ventana Principal, y un Menú dentro de la misma.
	 */
	public VentanaPrincipal ()
	{
		initGUI();
		
		//Posicionar VentanaPrincipal en el centro de la pantalla.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension tamanio = tk.getScreenSize();
		int pX = (int) tamanio.getWidth()/2 - (this.getWidth())/2;
		int pY = (int) tamanio.getHeight()/2 - (this.getHeight())/2;
		setLocation(pX, pY);
		
		setTitle(tituloJuego);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	/*COMANDOS*/
	
	/**
	 * Inicializa la GUI de la Ventana Principal.
	 */
	private void initGUI ()
	{
		try
		{
			setPreferredSize(new Dimension(largo, alto));
			{
				mostrarMenu();
			}
			setSize(largo, alto);
			pack();
		}
		catch (Exception e)
		{
		    mensajeError(this, "ERROR", e.getMessage());
		}
	}
	
	/**
	 * Crea un Menú y lo agrega a la Ventana.
	 */
	protected void mostrarMenu ()
	{
		menu = new Menu (this);
		this.add(menu);
	}
	
	/**
	 * Quita, limpia y elimina el Menú de la Ventana.
	 */
	protected void eliminarMenu ()
	{
		if (menu != null)
		{
			this.remove(menu);
			menu.limpiar();
			menu = null;
			this.repaint();
		}
	}
	
	/**
	 * Crea un Panel y lo agrega a la Ventana.
	 */
	protected void pedirDatosJugador ()
	{
		pnj = new PedirDatosJugador(this);
		this.add(pnj);
	}
	
	/**
	 * Quita, limpia y elimina el Panel de la Ventana.
	 */
	protected void eliminarPedirDatosJugador ()
	{
		if (pnj != null)
		{
			this.remove(pnj);
			pnj.limpiar();
			pnj = null;
			this.repaint();
		}
	}
	
	/**
	 * Crea un Nuevo Juego.
	 * 
	 * Crea un Escenario en un nuevo Thread.
	 * Crea un ControlCentral en un nuevo Thread.
	 * 
	 * @param nombreJugador Nombre del jugador del nuevo juego.
	 */
	public void nuevoJuego (String nombreJugador)
	{
		Escenario e = new Escenario(this);
		Thread t1 = new Thread (e);
		ControlCentral c = new ControlCentral(nombreJugador, e);
		Thread t2 = new Thread (c);
	}
	
	/**
	 * Muestra la Información del Juego.
	 */
	public void mostrarInfo ()
	{
		//mostrarInfo();
	}
	
	/**
	 * Cierra el Juego.
	 */
	public void salir ()
	{
		System.exit(0);
	}
	
	/*CONSULTAS*/
	
	/**
	 * Muestra un Mensaje de Error, con su título y mensaje, provocado por o en el Compenente ventana.
	 * 
	 * @param ventana Componente que llama a este método, donde se generó el error.
	 * @param titulo Título del Mensaje de Error.
	 * @param mensaje Mensaje del Error.
	 */
	public void mensajeError (Component ventana, String titulo, String mensaje)
	{
		JOptionPane.showMessageDialog(ventana,mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Devuelve el largo del frame dentro de la ventana.
	 * 
	 * @return Largo de la ventana.
	 */
	public int largo ()
	{
		return largo - 6;
	}
	
	/**
	 * Devuelve el alto del frame dentro de la ventana.
	 * 
	 * @return Alto de la ventana.
	 */
	public int alto ()
	{
		return alto - 26;
	}

}