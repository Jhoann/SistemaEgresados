package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.FeatureDescriptor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Mundo.Egresado;
import Mundo.ElementoExisteException;
import Mundo.ExperienciaProfesional;
import Mundo.SistemaEgresados;

public class PanelAgregarExperienciaProfesional extends JFrame implements ActionListener

{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	private JPanel contentPane;
	
	private static final String EXPERIENCIA_PROFESIONAL = "Exp.Profesional";
	
	private static final String CANCELAR = "Cancelar";
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private InterfazEgresado interfazegresado;
	private SistemaEgresados principal;
	private ExperienciaProfesional experienciaprofesional;
	private Egresado egresado;
	//------------------------------------------------------------------
	
	private JLabel lblcargo;
	private JTextField txtcargo;
	
	private JLabel lblfechainicio;
	private JTextField txtfechainicio;
	
	private JLabel lblfechafinaliza;
	private JTextField txtfechafinaliza;
	
	private JLabel lblnombreempresa;
	private JTextField txtnombreempresa;
	
	
	
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

	private JButton btnExpProfesional;
	private JButton btnCancelar;
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	/*public PanelAgregarExperienciaProfesional( InterfazEgresado ventanaPrincipal)
	{
		principal = ventanaPrincipal;
		setBorder( new TitledBorder( "Exp.Profesional Egresado" ));
		
		btnExpProfesional = new JButton("Exp.Profesional");
		btnExpProfesional.setActionCommand(EXPERIENCIA_PROFESIONAL);
		btnExpProfesional.addActionListener(this);
		add(btnExpProfesional);
	
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		add(btnCancelar);
	
	}*/
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
		
	public PanelAgregarExperienciaProfesional()
	{
		principal = new SistemaEgresados();
		initialize();
	}
	
	
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		getContentPane().setLayout(new GridLayout(6, 2, 10, 10));
		
		lblcargo = new JLabel("Cargo: ");
		lblcargo.setFont(lblcargo.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblcargo);
		
		txtcargo = new JTextField(" ");
		txtcargo.setFont(txtcargo.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtcargo);
		
		lblfechainicio = new JLabel("Fecha Inicio: ");
		lblfechainicio.setFont(lblfechainicio.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblfechainicio);
		
		txtfechainicio = new JTextField(" ");
		txtfechainicio.setFont(txtfechainicio.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtfechainicio);
		
		lblfechafinaliza = new JLabel("Fecha Finalizacion: ");
		lblfechafinaliza.setFont(lblfechafinaliza.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblfechafinaliza);
				
		txtfechafinaliza = new JTextField(" ");
		txtcargo.setFont(txtfechafinaliza.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtfechafinaliza, BorderLayout.CENTER);
		
		lblnombreempresa = new JLabel("Nombre Empresa: ");
		lblnombreempresa.setFont(lblnombreempresa.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblnombreempresa);
		
		txtnombreempresa = new JTextField(" ");
		txtnombreempresa.setFont(txtnombreempresa.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtnombreempresa);
		
		btnExpProfesional = new JButton("Agregar Exp.Profesional");
		btnExpProfesional.setActionCommand(EXPERIENCIA_PROFESIONAL);
		btnExpProfesional.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				crearExperiencia(txtcargo.getText(),txtfechainicio.getText(), txtfechafinaliza.getText(), txtnombreempresa.getText());
				JOptionPane.showMessageDialog(null, "se registro la nueva experiencia profesional");
				
			}
		});
		getContentPane().add(btnExpProfesional, BorderLayout.SOUTH);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		getContentPane().add(btnCancelar);
	
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	public String darCargo()
	{
		return txtcargo.getText();
	}
	
	public String darFechaInicio()
	{
		return txtfechainicio.getText();
	}
	
	public String darFechaSalida()
	{
		return txtfechafinaliza.getText();
	}
	
	public String darNombreEmpresa()
	{
		return txtnombreempresa.getText();
	}
	
	/*
	 * 
	 */
	public boolean crearExperiencia(String cargoEP, String fechaIngresoEP, String salidaEP, String empresaEP )
	{
		boolean ok= false;
		try
		{
			if(validarExperiencia())
			{
				System.out.println("\n" + "creo la nueva experiencia profesional");
				principal.agregarExperienciaProfesional(cargoEP, fechaIngresoEP, salidaEP, empresaEP);
				ok = true;
			}
			else
			{
				ok = false;
			}
		}
		catch (ElementoExisteException e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		return ok;
}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	public boolean validarExperiencia()
	{
		boolean parametersOk = true;
		String cargoEP = darCargo();
		String fechaIngresoEP = darFechaInicio();
		String salidaEP = darFechaSalida();
		String empresaEP = darNombreEmpresa();
		
		
		if( ( cargoEP.equals( " " ) ) || ( fechaIngresoEP.equals( " " )) || salidaEP.equals( " " ) || ( empresaEP.equals( " " )))
	    {
	        parametersOk = false;
	        JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para registrar la nueva experiencia profesional" );
	    }
		else if(cargoEP.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre del cargo");
		}
		else if(fechaIngresoEP.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la fecha de ingreso");
		}
		else if(salidaEP.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la fecha de salida");
		}
		else if(empresaEP.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre de la empresa");
		}
		
		return parametersOk;
	}
	
	
	public void actionPerformed( ActionEvent e)
	{
			//principal.agregarExpProfesional();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAgregarExperienciaProfesional frame = new PanelAgregarExperienciaProfesional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}
