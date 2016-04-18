package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

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
import Mundo.SistemaEgresados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

public class PanelAgregarEgresado extends JFrame implements ActionListener

{
	
	private SistemaEgresados  principal;
	private Egresado egresado;
	private InterfazEgresado interfazegresado;	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	private JPanel contentPane;
	
	private static final String AGREGAR = "Agregar Egresado";

	private static final String CANCELAR = "Cancelar";
	
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private String cedulaEgresadoE;
	private String nombresEgresadoE;
	private String apellidosEgresadoE;
	private String direccionE;
	
	private String emailEgresadoE;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	Pattern pattern;
	
	private int telefonoEgresadoE;
	
	//------------------------------------------------------------------
		private JLabel lblCedula;
		private JTextField txtCedula;
		
		private JLabel lblNombres;
		private JTextField txtNombres;
		
		private JLabel lblApellidos;
		private JTextField txtApellidos;
		
		private JLabel lblDireccion;
		private JTextField txtDireccion;
		
		private JLabel lblTelefono;
		private JTextField txtTelefono;
		
		private JLabel lblEmail;
		private JTextField txtEmail;
		
		/*
		 * falta crear un vcombo boz para si o no para comprobar si se graduo o no
		 */
		
		private JLabel lblAnoEgreso;
		private JTextField txtAnoEgreso;
	
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

	private JButton btnAgregar;
	private JButton btnCancelar;
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	public PanelAgregarEgresado()
	{
		principal = new SistemaEgresados();
		initialize();
		pattern = Pattern.compile(PATTERN_EMAIL);
	}
	
	
	// -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

	public String darCedula()
	{
		return txtCedula.getText();
	}
	
	public String darNombres()
	{
		return txtNombres.getText();
	}
	
	public String darApellidos()
	{
		return txtApellidos.getText();
	}
	
	public String  darDireccion()
	{
		return txtDireccion.getText();
	}
	
	public String darTelefono()
	{
		return txtTelefono.getText();
	}
	
	public String darEmail()
	{
		return txtEmail.getText();
	}
	
	public String darAnoEgreso()
	{
		return txtAnoEgreso.getText();
	}
	
	
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAgregarEgresado frame = new PanelAgregarEgresado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//setBorder( new TitledBorder("Agregar"));
		
		setLayout(new GridLayout(7, 2, 10, 10));
		
		lblCedula = new JLabel("C.C: ");
		lblCedula.setFont(lblCedula.getFont().deriveFont(Font.PLAIN));
		add(lblCedula);
		
		txtCedula = new JTextField(" ");
		txtCedula.setFont(txtCedula.getFont().deriveFont(Font.PLAIN));
		add(txtCedula);
		
		lblNombres = new JLabel("Nombres: ");
		lblNombres.setFont(lblNombres.getFont().deriveFont(Font.PLAIN));
		add(lblNombres);
		
		txtNombres = new JTextField(" ");
		txtNombres.setFont(txtNombres.getFont().deriveFont(Font.PLAIN));
		add(txtNombres);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(lblApellidos.getFont().deriveFont(Font.PLAIN));
		add(lblApellidos);

		txtApellidos = new JTextField(" ");
		txtApellidos.setFont(txtApellidos.getFont().deriveFont(Font.PLAIN));
		add(txtApellidos);
		
		lblDireccion = new JLabel("Direcci�n: ");
		lblDireccion.setFont(lblDireccion.getFont().deriveFont(Font.PLAIN));
		add(lblDireccion);
		
		txtDireccion = new JTextField(" ");
		txtDireccion.setFont(txtDireccion.getFont().deriveFont(Font.PLAIN));
		add(txtDireccion);

		lblEmail= new JLabel("E-mail: ");
		lblEmail.setFont(lblEmail.getFont().deriveFont(Font.PLAIN));
		add(lblEmail);
		
		txtEmail = new JTextField(" ");
		txtEmail.setFont(txtEmail.getFont().deriveFont(Font.PLAIN));
		add(txtEmail);
		
		lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(lblTelefono.getFont().deriveFont(Font.PLAIN));
		add(lblTelefono);
		
		txtTelefono = new JTextField(" ");
		txtTelefono.setFont(txtTelefono.getFont().deriveFont(Font.PLAIN));
		add(txtTelefono);
				
		btnAgregar = new JButton ("Agregar Egresado");
		btnAgregar.setActionCommand(AGREGAR);
		add( btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("entro al metodo");
				
				crearEgresado(txtCedula.getText(), txtNombres.getText(), txtApellidos.getText(), txtDireccion.getText(), txtEmail.getText(),Integer.parseInt(txtTelefono.getText()));
				JOptionPane.showMessageDialog(null, "se registro el egresado");
			}
			
		});
		
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		//setBorder( new EmptyBorder(5, 5, 5, 5));

	}

	
	//---------------------------------------------------------------
	//M�todos------------------------------------------------------
	//--------------------------------------------------------------
	
	public boolean crearEgresado(String cedulaEgresadoE, String nombresEgresadoE, String apellidosEgresadoE,String direccionE, String emailEgresadoE, int  telefonoEgresadoE )
	{
		boolean ok= false;
		try
		{
			if(validarEgresado())
			{
				System.out.println("creo el egresado");
				principal.agregarEgresado(cedulaEgresadoE, nombresEgresadoE, apellidosEgresadoE, direccionE, emailEgresadoE, telefonoEgresadoE);
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
	
	public boolean validarEgresado()
	{
		boolean parametersOk = true;
		String cedulaEgresadoE = darCedula(); 
		String nombresEgresadoE = darNombres();
		String apellidosEgresadoE = darApellidos();
		String direccionEgresadoE = darDireccion();
		String emailEgresadoE = darEmail();
		int telefonoEgresadoE = 0;
		
		  /*if( ( cedulaEgresadoE.equals( " " ) || nombresEgresadoE.equals( "" ) ) || ( apellidosEgresadoE.equals( "" ) ||  direccionEgresadoE.equals("") || emailEgresadoE.equals("")) )
		    {
		        parametersOk = false;
		        JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para registrar el egresado" );
		    }
		*/
		
		 if(cedulaEgresadoE.equals(" "))
		{		
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la cedula del Egresado");
		}
		else if(nombresEgresadoE.equals(" "))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre del Egresado");
		}
		
		else if(apellidosEgresadoE.equals(" "))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el apellido del egresado");
		}
		else if(direccionEgresadoE.equals(" "))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar la direcci�n del Egresado");
		}
		//------------------------------------------------------------------------- 
		else if (emailEgresadoE.equals(" "))
	    {
			parametersOk = false;
			JOptionPane.showMessageDialog(null, "debe ingresar el e-mail del egresado");
			
	     }
		
		 		 
		else if (!pattern.matcher(txtEmail.getText()).matches())
	    {
			parametersOk = false;
			JOptionPane.showMessageDialog(null, "debe ingresar un e-mail valido");
			
	     }
	      
		else try
		{
			telefonoEgresadoE = Integer.parseInt(darTelefono());
			if(telefonoEgresadoE < 0 || telefonoEgresadoE == 0)
			{
				parametersOk = false;
				JOptionPane.showMessageDialog(this, "el telefono ingresado no es valido ");
			}
		}
		catch (Exception e)
		{
				parametersOk = false;
				JOptionPane.showMessageDialog(this, "el telefono ingresado no es valido ");
		}
			
		//if(parametersOk)
		//{
			/*boolean ok = crearEgresado( nombresEgresadoE, cedulaEgresadoE, apellidosEgresadoE, direccionEgresadoE, telefonoEgresadoE, emailEgresadoE);
			if(ok)
				JOptionPane.showInputDialog("el egresado se agrego correctamente");*/
		//}
		return parametersOk;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

			
}

