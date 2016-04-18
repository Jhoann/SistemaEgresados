package Mundo;

import java.util.ArrayList;

public class Red 

{

	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	
	
	private String nombreRed;
	private String anoCreacion;
	private String nombreDirector;
	private String emailRed;
	
	
	public Red(String nombreRedR, String anoCreacionR, String nombreDirectorR, String emailRedR)
	{
		this.nombreRed = nombreRedR;
		this.anoCreacion = anoCreacionR;
		this.nombreDirector = nombreDirectorR;
		this.emailRed = emailRedR;
		verificarInvariante();
	}
	
	public String darNombreRed()
	{
		return nombreRed;
	}
	
	public void setNombreRed(String nombreRedR)
	{
		this.nombreRed = nombreRedR;
	}
	
	public String darAnoCreacion()
	{
		return anoCreacion;
	}
	
	public void setAnoCreacion(String anoCreacionR)
	{
		this.anoCreacion = anoCreacionR;
	}
	public String darNombreDirector()
	{
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirectorR)
	{
		this.nombreDirector = nombreDirectorR ;
	}
	public String darEmailRed()
	{
		return emailRed;
	}
	public void setEmailRed(String emailRedR)
	{
		this.emailRed = emailRedR;
	}
	
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    private void verificarInvariante( )
    {
    	assert nombreRed != null && !nombreRed.equals("") : "el nombre de la red a la que pertenece el egresado es invalida";
    	assert anoCreacion != null && !anoCreacion.equals(""): "el a�o de creacion de la red a la que pertenece el egresado es invalida";
    	assert nombreDirector !=null && !nombreDirector.equals("") : "el nombre del director es invalido";
    	assert emailRed !=null && !emailRed.equals("") : "el email de la red es invalido";
    	
    }
	
}
