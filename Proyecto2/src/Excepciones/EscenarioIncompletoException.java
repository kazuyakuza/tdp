package ProyectoX.Excepciones;

/**
 * Excepción producida al manipular un Escenario incompleto.
 * 
 * Proyecto X
 * 
 * @author Javier Eduardo Barrocal LU:87158
 * @author Pablo Isaias Chacar LU:67704
 */
@SuppressWarnings("serial")
public class EscenarioIncompletoException extends RuntimeException
{

	/**
	 * Recibe la información del error, y crea la excepción.
	 * 
	 * @param error Información del error.
	 */
	public EscenarioIncompletoException (String error)
	{
		super(error);
	}
	
}