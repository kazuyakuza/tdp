package ProyectoXnoParaEntrega.Grafico;

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
	
	private String version = "Versi�n 0.1";
	private String[] autores = {"Javier Eduardo Barrocal","Pablo Isaias Chacar"};
	private String infoExtra = "";
	private String tituloJuego = "Mario TDP 2011";
	
	//Variables de Instancia
	private Menu menu;
	private PedirDatosJugador pnj;
	private JPanel jPanelEscenario;
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea una Ventana Principal, y un Men� dentro de la misma.
	 */
	public VentanaPrincipal ()
	{
		initGUI();
		inicializacionVariables();
		
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
		    mensajeError("ERROR", e.getMessage(), true);
		}
	}
	
	/**
	 * Inicializa las Varaibles de la Ventana Principal.
	 */
	private void inicializacionVariables ()
	{
		menu = null;
		pnj = null;
		jPanelEscenario = null;
	}
	
	/**
	 * Crea un Men� y lo agrega a la Ventana.
	 */
	protected void mostrarMenu ()
	{
		menu = new Menu (this);
		this.add(menu);
	}
	
	/**
	 * Quita, limpia y elimina el Men� de la Ventana.
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
	 * Agrega el Escenario del juego a la Ventana Principal.
	 * 
	 * @param e Escenario a agregar.
	 */
	public void agregarEscenario (Escenario escenario)
	{
		jPanelEscenario = new JPanel();
		jPanelEscenario.setPreferredSize(new Dimension(largo,alto));
		jPanelEscenario.setLayout (null);
		jPanelEscenario.add(escenario);
		this.add(jPanelEscenario);
	}
	
	/**
	 * Elimina de la Ventana Principal el Escenario del Juego actual.
	 */
	public void quitarEscenarioActual ()
	{
		if (jPanelEscenario != null)
		{
			this.remove(jPanelEscenario);
			jPanelEscenario = null;
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
		ControlCentral cC = new ControlCentral(this, nombreJugador, e);
		Thread t = new Thread (cC);
		t.start();
	}
	
	/**
	 * Muestra la Informaci�n del Juego.
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
	 * Muestra un Mensaje de Error, con su t�tulo y mensaje, provocado por o en el Compenente ventana.
	 * 
	 * @param ventana Componente que llama a este m�todo, donde se gener� el error.
	 * @param titulo T�tulo del Mensaje de Error.
	 * @param mensaje Mensaje del Error.
	 */
	public void mensajeError (String titulo, String mensaje, boolean cerrar)
	{
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
//		Thread.currentThread().sleep(1000);
//		if (cerrar)
//			salir();
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