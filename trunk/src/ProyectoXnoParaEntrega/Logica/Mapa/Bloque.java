package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Excepciones.BoundaryViolationException;
import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;

/**
 * Representa una parte de la totalidad del Mapa del juego.
 * 
 * El Bloque est� representado por un Arreglo Bidimensional de Celdas o ABC.
 * 
 * Para el cliente, la posici�n en el extremo superior izquierdo del ABC es (0,0).
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Bloque
{
	
	//Variables de Instancia
	protected Celda[][] ABC; //Arreglo Bidimensional de Celdas
	protected int nivelPiso; //Representa el nivel del Piso en el Mapa.
	                         //Si hay el bloque tiene piso, entonces 0<=nivelPiso<getFilas()
	                         //Si nivelPiso = -1, entonces el Bloque no tiene piso.
	
	/*CONSTRUCTOR*/
	
	/**
	 * Crea un Bloque de Filas = cantFilas y Columnas = cantColumnas.
	 * Inicia con posici�n del nivel del Piso con cantFilas-2.
	 * Crea una Celda para cada posici�n del ABC.
	 * 
	 * @param cantFilas Cantidad de filas del nuevo Bloque.
	 * @param cantColumnas Cantidad de columnas del nuevo Bloque.
	 * @exception BoundaryViolationException Si se ingrensa valores incorrectos del tama�o del Bloque.
	 */
	public Bloque (int cantFilas, int cantColumnas) throws BoundaryViolationException
	{
		if ((cantFilas < 0) || (cantFilas < 0))
			throw new BoundaryViolationException ("Imposible armar un Bloque de " + cantFilas + " filas X " + cantColumnas + " calumnas.");
		ABC = new Celda[cantFilas][cantColumnas];
		nivelPiso = cantFilas-2;
		crearCeldas();
	}
	
	/*COMANDOS*/
	
	/**
	 * Crea y asigna todas las Celdas al ABC.
	 */
	private void crearCeldas ()
	{
		for (int i=0; i < getFilas(); i++)
			for (int j=0; j < getColumnas(); j++)
				ABC[i][j] = new Celda (esPiso(i,j), i, j);
	}
	
	/**
	 * Cambia el nivel del piso del bloque.
	 * 
	 * Si hay el bloque tiene piso, entonces 0<=nivelPiso<getFilas()
	 * Si nivelPiso = -1, entonces el Bloque no tiene piso.
	 * 
	 * @param nivel Nuevo nivel del piso.
	 * @exception BoundaryViolationException Si el nivel ingresado no existe en este Bloque.
	 */
	public void setNivelPiso (int nivel) throws BoundaryViolationException
	{
		if ((nivel < -1) || (nivel >= getFilas()))
			throw new BoundaryViolationException ("Imposible setear el piso del Bloque en " + nivel + ".");
		if (nivelPiso != nivel)
		{
			setFilaOcupada(nivelPiso, false);//Actualiza las Celdas poniendolas como no piso.
			nivelPiso = nivel;
			if (nivel != -1)
				setFilaOcupada(nivelPiso, true);//Atualiza las Celdas poniendolas como piso.
		}
	}
	
	/**
	 * Pone a todas las Celdas de la Fila indicada como totalmenteOcupada = ocupada.
	 * 
	 * @param fila Fila de las Celdas a cambiar.
	 * @param ocupada Valor de totalmenteOcupada de las Celdas a cambiar.
	 * @exception BoundaryViolationException Si se ingresa una Fila que no existe en el Bloque. 
	 */
	public void setFilaOcupada (int fila, boolean ocupada) throws BoundaryViolationException
	{
		if ((fila < 0) || (fila >= getFilas()))
			throw new BoundaryViolationException ("No exite fila en el Bloque igual a " + fila + ".");
		for (int j=0; j < getColumnas(); j++)
			ABC[fila][j].totalmenteOcupada = ocupada;
	}
	
	/**
	 * Pone a todas las Celdas de la Columna indicada como totalmenteOcupada = ocupada.
	 * 
	 * @param columna Columna de las Celdas a cambiar.
	 * @param ocupada Valor de totalmenteOcupada de las Celdas a cambiar.
	 * @exception BoundaryViolationException Si se ingresa una Columna que no existe en el Bloque.
	 */
	public void setColumnaOcupada (int columna, boolean ocupada) throws BoundaryViolationException
	{
		if ((columna < 0) || (columna >= getColumnas()))
			throw new BoundaryViolationException ("No exite columna en el Bloque igual a " + columna + ".");
		for (int i=0; i < getFilas(); i++)
			ABC[i][columna].totalmenteOcupada = ocupada;
	}
	
	/*CONSULTAS*/
	
	/**
	 * Devuelve la cantidad de Filas del ABC.
	 * Pero para utilizar los m�todos de esta clase, la fila m�xima es getFilas()-1.
	 * 
	 * @return Cantidad de Filas del ABC.
	 */
	public int getFilas ()
	{
		return ABC.length;
	}
	
	/**
	 * Devuelve la cantidad de Columnas del ABC.
	 * Pero para utilizar los m�todos de esta clase, la columna m�xima es getColumnas()-1.
	 * 
	 * @return Cantidad de Columnas del ABC.
	 */
	public int getColumnas ()
	{
		return ABC[0].length;
	}
	
	/**
	 * Devuelve el nivel del piso del Bloque actual.
	 * 
	 * @return Nivel del piso del Bloque actual.
	 */
	public int getNivelPiso ()
	{
		return nivelPiso;
	}
	
	/**
	 * Verica si la pisici�n (x,y) pertence al piso del Bloque y devuelve el resultado.
	 * 
	 * @return True:  (x,y) pertence al piso del Bloque.
	 *         False: caso contrario.
	 * @exception PosicionIncorrectaException Si se ingresa una posici�n incorrecta.
	 */
	public boolean esPiso (int fila, int columna) throws PosicionIncorrectaException
	{
		verificarPosicion (fila, columna);
		return (fila == nivelPiso);
	}
	
	/**
	 * Verica si la pisici�n (x,y) es correcta y pertence al piso del Bloque.
	 * 
	 * @exception PosicionIncorrectaException Si se ingresa una posici�n incorrecta.
	 */
	private void verificarPosicion (int fila, int columna) throws PosicionIncorrectaException
	{
		if ((fila < 0) || (fila >= getFilas()) || (columna < 0) || (columna >= getColumnas()))
			throw new PosicionIncorrectaException ("No existe la posici�n (" + fila + "," + columna + ") en el Bloque.");
	}
	
	/**
	 * Verifica si la Celda es correcta.
	 * 
	 * @exception NullPointerException Si la Celda pasada por par�metro es null.
	 * @exception PosicionIncorrectaException Si se ingresa una Celda de una posici�n imposible o incorrecta para este Bloque.
	 */
	private void verificarCelda (Celda celda) throws NullPointerException, PosicionIncorrectaException
	{
		if (celda == null)
			throw new NullPointerException ("La celda es nula.");
		if ((celda.posFila < 0) || (celda.posFila >= getFilas()) || (celda.posColumna < 0) || (celda.posColumna >= getColumnas()))
			throw new PosicionIncorrectaException ("La posici�n de la Celda ingresada (" + celda.posFila + "," + celda.posColumna +") no corresponde con el Bloque actual.");
	}
	
	/**
	 * Devuelve la Celda a izquierda en el ABC de la Celda pasada por par�metro.
	 * 
	 * @param celda Celda a la que buscarle la Celda que est� a su izquierda.
	 * @return Celda a la izquierda en el ABC de la Celda pasada por par�metro.
	 * @exception NullPointerException Si la Celda pasada por par�metro es null.
	 * @exception PosicionIncorrectaException Si se pide una Celda en una posici�n imposible o incorrecta.
	 */
	public Celda getAnterior (Celda celda) throws NullPointerException, PosicionIncorrectaException
	{
		verificarCelda (celda);
		if (celda.posColumna == 0)
		    throw new PosicionIncorrectaException ("La primera celda de una fila no tiene anterior.");
		return ABC[celda.posFila][celda.posColumna - 1];	
	}
	
	/**
	 * Devuelve la Celda a derecha en el ABC de la Celda pasada por par�metro.
	 * 
	 * @param celda Celda a la que buscarle la Celda que est� a su derecha.
	 * @return Celda a la derecha en el ABC de la Celda pasada por par�metro.
	 * @exception NullPointerException Si la Celda pasada por par�metro es null.
	 * @exception PosicionIncorrectaException Si se pide una Celda en una posici�n imposible o incorrecta.
	 */
	public Celda getSiguiente (Celda celda) throws NullPointerException, PosicionIncorrectaException
	{
		verificarCelda (celda);
		if (celda.posColumna == getColumnas()-1)
		    throw new PosicionIncorrectaException ("La �ltima celda de la fila no tiene siguiente.");
    	return ABC[celda.posFila][celda.posColumna + 1];			
	}
	
	/**
	 * Devuelve la Celda por debajo en el ABC de la Celda pasada por par�metro.
	 * 
	 * @param celda Celda a la que buscarle la Celda que est� por debajo.
	 * @return Celda por debajo en el ABC de la Celda pasada por par�metro.
	 * @exception NullPointerException Si la Celda pasada por par�metro es null.
	 * @exception PosicionIncorrectaException Si se pide una Celda en una posici�n imposible o incorrecta.
	 */
	public Celda getInferior (Celda celda) throws NullPointerException, PosicionIncorrectaException
	{
		verificarCelda (celda);
		if (celda.posFila == getFilas()-1)
			throw new PosicionIncorrectaException ("La ultima celda de la fila no tiene inferior.");
		return ABC[celda.posFila + 1][celda.posColumna];	
	}
	
	/**
	 * Devuelve la Celda por encima en el ABC de la Celda pasada por par�metro.
	 * 
	 * @param celda Celda a la que buscarle la Celda que est� por encima.
	 * @return Celda por encima en el ABC de la Celda pasada por par�metro.
	 * @exception NullPointerException Si la Celda pasada por par�metro es null.
	 * @exception PosicionIncorrectaException Si se pide una Celda en una posici�n imposible o incorrecta.
	 */
	public Celda getSuperior (Celda celda) throws NullPointerException, PosicionIncorrectaException
	{
		verificarCelda (celda);
		if (celda.posFila == 0)
			throw new BoundaryViolationException ("La primera celda de la fila no tiene superior.");
		return ABC[celda.posFila - 1][celda.posColumna];	
	}
	
	/**
	 * Devuelve la Celda en la posici�n (fila,columna) en el ABC.
	 * 
	 * @param celda Celda a la que buscarle la Celda que est� a su izquierda.
	 * @return Celda a la izquierda en el ABC de la Celda pasada por par�metro.
	 * @exception PosicionIncorrectaException Si se ingresa una posici�n incorrecta.
	 */
	public Celda getCelda (int fila, int columna) throws PosicionIncorrectaException
	{
		verificarPosicion (fila, columna);
		return ABC[fila][columna];
	}

}