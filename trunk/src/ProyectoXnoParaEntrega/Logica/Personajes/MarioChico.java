package ProyectoXnoParaEntrega.Logica.Personajes;

import java.util.Iterator;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;
import ProyectoXnoParaEntrega.Logica.Actor;
//import ProyectoXnoParaEntrega.Grafico.Sprite.SpriteManager;

import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;
import ProyectoXnoParaEntrega.Excepciones.SpriteException;


/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class MarioChico extends Mario
{
	/*ATRIBUTOS DE CLASE*/
	private static final String dirRecursos = "Mario/";
	private static final String [] nombresSprites = {dirRecursos+"Mario - dead.gif",dirRecursos+"Mario.gif",dirRecursos+"Mario - Walk1.gif",dirRecursos+"Mario - Walk2.gif",dirRecursos+"Mario - Walk3.gif",dirRecursos+"Mario - Jump.gif"};
	/*
	 * En este arreglo se encuentran todas las sprites correspondientes a MarioChico, la ubicación en los índices es:
	 * 0: Mario muere.
	 * 1: Mario quieto.
	 * 2: Mario camina1.
	 * 3: Mario camina2.
	 * 4: Mario camina3.
	 * 5: Mario salta.
	 */
	
	/*CONSTRUCTORES*/
	
	public MarioChico (CargadorSprite cargadorSprite)
	{
		super(nombresSprites,cargadorSprite);
	}
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Mario realiza la acción de saltar.
	 */
	public void saltar ()
	{
		try 
		{
			 spriteManager.cambiarSprite(5);			 
			 int i=0;
			 boolean terminar = false;
			 while (!terminar || i<4)			 
			 {
				 Celda celdaSuperior = celdaActual.getBloque().getSuperior(celdaActual);
				 if (!celdaSuperior.getOcupada())
				 {
					 producirColisiones(celdaSuperior);
					 celdaActual = celdaSuperior;
					 int[] pos = celdaSuperior.getPosicion();
					 spriteManager.actualizar(pos[0],pos[1]);
					 //Afectar con gravedad
				 }
				 else
					 terminar = true;
				 i++;
			 }			 
		}
		catch (SpriteException ex) {/*No pasa nunca.*/}
		catch (NullPointerException ex) {/*No pasa nunca.*/}
		catch (PosicionIncorrectaException ex) {}
	}
		
	/**
	 * Mario realiza la acción de moverse hacia la izquierda.
	 */
	public void moverseAizquierda ()
	{
		try 
		{
			 spriteManager.cambiarSprite(-2);
			 Celda celdaAnterior = celdaActual.getBloque().getAnterior(celdaActual);
			 if (!celdaAnterior.getOcupada())
			 {
				 producirColisiones(celdaAnterior);
				 celdaActual = celdaAnterior;
				 int[] pos = celdaAnterior.getPosicion();
				 spriteManager.actualizar(pos[0],pos[1]);				 
			 }
			 
		}
		catch (SpriteException ex) {/*No pasa nunca.*/}
		catch (NullPointerException ex) {/*No pasa nunca.*/}
		catch (PosicionIncorrectaException ex) {}		
	}
		
	/**
	 * Mario realiza la acción de moverse hace la derecha.
	 */
	public void moverseAderecha ()
	{
		try 
		{
			 spriteManager.cambiarSprite(2);
			 Celda celdaSiguiente = celdaActual.getBloque().getSiguiente(celdaActual);
			 if (!celdaSiguiente.getOcupada())
			 {
				 producirColisiones(celdaSiguiente);
				 celdaActual = celdaSiguiente;
				 int[] pos = celdaSiguiente.getPosicion();
				 spriteManager.actualizar(pos[0],pos[1]);				 
			 }
			 
		}
		catch (SpriteException ex) {/*No pasa nunca.*/}
		catch (NullPointerException ex) {/*No pasa nunca.*/}
		catch (PosicionIncorrectaException ex) {}	
	}
	
	/**
	 * Mario realiza la acción de agacharse.
	 */
	public void agacharse ()
	{
		
	}
	
	/**
	 * Mario realiza la acción A.
	 */
	public void accionA ()
	{
		
	}
		
	/**
	 * Mario realiza la acción B.
	 */
	public void accionB ()
	{
		
	}
	
	/**
	 * Realiza el efecto de crecer sobre Mario producido por un Super Hongo. Dicho efecto evoluciona a Mario.
	 */
	public void crecer ()
	{
		
	}
	
	/**
	 * Realiza la acción de ser colisionado por un enemigo.
	 */
	public void serDañado ()
	{
		
	}
	
}