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
	protected int tamaño;
	protected boolean invulnerable;//Representa el estado en que Mario puede o no ser dañado por los enemigos al colisionar.
	protected boolean destructor;//Representa el estado en que Mario puede o no matar a los enemigos al colisionar con ellos.
	
	/*CONSTRUCTOR*/
	
	protected Mario ()
	{
		tamaño = 1;
		invulnerable = false;
		destructor = false;
	}
	
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
	 * Mario realiza la acción de saltar.
	 */
	public abstract void saltar ();
		
	/**
	 * Mario realiza la acción de moverse hacia la izquierda.
	 */
	public abstract void moverseAizquierda ();
		
	/**
	 * Mario realiza la acción de moverse hace la derecha.
	 */
	public abstract void moverseAderecha ();
		
	/**
	 * Mario realiza la acción de agacharse.
	 */
	public abstract void agacharse ();
	
	/**
	 * Mario realiza la acción A.
	 */
	public abstract void accionA ();
		
	/**
	 * Mario realiza la acción B.
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
	 * @return verdadero si Mario está en estado destructor, falso en caso contrario.
	 */
	public boolean esDestructor ()
	{
		return destructor;
	}
	
	/*Métodos en Ejecución*/
	
	/**
	 * Realiza la acción de colisionar con otro Actor. Mario no provoca nada al colisionar con otros actores.
	 * Los efectos de la colisión la provocan los otros actores. 
	 */
	public void colisionar (Actor a)
	{
		
	}
}