package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Mundo.Empresa;
import Mundo.SistemaEgresados;

public class PanelRegistrarEmpresa extends JFrame implements ActionListener

{

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	private JPanel contentPane;
	private static final String REGISTRAR_EMPRESA = "Registrar Empresa";
	private static final String CANCELAR = "Cancelar";
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private InterfazEgresado interfazegresado;
	private Egresado principalegresado;
	private Empresa empresa;
	private SistemaEgresados principal;
	//------------------------------------------------------------------
	private JLabel lblnombreempresa;
	private JTextField txtnombreempresa;

	private JLabel lblciudadempresa;
	private JTextField txtciudadempresa;

	private JLabel lblpaisempresa;
	private JTextField txtpaisempresa;
	
	
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

	private JButton btnRegistrarEmpresa;
	private JButton btnCancelar;
	
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	
	/*public PanelRegistrarEmpresa (InterfazEgresado ventanaPrincipal)
	{
		principal = ventanaPrincipal;
		setBorder( new TitledBorder ( "Registrar Empresa" ) );
		
		btnRegistrarEmpresa = new JButton( "Registrar Empresa" );
		btnRegistrarEmpresa.setActionCommand(REGISTRAR_EMPRESA);
		btnRegistrarEmpresa.addActionListener(this);
		add( btnRegistrarEmpresa);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		add(btnCancelar);
	}*/

	public PanelRegistrarEmpresa()
	{
		principal = new SistemaEgresados();
		initialize();
	}

	public void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		setLayout(new GridLayout(7, 2, 10, 10));
		
		lblnombreempresa = new JLabel("Nombre Empresa: ");
		lblnombreempresa.setFont(lblnombreempresa.getFont().deriveFont(Font.PLAIN));
		add(lblnombreempresa);
		
		txtnombreempresa = new JTextField("");
		txtnombreempresa.setFont(txtnombreempresa.getFont().deriveFont(Font.PLAIN));
		add(txtnombreempresa);
	
		lblciudadempresa = new JLabel("Ciudad: ");
		lblciudadempresa.setFont(lblciudadempresa.getFont().deriveFont(Font.PLAIN));
		add(lblciudadempresa);
		
		txtciudadempresa = new JTextField("");
		txtciudadempresa.setFont(txtciudadempresa.getFont().deriveFont(Font.PLAIN));
		add(txtciudadempresa);
		
		lblpaisempresa = new JLabel("País: ");
		lblpaisempresa.setFont(lblpaisempresa.getFont().deriveFont(Font.PLAIN));
		add(lblpaisempresa);
		
		txtpaisempresa = new JTextField("");
		txtpaisempresa.setFont(txtpaisempresa.getFont().deriveFont(Font.PLAIN));
		add(txtpaisempresa);
	
		btnRegistrarEmpresa = new JButton("Registrar Empresa");
		btnRegistrarEmpresa.setActionCommand(REGISTRAR_EMPRESA);
		btnRegistrarEmpresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				crearEmpresa(txtnombreempresa.getText(), txtciudadempresa.getText(), txtpaisempresa.getText());
				JOptionPane.showMessageDialog(null, "se registro la empresa con éxito");
			}
		});
		add(btnRegistrarEmpresa);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(btnCancelar);
	
	}
	

	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	public String darNombreEmpresa()
	{
		return txtnombreempresa.getText();
	}
	
	public String darCiudadEmpresa()
	{
		return txtciudadempresa.getText();
	}
	
	public String darPaisEmpresa()
	{
		return txtpaisempresa.getText();
	}
	
	public boolean crearEmpresa(String nombreEmpresaE, String ciudadE, String paisE)
	{
		boolean ok= false;
		try
		{
			if(validarEmpresa())
			{
				System.out.println("\n" + "creo la empresa");
				principal.agregarEmpresa(nombreEmpresaE, ciudadE, paisE);
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

	public boolean validarEmpresa()
	{
		boolean parametersOk = true;
		String nombreEmpresaE = darNombreEmpresa();
		String ciudadE = darCiudadEmpresa();
		String paisE = darPaisEmpresa();
			
		if( ( nombreEmpresaE.equals( " " ) ) || ( ciudadE.equals( " " )) || paisE.equals( " " ))
	    {
	        parametersOk = false;
	        JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para registrar la nueva empresa" );
	    }
		else if(nombreEmpresaE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre de la empresa");
		}
		else if(ciudadE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la ciudad en donde se encuentra la empresa");
		}
		else if(paisE.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el pais en donde se encuentra la empresa");
		}
		return parametersOk;
	}
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelRegistrarEmpresa frame = new PanelRegistrarEmpresa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

}
}