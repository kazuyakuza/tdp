package ProyectoXnoParaEntrega.Logica.Personajes;

import ProyectoXnoParaEntrega.Excepciones.AccionActorException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Logica.Mapa.Celda;


/**
 * Representa a Mario Chico, uno de los Personajes Seleccionables por el Jugador en el Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class MarioChico extends Mario
{
	
	//Atributos de Clase
	private static final String dirRecursos = "Mario/";
	private static final String [] nombresSprites = //En este arreglo se encuentran todas las rutas a las imagenes correspondientes a MarioChico, la ubicaci�n en los �ndices es:
	                                                {dirRecursos + "Mario - dead.gif", //0: Mario muerto
		                                             dirRecursos + "Mario.gif",        //1: Mario quieto
		                                             dirRecursos + "Mario - Walk1.gif",//2: Mario caminando1
		                                             dirRecursos + "Mario - Walk2.gif",//3: Mario caminando2
		                                             dirRecursos + "Mario - Walk3.gif",//4: Mario caminando3
		                                             dirRecursos + "Mario - Jump.gif"};//5: Mario saltando
	private static int muerto = 0;
	private static int quieto = 1;
	private static int caminando = 2;
	private static int saltando = 5;
	
	private static int potenciaSalto = 4;
	
	/*CONSTRUCTORES*/
	
	/**
	 * Crea un Personaje Seleccionable Mario Chico.
	 * 
	 * @param cargadorSprite Clase para cargar los sprites.
	 */
	public MarioChico (CargadorSprite cargadorSprite)
	{
		super(nombresSprites, cargadorSprite);
		spriteManager.cambiarSprite(quieto);
	}
	
	/*COMANDOS IMPLEMENTADOS*/
	
	/**
	 * Mario realiza la acci�n de saltar.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al saltar.
	 */
	public void saltar () throws AccionActorException
	{
		Celda celdaSuperior = celdaActual;
		try 
		{
			if (PG == 0)
			{
				PG = potenciaSalto;
				spriteManager.cambiarSprite(saltando);
				int i=0;
				boolean terminar = false;
				while ((!celdaActual.getBloque().esLimite(celdaActual)) && !terminar && i<potenciaSalto)
				{
					celdaSuperior = celdaActual.getBloque().getSuperior(celdaActual);
					if (!celdaSuperior.isOcupada())
					{
						moverseAcelda(celdaSuperior);
						i++;
					}
					else
						terminar = true;				 
				}
				spriteManager.cambiarSprite(quieto);
			}
		}
		catch (Exception e)
		{
			throw new AccionActorException ("Imposible realizar la acci�n saltar a/desde Celda de posici�n (" + celdaSuperior.getPosFila() + "," + celdaSuperior.getPosColumna() + ")." + "\n" +
					                        "Detalles del error:" + "\n" +
					                        e.getMessage());
		}
	}
		
	/**
	 * Mario realiza la acci�n de moverse hacia la izquierda.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al moverse a izquierda.
	 */
	public void moverseAizquierda () throws AccionActorException
	{
		Celda celdaAnterior = celdaActual;
		try 
		{
			if (!celdaActual.getBloque().esLimite(celdaActual))
			{
				spriteManager.cambiarSprite(-caminando);
				celdaAnterior = celdaActual.getBloque().getAnterior(celdaActual);
				if (!celdaAnterior.isOcupada())
					moverseAcelda(celdaAnterior);
				spriteManager.cambiarSprite(-quieto);
			}
		}
		catch (Exception e)
		{
			throw new AccionActorException ("Imposible realizar la acci�n moverAizquierda a/desde Celda de posici�n (" + celdaAnterior.getPosFila() + "," + celdaAnterior.getPosColumna() + ")." + "\n" +
					                        "Detalles del error:" + "\n" +
					                        e.getMessage());
		}
	}
		
	/**
	 * Mario realiza la acci�n de moverse hace la derecha.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al moverse a derecha.
	 */
	public void moverseAderecha () throws AccionActorException
	{
		Celda celdaSiguiente = celdaActual;
		try 
		{
			if (!celdaActual.getBloque().esLimite(celdaActual))
			{
				spriteManager.cambiarSprite(caminando);
				celdaSiguiente = celdaActual.getBloque().getSiguiente(celdaActual);
				if (!celdaSiguiente.isOcupada())
					moverseAcelda(celdaSiguiente);
				spriteManager.cambiarSprite(quieto);
			}
		}
		catch (Exception e)
		{
			throw new AccionActorException ("Imposible realizar la acci�n moverAderecha a/desde Celda de posici�n (" + celdaSiguiente.getPosFila() + "," + celdaSiguiente.getPosColumna() + ")." + "\n" +
					                        "Detalles del error:" + "\n" +
					                        e.getMessage());
		}
	}
	
	/**
	 * Mario realiza la acci�n de agacharse.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al agacharse.
	 */
	public void agacharse () throws AccionActorException
	{
		
	}
	
	/**
	 * Mario realiza la acci�n A.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al realizar la acci�n A.
	 */
	public void accionA () throws AccionActorException
	{
		
	}
		
	/**
	 * Mario realiza la acci�n B.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al realizar la acci�n B.
	 */
	public void accionB () throws AccionActorException
	{
		
	}
	
	/**
	 * Realiza el efecto de crecer sobre Mario producido por un Super Hongo. Dicho efecto evoluciona a Mario.
	 * 
	 * @exception AccionActorException Si se produce alg�n error al crecer.
	 */
	public void crecer () throws AccionActorException
	{
		
	}
	
	/**
	 * Realiza la acci�n de ser colisionado por un enemigo.
	 */
	public void serDa�ado () throws AccionActorException
	{
		
	}
	
	/**
	 * Realiza la acci�n de morir (ser destruido) de Mario.
	 */
	public void morir ()
	{
		super.morir();
		spriteManager.cambiarSprite(muerto);
	}
	
}