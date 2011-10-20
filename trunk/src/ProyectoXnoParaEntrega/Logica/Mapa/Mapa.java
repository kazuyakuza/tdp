package ProyectoXnoParaEntrega.Logica.Mapa;

import ProyectoXnoParaEntrega.Excepciones.BoundaryViolationException;
import ProyectoXnoParaEntrega.Excepciones.PosicionIncorrectaException;

/**
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
public class Mapa
{
	
	//Variables de Instancia
	protected Bloque[] bloques;
	protected int cant;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public Mapa (int i)
	{
		cant = i;
		bloques = new Bloque[cant];
	}
	
	/*CONSULTAS*/
	
	/**
	 * 
	 */
	public int cantBloques ()
	{
		return cant;
	}
	
	/**
	 * 
	 */
	public Bloque bloque (int i)
	{
		return bloques[i-1];
	}
	
	/**
	 * 
	 */
	public Bloque getSiguiente (Bloque b) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (b == null)
			throw new PosicionIncorrectaException("El bloque no es válido.");
		else
		   { int i = 0;
			 Bloque aux = bloques[i];
		   	 while (aux != b)
		   		 i++;
		   	 if (i == cant)
		   		 throw new BoundaryViolationException("Es el último bloque, no tiene siguiente.");
		   	 return bloques[i+1];
		   }		
	}	
	/**
	 * 
	 */
	public Bloque getAnterior (Bloque b) throws PosicionIncorrectaException, BoundaryViolationException
	{
		if (b == null)
			throw new PosicionIncorrectaException("El bloque no es válido.");
		else
		   { int i = 0;
			 Bloque aux = bloques[i];
		   	 while (aux != b)
		   		 i++;
		   	 if (i == 0)
		   		 throw new BoundaryViolationException("Es el primer bloque, no tiene anterior.");
		   	 return bloques[i+1];
		   }
	}
}