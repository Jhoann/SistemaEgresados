package Mundo;

public class ElementoExisteException  extends Exception

{
	public ElementoExisteException(String cedulaEgresadoE)
	{
		super("Ya existe el egresado con el N° de cedula " + cedulaEgresadoE);
	}

}

