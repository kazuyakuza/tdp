package ProyectoXnoParaEntrega.Logica.Personajes;

import java.util.Iterator;

import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;
import ProyectoXnoParaEntrega.Excepciones.SpriteException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Logica.Jugador;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;

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
	
	protected boolean invulnerable;//Representa el estado en que Mario puede o no ser dañado por los enemigos al colisionar.
	protected boolean destructor;//Representa el estado en que Mario puede o no matar a los enemigos al colisionar con ellos.
	protected Jugador jugador;
	
	/*CONSTRUCTOR*/
	
	protected Mario (String[] nombresSprites, CargadorSprite cargadorSprite)
	{
		super (nombresSprites, cargadorSprite);
		invulnerable = false;
		destructor = false;
	}
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Realiza la acción "arriba".
	 */
	public void arriba ()
	{
		bajoGravedad = false;
		saltar();
		bajoGravedad = true;
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
	
	/**
	 * Realiza la Acción caer, producida por el efecto de la gravedad. 
	 */
	public void caer ()
	{
		try 
		{			 
			 Celda celdaInferior = celdaActual.getBloque().getInferior(celdaActual);
			 if (!celdaInferior.getOcupada())
			 {
				 producirColisiones(celdaInferior);
				 celdaActual = celdaInferior;
				 int[] pos = celdaInferior.getPosicion();
				 spriteManager.actualizar(pos[0],pos[1]);				 
			 }
			 
		}
		catch (SpriteException ex) {/*No pasa nunca.*/}
		catch (NullPointerException ex) {/*No pasa nunca.*/}
		catch (PosicionIncorrectaException ex) {}	
	}
	
	/**
	 * Realiza la acción de morir (ser destruido) de Mario.
	 */
	public void morir ()
	{
		jugador.quitarVida();
	}
	
	/*COMANDOS*/
	
	/**
	 * Realiza las colisiones de Mario con los actores que se encuentran en la celda c.
	 * @param c es la celda con los actores a colisionar con Mario. 
	 */
	protected void producirColisiones (Celda c)
	{
		Iterator <Actor> actores = c.getActores();
		while (actores.hasNext())
			actores.next().colisionarPj(this);		
	}
	
	/**
	 * Setea al jugador que controla a Mario con j.
	 * @param j es el jugador de Mario.
	 */
	public void setJugador (Jugador j)
	{
		jugador = j;
	}
			
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
	 * Devuelve el jugador que controla a Mario.
	 * @return el jugador que controla a Mario.
	 */
	public Jugador getJugador ()
	{
		return jugador;
	}
	
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
	
	/**
	 * Realiza la acción de colisionar con otro personaje. Mario no provoca nada al colisionar con otro personaje.	 
	 */
	public void colisionarPj (Actor actorJugador)
	{
		
	}
}