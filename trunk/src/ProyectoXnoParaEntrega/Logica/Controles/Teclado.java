package ProyectoXnoParaEntrega.Logica.Controles;

import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;

/**
 * Representa al Control Teclado.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Teclado implements Control, KeyListener, ActionListener
{
	
	//Variables de Instancia
	private boolean arriba, abajo, izquierda, derecha, A, B, ESC, aceptar;
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea un Control Teclado.
	 */
	public Teclado ()
	{
		arriba = abajo = izquierda = derecha = A = B = ESC = aceptar = false;
	}

	/*COMANDOS*/
	
	public void keyPressed (KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP : arriba = true;
			break;
			case KeyEvent.VK_DOWN : abajo = true;
			break;
			case KeyEvent.VK_LEFT : izquierda = true;
			break;
			case KeyEvent.VK_RIGHT : derecha = true;
			break;
			case KeyEvent.VK_A : A = true;
			break;
			case KeyEvent.VK_S : B = true;
			break;
			case KeyEvent.VK_ESCAPE : ESC = true;
			break;
			case KeyEvent.VK_ENTER : aceptar = true;
			break;
		}
	}

	public void keyReleased (KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP : arriba = false;
			break;
			case KeyEvent.VK_DOWN : abajo = false;
			break;
			case KeyEvent.VK_LEFT : izquierda = false;
			break;
			case KeyEvent.VK_RIGHT : derecha = false;
			break;
			case KeyEvent.VK_A : A = false;
			break;
			case KeyEvent.VK_S : B = false;
			break;
			case KeyEvent.VK_ESCAPE : ESC = false;
			break;
			case KeyEvent.VK_ENTER : aceptar = false;
			break;
		}
	}

	public void keyTyped (KeyEvent e) {}
	
	public void run()
	{
		EventObject o = new EventObject(this);
	}

}