package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Excepciones.InicioNivelException;
import ProyectoXnoParaEntrega.Grafico.Sprite.CargadorSprite;
import ProyectoXnoParaEntrega.Librerias.TDALista.ListaPositionSimple;
import ProyectoXnoParaEntrega.Librerias.TDALista.PositionList;
import ProyectoXnoParaEntrega.Logica.Actor;
import ProyectoXnoParaEntrega.Logica.ControlCentral;
import ProyectoXnoParaEntrega.Logica.NoPersonajes.Piso;
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
	protected Bloque bloqueActual; //Bloque en el que est� el Jugador.
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
	public PositionList<Actor> inicializarNivel (Actor actorJugador, ControlCentral cc, CargadorSprite cargadorSprite) throws InicioNivelException
	{
		PositionList<Actor> listaActores = null;
		switch (id)
		{
			case 1:
				   {
					   listaActores = nivel1(actorJugador, cc, cargadorSprite);
					   break;
				   }
			default:
				   {
					   throw new InicioNivelException ("El Nivel indicado no existe.");
				   }
		}		
		return listaActores;
	}
	
	/**
	 * Crea el Nivel 1.
	 * 
	 * @param actorJugador Actor del Jugador del Juego.
	 * @param cargadorSprite Clase encargada de cargar las imagenes de los Actores.
	 * @return Lista de Actores del Nivel creado.
	 */
	private PositionList<Actor> nivel1 (Actor actor, ControlCentral cc, CargadorSprite cargadorSprite)
	{
		//Creaci�n de la lista de Actores que estar�n en el Nivel.
		PositionList<Actor> listaActores = new ListaPositionSimple<Actor> ();
		
		//Creaci�n Bloque 1 del Nivel. Que es el Bloque de inicio del Nivel.
		bloqueActual = new Bloque(8, 10);//Nivel de Piso default.
		//Agregaci�n Piso
		int aux = 0;
		while (aux <= 9)
		{
			if (aux != 6)
			{
				Piso piso = new Piso(cargadorSprite);
				bloqueActual.ABC[6][aux].agregarEstructura(piso);
				piso.setCeldaActual(bloqueActual.ABC[6][aux]);
				listaActores.addFirst(piso);
			}
			aux++;
		}
		//Agregaci�n Actor del Jugador.
		bloqueActual.ABC[5][1].agregarActor(actor);
		actor.setCeldaActual(bloqueActual.ABC[5][1]);
		listaActores.addFirst(actor);
		//Agregaci�n Actores no Personjes.
		Irrompible plataforma = new Irrompible (cargadorSprite);
		bloqueActual.ABC[3][3].setOcupada(true);
		bloqueActual.ABC[3][3].agregarEstructura(plataforma);
		plataforma.setCeldaActual(bloqueActual.ABC[3][3]);
		listaActores.addFirst(plataforma);
		//Vacio en el Piso.
		bloqueActual.ABC[6][6].setOcupada(false);
		//Piso al costado del Vacio.
		bloqueActual.ABC[7][5].setOcupada(true);
		Piso piso = new Piso(cargadorSprite);
		bloqueActual.ABC[7][5].agregarEstructura(piso);
		piso.setCeldaActual(bloqueActual.ABC[7][5]);
		listaActores.addFirst(piso);
		//Piso al costado del Vacio.
		bloqueActual.ABC[7][7].setOcupada(true);
		Piso piso2 = new Piso(cargadorSprite);
		bloqueActual.ABC[7][7].agregarEstructura(piso2);
		piso2.setCeldaActual(bloqueActual.ABC[7][7]);
		listaActores.addFirst(piso2);
		//Agregaci�n Principio Mapa
		bloqueActual.setColumnaOcupada(0, true);
		//Agregaci�n Llegada
		aux = 0;
		while (aux <= 5)
		{
			Actor llegada = new Llegada(cc, cargadorSprite);
			bloqueActual.ABC[aux][9].agregarActor(llegada);
			llegada.setCeldaActual(bloqueActual.ABC[aux][9]);
			listaActores.addFirst(llegada);
			aux++;
		}
		
		fondo = "Fondo1.png";
		
		return listaActores;
	}
	
	/**
	 * Cambia el Blque Actual por el Bloque pasadon por par�metro.
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