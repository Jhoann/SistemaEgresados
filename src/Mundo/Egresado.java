	package Mundo;

import java.util.ArrayList;
import java.io.Serializable;

public class Egresado 

{
	
	
	
	private String cedulaE;
	private String nombresE;
	private String apellidosE;
	private String direccionE;
	private String emailE;
	private int telefonoE;
	
	
	
	
	
	//Constructor

	public Egresado(String cedulaEgresadoE, String nombresEgresadoE, String apellidosEgresadoE,
			String direccionEgresadoE, String emailEgresadoE, int telefonoEgresadoE)
	{
		
		
		this.cedulaE = cedulaEgresadoE;
		this.nombresE = nombresEgresadoE;
		this.apellidosE = apellidosEgresadoE;
		this.direccionE = direccionEgresadoE;
		this.emailE = emailEgresadoE;
		this.telefonoE = telefonoEgresadoE;
		
		
		verificarInvariante();
	}
	
	public String darCedulaE(){
		return cedulaE;
	}
	
	public void setCedula(String cedulaEgresadoE){
		this.cedulaE = cedulaEgresadoE;
	}

	public String darNombreEgresado(){
			return nombresE;
	}

	public void setNombreEgresado(String nombresEgresadoE){
		this.nombresE = nombresEgresadoE;
	}
	
	public String darApellidoEgresado(){
		return apellidosE;
	}
	
	public void setApellidos( String apellidosEgresadoE){
		this.apellidosE = apellidosEgresadoE;
	}
	public String darDireciccionE(){
		return direccionE;
	}
	
	public void setDireccionE(String direccionEgresadoE){
		this.direccionE = direccionEgresadoE;
	}
	
	public String darEmail(){
		return emailE;
	}
	
	public void setEmail(String emailEgresadoE){
		this.emailE = emailEgresadoE;
	}
	
	public int darTelefono(){
		return telefonoE;
	}
	
	public void setTelefono(int telefonoEgresadoE){
		this.telefonoE = telefonoEgresadoE;
	}

			
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    private void verificarInvariante( )
    {
    	assert cedulaE != null && !cedulaE.equals("") : "el numero de cedula del egresado debe ser positivo";
    	assert nombresE != null && !nombresE.equals(""): "el nombre para el nuevo egresadoes es invalido";
    	assert apellidosE !=null && !apellidosE.equals("") : "el apellido del egresado es invalido";
    	assert direccionE !=null && !direccionE.equals("") : "la direccion del egresado es invalida";
    	assert emailE != null && !emailE.equals("") : "el email del egresado es invalido";
    	assert 0 <= telefonoE : "el telefono del egresado es invalido";
    	
    //---------------------------------	
    	
    }
    
}
