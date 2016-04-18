package Mundo;

import java.util.ArrayList;

public class Empresa
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	
	
	
	
	//-----------------
	
	private String nombreEmpresa;
	private String ciudad;
	private String pais;
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	
	
	public Empresa(String nombreEmpresaE, String ciudadE, String paisE)
	{
		this.nombreEmpresa = nombreEmpresaE;
		this.ciudad = ciudadE;
		this.pais = paisE;
	}
	
	public String darNombreEmpresa()
	{
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresaE)
	{
		this.nombreEmpresa = nombreEmpresaE;
	}
	public String darCiudad()
	{
		return ciudad;
	}
	public void setCiudad(String ciudadE)
	{
		this.ciudad = ciudadE;
	}
	public String darPais()
	{
		return pais;
	}
	public void setPais(String paisE)
	{
		this.pais = paisE;
	}
	
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    private void verificarInvariante( )
    {
    	assert nombreEmpresa !=null && !nombreEmpresa.equals("") : "el nombre de la empresa es invalido";
    	assert ciudad != null && !ciudad.equals(""): "la ciudad de la empresa es invalida";
    	assert pais != null && !pais.equals(""): "el pais del que proviene la empresa es invalido";
    	
    }
	
}
