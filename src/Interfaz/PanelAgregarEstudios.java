package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import Mundo.Estudio;
import Mundo.SistemaEgresados;

public class PanelAgregarEstudios extends JFrame implements ActionListener

{

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	/**
	 * 
	 */
	private JPanel contentPane;
	
	/**
	 * 
	 */
	
	private static final String AGREGAR_ESTUDIOS = "Agregar Estudios";
	private static final String CANCELAR = "Cancelar";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/**
	 * 
	 */
	private InterfazEgresado interfazegresado;
	private Egresado principalegresado;
	private Estudio estudio;
	private SistemaEgresados principal;
	//------------------------------------------------------------------
	
	private JLabel lblquienotorga;
	private JTextField txtquienotorga;
	
	private JLabel lblfechaotorga;
	private JTextField txtfechaotorga;
	
	private JLabel lbldescripcion;
	private JTextField txtdescripcion;
	
	
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

	private JButton btnAgregarEstudios;
	private JButton btnCancelar;
	
	
	/*public PanelAgregarEstudios( InterfazEgresado ventanaPrincipal)
	{
		principal = ventanaPrincipal;
		setBorder( new TitledBorder( "Agregar Estudios"));
		
		btnAgregarEstudios = new JButton("Agregar Estudios");
		btnAgregarEstudios.setActionCommand(AGREGAR_ESTUDIOS);
		btnAgregarEstudios.addActionListener(this);
		add( btnAgregarEstudios);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		add(btnCancelar);
		
	}*/
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
		
	public PanelAgregarEstudios()
	{
		principal = new SistemaEgresados();
		initialize();
	}
	

	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	public String darQuienOtorga()
	{
		return txtquienotorga.getText();
	}
	
	public String darFechaOtorga()
	{
		return txtfechaotorga.getText();
	}
	
	public String darDescripcion()
	{
		return txtdescripcion.getText();
	}
	
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		getContentPane().setLayout(new GridLayout(6, 2, 10, 10));
	
		lblquienotorga = new JLabel("Quien la otorga: ");
		lblquienotorga.setBounds(5, 5, 207, 55);
		lblquienotorga.setFont(lblquienotorga.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblquienotorga);
		
		txtquienotorga = new JTextField("");
		txtquienotorga.setBounds(227, 5, 455, 55);
		txtquienotorga.setFont(txtquienotorga.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtquienotorga);
	
		lblfechaotorga = new JLabel("Fecha de Otorgamiento: ");
		lblfechaotorga.setBounds(5, 70, 207, 55);
		lblfechaotorga.setFont(lblfechaotorga.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lblfechaotorga);
		
		txtfechaotorga = new JTextField("");
		txtfechaotorga.setBounds(222, 70, 207, 55);
		txtfechaotorga.setFont(txtfechaotorga.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtfechaotorga);
		
		lbldescripcion = new JLabel("Descripción: ");
		lbldescripcion.setBounds(5, 135, 207, 55);
		lbldescripcion.setFont(lbldescripcion.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(lbldescripcion);
		
		txtdescripcion = new JTextField("");
		txtdescripcion.setBounds(222, 135, 207, 70);
		txtdescripcion.setFont(txtdescripcion.getFont().deriveFont(Font.PLAIN));
		getContentPane().add(txtdescripcion);
	
		btnAgregarEstudios = new JButton("Agregar Estudios");
		btnAgregarEstudios.setBounds(5, 200, 207, 55);
		btnAgregarEstudios.setActionCommand(AGREGAR_ESTUDIOS);
		btnAgregarEstudios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				crearEstudio(txtquienotorga.getText(), txtfechaotorga.getText(), txtdescripcion.getText());
				JOptionPane.showMessageDialog(null, "se registro el nuevo estudio");
			}
		});
		
		
		getContentPane().add(btnAgregarEstudios);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setBounds(222, 200, 207, 55);
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
	
	//---------------------------------------------------------------
	//Métodos------------------------------------------------------
	//--------------------------------------------------------------

	public boolean crearEstudio(String otorgaE, String fechaE, String descripcionE )
	{
		boolean ok= false;
		try
		{
			if(validarEstudio())
			{
				System.out.println("\n" + "creo el estudio");
				principal.agregarEstudio(otorgaE, fechaE, descripcionE);
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
	
	/**
	 * el metodo convierte de String a formato de fecha 
	 * @param fechaE la fecha de otorgamiento
	 * @return retorna la fecha en formato Date
	 */
	

	public boolean validarEstudio()
	{
		boolean parametersOk = true;
		String otorgaE = darQuienOtorga();
		String fechaE = darFechaOtorga();
		String descripcionE = darDescripcion();
			
		if( ( otorgaE.equals( " " ) ) || ( fechaE.equals( " " )) || descripcionE.equals( " " ))
	    {
	        parametersOk = false;
	        JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para registrar el nuevo estudio" );
	    }
		else if(otorgaE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre de quien otorga el nuevo estudio");
		}
		else if(fechaE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la fecha de otorgamiento del nuevo estudio");
		}
			
		else if(descripcionE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar una descripcion para el nuevo estudio");
		}
		return parametersOk;
	}
		

		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAgregarEstudios frame = new PanelAgregarEstudios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}