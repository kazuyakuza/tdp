package ProyectoXnoParaEntrega.Logica.Mapa;

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
		return bloques[i];
	}
	
}