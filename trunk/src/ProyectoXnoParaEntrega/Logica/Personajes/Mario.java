package ProyectoXnoParaEntrega.Logica.Personajes;

import ProyectoXnoParaEntrega.Logica.Actor;

/**
 * Representa al tipo de Personaje Mario del juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public abstract class Mario extends Actor implements PjSeleccionable
{	
	
	//VARIABLES DE INSTANCIA
	protected int tama�o;
	protected boolean invulnerable;//Representa el estado en que Mario puede o no ser da�ado por los enemigos al colisionar.
	protected boolean destructor;//Representa el estado en que Mario puede o no matar a los enemigos al colisionar con ellos.
	
	/*CONSTRUCTOR*/
	
	protected Mario ()
	{
		tama�o = 1;
		invulnerable = false;
		destructor = false;
	}
	
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
	
	/*COMANDOS*/
	
	/**
	 * Modifica el estado invulnerable de Mario a "v".
	 * @param v es el nuevo estado de invulnerabilidad (verdadero o falso) de Mario.
	 */
	public void setInvulnerabilidad (boolean v)
	{
		invulnerable = v;
	}
	
	/**
	 * Modifica el estado de destructor de Mario a "v".
	 * @param v es el nuevo estado de destructor (verdadero o falso) de Mario.
	 */
	public void setDestructor (boolean v)
	{
		destructor = v;
	}
				
	/*COMANDOS ABSTRACTOS*/
		
	/**
	 * Mario realiza la acci�n de saltar.
	 */
	public abstract void saltar ();
		
	/**
	 * Mario realiza la acci�n de moverse hacia la izquierda.
	 */
	public abstract void moverseAizquierda ();
		
	/**
	 * Mario realiza la acci�n de moverse hace la derecha.
	 */
	public abstract void moverseAderecha ();
		
	/**
	 * Mario realiza la acci�n de agacharse.
	 */
	public abstract void agacharse ();
	
	/**
	 * Mario realiza la acci�n A.
	 */
	public abstract void accionA ();
		
	/**
	 * Mario realiza la acci�n B.
	 */
	public abstract void accionB ();
	
	/**
	 * Realiza el efecto de crecer sobre Mario producido por un Super Hongo. Dicho efecto evoluciona a Mario.
	 */
	public abstract void crecer ();
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve el estado de invulnerabilidad de Mario.
	 * @return verdadero si Mario es invulnerable, falso en caso contrario.
	 */
	public boolean esInvulnerable ()
	{
		return invulnerable;
	}
	
	/**
	 * Retorna el estado de destructor de Mario.
	 * @return verdadero si Mario est� en estado destructor, falso en caso contrario.
	 */
	public boolean esDestructor ()
	{
		return destructor;
	}
	
	/*M�todos en Ejecuci�n*/
	
	/**
	 * Realiza la acci�n de colisionar con otro Actor. Mario no provoca nada al colisionar con otros actores.
	 * Los efectos de la colisi�n la provocan los otros actores. 
	 */
	public void colisionar (Actor a)
	{
		
	}
}