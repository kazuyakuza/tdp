package ProyectoXnoParaEntrega.Logica;

/**
 * 
 */
public class Nivel
{
	
	//Atributos de Clase
	protected Mapa mapa;
	
	/*CONSTRUCTOR*/
	
	/**
	 * 
	 */
	public Nivel (int i)
	{
		switch (i)
		{
			case 1: crearNivel1 ();
		}	
	}
	
	/*COMANDOS*/
	
	/**
	 * 
	 */
	private void crearNivel1 ()
	{
		mapa = new Mapa ();
	}

}