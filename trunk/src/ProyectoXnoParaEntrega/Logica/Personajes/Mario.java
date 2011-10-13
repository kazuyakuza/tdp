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
	 * Realiza la acci�n "arriba".
	 */
	public void arriba ()
	{
		saltar();
	}
	
	/**
	 * Realiza la acci�n "abajo".
	 */
	public void abajo ()
	{
		agacharse();
	}
	
	/**
	 * Realiza la acci�n "izquierda".
	 */
	public void izquierda ()
	{
		moverseAizquierda();
	}
	
	/**
	 * Realiza la acci�n "derecha".
	 */
	public void derecha ()
	{
		moverseAderecha();
	}
	
	/**
	 * Realiza la acci�n "A".
	 */
	public void A ()
	{
		accionA();
	}
	
	/**
	 * Realiza la acci�n "B".
	 */
	public void B ()
	{
		accionB();
	}
	
	/*COMANDOS ABSTRACTOS*/
	
	/**
	 * Mario realiza la acci�n de saltar.
	 */
	public abstract void saltar ();
	
	/**
	 * Mario realiza la acci�n de agacharse.
	 */
	public abstract void agacharse ();
	
	/**
	 * Mario realiza la acci�n de moverse hacia la izquierda.
	 */
	public abstract void moverseAizquierda ();
	
	/**
	 * Mario realiza la acci�n de moverse hace la derecha.
	 */
	public abstract void moverseAderecha ();
	
	/**
	 * Mario realiza la acci�n A.
	 */
	public abstract void accionA ();
	
	/**
	 * Mario realiza la acci�n B.
	 */
	public abstract void accionB ();

}