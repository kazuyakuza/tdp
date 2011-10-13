package ProyectoXnoParaEntrega.Logica.Personajes;

/**
 * Representa al tipo de Personaje Mario del juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public abstract class Mario implements PjSeleccionable
{
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Realiza la acción "arriba".
	 */
	public void arriba ()
	{
		saltar();
	}
	
	/**
	 * Realiza la acción "abajo".
	 */
	public void abajo ()
	{
		agacharse();
	}
	
	/**
	 * Realiza la acción "izquierda".
	 */
	public void izquierda ()
	{
		moverseAizquierda();
	}
	
	/**
	 * Realiza la acción "derecha".
	 */
	public void derecha ()
	{
		moverseAderecha();
	}
	
	/**
	 * Realiza la acción "A".
	 */
	public void A ()
	{
		accionA();
	}
	
	/**
	 * Realiza la acción "B".
	 */
	public void B ()
	{
		accionB();
	}
	
	/*COMANDOS ABSTRACTOS*/
	
	/**
	 * Mario realiza la acción de saltar.
	 */
	public abstract void saltar ();
	
	/**
	 * Mario realiza la acción de agacharse.
	 */
	public abstract void agacharse ();
	
	/**
	 * Mario realiza la acción de moverse hacia la izquierda.
	 */
	public abstract void moverseAizquierda ();
	
	/**
	 * Mario realiza la acción de moverse hace la derecha.
	 */
	public abstract void moverseAderecha ();
	
	/**
	 * Mario realiza la acción A.
	 */
	public abstract void accionA ();
	
	/**
	 * Mario realiza la acción B.
	 */
	public abstract void accionB ();

}