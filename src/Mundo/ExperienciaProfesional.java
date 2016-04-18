package Mundo;

import java.util.ArrayList;

public class ExperienciaProfesional
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	
	private String cargo;
	private String fechaIngreso;
	private String salida;
	private String empresa;
	
	public ExperienciaProfesional(String cargoEP, String fechaIngresoEP, String salidaEP, String empresaEP)
	{
		this.cargo = cargoEP;
		this.fechaIngreso = fechaIngresoEP;
		this.salida = salidaEP;
		this.empresa = empresaEP;
		verificarInvariante();
	}
	
	public String darCargo()
	{
		return cargo;
	}
	
	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}
	
	public String darFechaIngreso()
	{
		return fechaIngreso;
	}
	
	public void setFechaIngreso(String fechaingreso)
	{
		this.fechaIngreso = fechaingreso;
	}
	
	public String darSalida()
	{
		return salida;
	}
	public String setSalida()
	{
		return salida;
	}
	public String darEmpresa()
	{
		return empresa;
	}
	public String setEmpresa()
	{
		return empresa;
	}
	
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
	
	private void verificarInvariante( )
    {
		assert cargo != null && !cargo.equals("") : "el cargo que se ingreso no es valido";
    	assert fechaIngreso != null && !fechaIngreso.equals("") : "la fecha de ingreso en la empresa no es valida";
    	assert salida != null && !salida.equals("") : "la fecha de salida de la empresa del egresado no es valida";
    	assert empresa != null && !empresa.equals("") : "la empresa ingresada no es valida";
    	
    }
}

