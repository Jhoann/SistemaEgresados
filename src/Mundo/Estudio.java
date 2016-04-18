package Mundo;

import java.util.ArrayList;
import java.util.Date;

public class Estudio 
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	

	//------------------------------------------------------------------
	private String descripcion;
	private String otorga;
	private String fecha;


	public Estudio(String otorgaE, String fechaE, String descripcionE)
	{
		this.otorga = otorgaE;
		this.fecha = fechaE;
		this.descripcion = descripcionE;
		verificarInvariante();
	}
	
	public String darDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcionE)
	{
		this.descripcion = descripcionE;
	}
	
	public String darOtorga()
	{
		return otorga;
	}
	
	public void setOtorga(String otorgaE)
	{
		this.otorga = otorgaE;
	}
	
	public String darFecha()
	{
		return fecha;
	}
	
	public void setFecha(String fechaE)
	{
		this.fecha = fechaE;
	}

	// -----------------------------------------------------------------
    // Invariante
	// -----------------------------------------------------------------
	private void verificarInvariante( )
	{
		assert otorga !=null && !otorga.equals("") : "quien otorga el acta de grado no es invalido";
		assert fecha != null && !fecha.equals("") : "la fecha que se ingreso es invalida";
		assert descripcion !=null && !descripcion.equals("") : "la descrpcion que se ingreso es invalida";
		
	}
}
