package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Excepciones.InicioNivelException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;
import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Logica.NoPersonajes.Especiales.Llegada;
import ProyectoXnoParaEntrega.Logica.NoPersonajes.Plataformas.Irrompible;

/**
 * Representa un Nivel del Juego.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Nivel
{
	
	//Atributos de Clase
	private static final String dirRecursos = "Fondos/";
	
	//Atributos de Instancia
	protected Mapa mapa;
	protected Bloque bloqueActual; //Bloque en el que está el Jugador.
	protected int id;
	protected String fondo;
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea el Nivel i.
	 * 
	 * @param i Nivel a inicializar.
	 */
	public Nivel (int i)
	{
		id = i;
		bloqueActual = null;
		mapa = null;
		fondo = null;
	}
	
	/*COMANDOS*/
	
	/**
	 * Inicializa el Nivel creado.
	 * 
	 * @param actorJugador Actor del Jugador del Juego.
	 * @param cargadorSprite Clase encargada de cargar las imagenes de los Actores.
	 * @return Lista de Actores del Nivel creado.
	 * @exception InicioNivelException Si se produce un error al Iniciar el Nivel.
	 */
	public PositionList<Actor> inicializarNivel (Actor actorJugador, Actor llegada, CargadorSprite cargadorSprite) throws InicioNivelException
	{
		PositionList<Actor> listaActores = null;
		//try
		//{
			switch (id)
			{
				case 1:
					   {
						   listaActores = nivel1(actorJugador, llegada, cargadorSprite);
						   break;
					   }
				default:
				{
					throw new InicioNivelException ("El Nivel indicado no existe.");
				}
			}
		/*}
		catch (Exception e)
		{
			throw new InicioNivelException ("Error al Inicializar el Nivel " + id + "." + "\n" +
					                        "Detalles del Error: " + "\n" +
					                        e.getMessage());
		}*/
		return listaActores;
	}
	
	/**
	 * Crea el Nivel 1.
	 * 
	 * @param actorJugador Actor del Jugador del Juego.
	 * @param cargadorSprite Clase encargada de cargar las imagenes de los Actores.
	 * @return Lista de Actores del Nivel creado.
	 */
	private PositionList<Actor> nivel1 (Actor actor, Actor llegada, CargadorSprite cargadorSprite)
	{
		//Creación Bloque 1 del Nivel. Que es el Bloque de inicio del Nivel.
		bloqueActual = new Bloque(8, 10);//Nivel de Piso default.
		//Agregación Actor del Jugador.
		bloqueActual.ABC[5][1].agregarActor(actor);
		actor.setCeldaActual(bloqueActual.ABC[5][1]);
		//Agregación Actores no Personjes.
		Actor plataforma = new Irrompible (cargadorSprite);
		bloqueActual.ABC[3][3].agregarActor(plataforma);//Plataforma irrompible
		plataforma.setCeldaActual(bloqueActual.ABC[3][3]);
		bloqueActual.ABC[6][6].setOcupada(false);//Vacio en el Piso.
		bloqueActual.ABC[7][5].setOcupada(true);//Piso al costado del Vacio.
		bloqueActual.ABC[7][7].setOcupada(true);//Piso al costado del Vacio.
		//Agregación Principio Mapa
		bloqueActual.setColumnaOcupada(0, true);
		//Agregación Llegada
		/*bloqueActual.ABC[0][9].agregarActor(llegada);
		bloqueActual.ABC[1][9].agregarActor(llegada);
		bloqueActual.ABC[2][9].agregarActor(llegada);
		bloqueActual.ABC[3][9].agregarActor(llegada);
		bloqueActual.ABC[4][9].agregarActor(llegada);*/
		bloqueActual.ABC[5][9].agregarActor(llegada);
		llegada.setCeldaActual(bloqueActual.ABC[5][9]);
		
		//Creación de la lista de Actores que estarán en el Nivel y agregación de los Actores a la misma.
		PositionList<Actor> listaActores = new ListaPositionSimple<Actor> ();
		listaActores.addFirst(actor);
		listaActores.addFirst(plataforma);
		listaActores.addFirst(llegada);
		
		fondo = "Fondo1.png";
		
		return listaActores;
	}
	
	/**
	 * Cambia el Blque Actual por el Bloque pasadon por parámetro.
	 * 
	 * @param bloque Nuevo Bloque Actual.
	 */
	public void setBloqueActual (Bloque bloque)
	{
		bloqueActual = bloque;
	}
	
	/* CONSULTAS*/
	
	/**
	 * Devuelve el Mapa correspondiente al Nivel.
	 * 
	 * @return Mapa del Nivel.
	 */
	public Mapa getMapa ()
	{
		return mapa;
	}
	
	/**
	 * Devuelve el Bloque Actual del Nivel.
	 * 
	 * @return Bloque Actual del Nivel. 
	 */
	public Bloque getBloqueActual ()
	{
		return bloqueActual;
	}
	
	/**
	 * Devuelve el fondo actual del Nivel.
	 * 
	 * @return Fondo del Nivel.
	 */
	public String fondo ()
	{
		return dirRecursos + fondo;
	}

}