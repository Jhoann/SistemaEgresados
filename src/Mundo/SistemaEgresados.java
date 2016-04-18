package Mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SistemaEgresados 

{
	 // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private ArrayList <Estudio> listaestudios;	
	private ArrayList <ExperienciaProfesional> listaexperiencias;
	private ArrayList <Red>listaredes; 
	private ArrayList <Empresa> listaempresas;
	
	private Estudio estudio;
	private ExperienciaProfesional experienciaprofesional ;
	private Red red;
	private Empresa empresa;
	
	private Egresado egresado;
	private ArrayList<Egresado> listaegresados;
	
	private int numEgresados;
		
	/**
     * Es el nombre del archivo de donde se cargan y salvan los egresados
     */
		
	//Constructor///
	
	public SistemaEgresados() 
	{
		listaegresados = new ArrayList <Egresado>();		
		numEgresados = 0;
		
		
		listaestudios = new ArrayList <Estudio>();
		listaexperiencias = new ArrayList <ExperienciaProfesional>();
		listaredes = new ArrayList <Red>();
		listaempresas = new ArrayList <Empresa>();
		
		verificarInvariante();
	}
	

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

	public ArrayList darEgresados()
	{
		return listaegresados;
	}
	
	/**
	 * busca el egresado en el ArrayList si ya existe lo agrega de lo contrario notificara el error
	 * @param cedulaEgresadoE cedula del egresado. cedula del egresado != null
	 * @return el egresado si lo encuentra o si no null
	 */
	public Egresado buscarEgresado(String cedulaEgresadoE)
	{
		Egresado elEgresado = null;
		boolean encontrado = false;
		if(listaegresados.size() != 0){
			for(int i = 0 ; i < listaegresados.size() && !encontrado;i++ )
			{
				Egresado miEgresado= (Egresado) listaegresados.get(i);
				if(miEgresado.darCedulaE().equals(cedulaEgresadoE))
				{
					elEgresado = miEgresado;
					encontrado = true;
				}

			}
		}
		return elEgresado;
	}

	/**
	 * agrega un nuevo egresado al ArrayList de listaegresados
	 * @param cedulaEgresadoE la cedula del egresado. la cedula debe ser diferente  de null
	 * @param nombresEgresadoE el nombre del egresado. el nombre del egresado debe ser diferente de null
	 * @param apellidosEgresadoE el apellido del egresado. el apellido del egresado debe ser diferente de null
	 * @param direccionEgresadoE la direccion del egresado. la direccion del egresado debe ser dieferente de null.
	 * @param emailEgresadoE el email del egresado. el email del egresado debe ser diferente de null
	 * @param telefonoEgresadoE el telefono del egresado. el telefono del egresado debe ser diferente de null.
	 * @throws ElementoExisteException cuando existe ya un egresado.
	 */
	
	public void agregarEgresado(String cedulaEgresadoE, String nombresEgresadoE, String apellidosEgresadoE, String direccionEgresadoE, String emailEgresadoE, int telefonoEgresadoE ) throws ElementoExisteException
	{
		System.out.println("se agrego el egresado: " + "\n");
		Egresado miEgresado = buscarEgresado(cedulaEgresadoE);
		
			if (miEgresado == null)
			{
				egresado = new Egresado(cedulaEgresadoE, nombresEgresadoE, apellidosEgresadoE,direccionEgresadoE, emailEgresadoE, telefonoEgresadoE);
				//System.out.println(egresado.darCedulaE());
				listaegresados.add(egresado);
				System.out.println("C.c:" + egresado.darCedulaE()+ "\n" + "nombres:" + egresado.darNombreEgresado()+ "\n" +"apellidos:" + egresado.darApellidoEgresado()+ "\n" + "direccion:" + egresado.darDireciccionE()+ "\n" + "email:" + egresado.darEmail()+ "\n" + "telefono:" + egresado.darTelefono()+ "\n");
				for(Egresado e:listaegresados){
					System.out.println(e);
				}
			}
			else
			{
			
		throw new ElementoExisteException ("" + cedulaEgresadoE + "");
			}
		verificarInvariante();
	}
	
		
	//-----------------------------------------------------------------
		
	public ArrayList darEstudios()
		{
			return listaestudios;
		}

		public ArrayList darExperienciasProfesionales()
		{
			return listaexperiencias;
		}

		public ArrayList darRedes()
		{
			return listaredes;
		}

		public ArrayList darEmpresas()
		{
			return listaempresas;
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
			public Estudio buscarEstudio(String descripcion)
			{
				Estudio elEstudio = null;
				boolean encontrado = false;
			if(listaestudios.size() != 0){
				for(int i = 0 ; i < listaestudios.size() && !encontrado;i++ )
				{
					Estudio miEstudio= (Estudio) listaestudios.get(i);
					if(miEstudio.darDescripcion().equals(descripcion))
					{
						elEstudio = miEstudio;
						encontrado = true;
					}

				}
			}
				return elEstudio;
			}
			
			public void agregarEstudio( String otorgaE, String fechaE, String descripcionE) throws ElementoExisteException
			{
				System.out.println("se agrego el estudio: " + "\n");
				Estudio miEstudio = buscarEstudio(descripcionE);
				
					if (miEstudio == null)
					{
						estudio = new Estudio(otorgaE, fechaE, descripcionE);
						//System.out.println(estudio.darDescripcion());
						listaestudios.add(estudio);
						System.out.println("quien la otorga: " + estudio.darOtorga()+ "\n" +"fecha:" + estudio.darFecha()+ "\n" + "descripcion: " + estudio.darDescripcion()+ "\n");
						for(Estudio e:listaestudios){
							System.out.println(e);
						}
					}
					/*else
					{
					//egresado.insertar(e);
				throw new ElementoExisteException ("el estudio para el egresado con la descripcion: " + descripcionE + "ya existe");
					}*/
				verificarInvariante();
			}
			
			//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			public ExperienciaProfesional buscarExperienciaProfesional(String fechaIngresoEP , String cargoEP)
			{
				ExperienciaProfesional laExperiencia = null;
				boolean encontrado = false;
			if(listaexperiencias.size() != 0){
				for(int i = 0 ; i < listaexperiencias.size() && !encontrado;i++ )
				{
					ExperienciaProfesional miExperiencia= (ExperienciaProfesional) listaexperiencias.get(i);
					if(miExperiencia.darFechaIngreso().equals(fechaIngresoEP) && miExperiencia.darCargo().equals(cargoEP))
					{
						laExperiencia = miExperiencia;
						encontrado = true;
					}

				}
			}
				return laExperiencia;
			}
			
			
			public void agregarExperienciaProfesional(String cargoEP, String fechaIngresoEP, String salidaEP, String empresaEP) throws ElementoExisteException
			{
				System.out.println("se agrego la experiencia profesional para el egresado: " + "\n");
				ExperienciaProfesional miExperienciaProfesional = buscarExperienciaProfesional(fechaIngresoEP, cargoEP);

				if (miExperienciaProfesional == null)
				{
					experienciaprofesional = new ExperienciaProfesional(cargoEP, fechaIngresoEP, salidaEP, empresaEP);
					//System.out.println(egresado.darCedulaE());
					listaexperiencias.add(experienciaprofesional);
					System.out.println("cargo: " + experienciaprofesional.darCargo()+ "\n" + "fecha ingreso: " + experienciaprofesional.darFechaIngreso()+ "\n" +"fecha salida:" + experienciaprofesional.darSalida()+ "\n" + "nombre de la empresa: " + experienciaprofesional.darEmpresa()+ "\n");
					for(ExperienciaProfesional e:listaexperiencias){
						System.out.println(e);
					}
				}
				verificarInvariante();
			}

			
			//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			public Red buscarRed(String nombreRedR)
			{
				Red laRed = null;
				boolean encontrado = false;
				if(listaredes.size() != 0){
					for(int i = 0 ; i < listaredes.size() && !encontrado;i++ )
					{
						Red miRed= (Red) listaredes.get(i);
						if(miRed.darNombreRed().equals(nombreRedR))
						{
							laRed = miRed;
							encontrado = true;
						}

					}
				}
				return laRed;
			}

			
			public void agregarRedes(String nombreRedR,String anoCreacionR, String nombreDirectorR, String emailRedR  ) throws ElementoExisteException
			{
				System.out.println("se agrego la red para el egresado: " + "\n");
				Red miRed = buscarRed(nombreRedR);

				if (miRed == null)
				{
					red = new Red(nombreRedR, anoCreacionR, nombreDirectorR, emailRedR);
					//System.out.println(egresado.darCedulaE());
					listaredes.add(red);
					System.out.println("nombre de la red: " + red.darNombreRed()+ "\n" + "ano de creaci�n: " + red.darAnoCreacion()+ "\n" +"nombre del director:" + red.darNombreDirector()+ "\n" + "e-mail de contacto: " + red.darEmailRed()+ "\n");
					for(Red e:listaredes){
						System.out.println(e);
					}
				}
				verificarInvariante();
			}
			
			//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			public Empresa buscarEmpresa(String nombreEmpresaE)
			{
				Empresa laEmpresa = null;
				boolean encontrado = false;
				if(listaempresas.size() != 0){
					for(int i = 0 ; i < listaempresas.size() && !encontrado;i++ )
					{
						Empresa miEmpresa= (Empresa) listaempresas.get(i);
						if(miEmpresa.darNombreEmpresa().equals(nombreEmpresaE))
						{
							laEmpresa = miEmpresa;
							encontrado = true;
						}

					}
				}
				return laEmpresa;
			}
			
			public void agregarEmpresa(String nombreEmpresaE, String ciudadE, String paisE) throws ElementoExisteException
			{
				System.out.println("se agrego la empresa para el egresado: " + "\n");
				Empresa miEmpresa = buscarEmpresa(nombreEmpresaE);

				if (miEmpresa == null)
				{
					empresa = new Empresa(nombreEmpresaE, ciudadE, paisE);
					//System.out.println(egresado.darCedulaE());
					listaempresas.add(empresa);
					System.out.println("nombre de la empresa: " + empresa.darNombreEmpresa()+ "\n" + "ciudad: " + empresa.darCiudad()+ "\n" +"pais: " + empresa.darPais() + "\n");
					for(Red e:listaredes){
						System.out.println(e);
					}
				}
				verificarInvariante();
			}
			
			
	// -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

	
	private void verificarInvariante()
	{
		
    }

}
