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
import Mundo.Red;
import Mundo.SistemaEgresados;

public class PanelAgregarRed extends JFrame implements ActionListener

{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	private JPanel contentPane;
	private static final String AGREGAR_RED = "Agregar Red";
	private static final String CANCELAR = "Cancelar";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private InterfazEgresado interfazegresado;
	private Egresado principalegresado;
	private Red red;
	private SistemaEgresados principal;
	
	
	//------------------------------------------------------------------
	
	private JLabel lblnombrered;
	private JTextField txtnombrered;
	
	private JLabel lblanocreacion;
	private JTextField txtanocreacion;
	
	private JLabel lbldireccionR;
	private JTextField txtdirectorR;
	
	private JLabel lblemailcontacto;
	private JTextField txtemailcontacto;

	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

	private JButton btnInfRedes;
	private JButton btnCancelar;
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	
	/*public PanelAgregarRed (InterfazEgresado ventanaPrincipal)
	{
		principal = ventanaPrincipal;
		setBorder( new TitledBorder ( "Agregar Red" ) );
		
		btnInfRedes = new JButton ("Inf.Redes");
		btnInfRedes.setActionCommand(AGREGAR_RED);
		btnInfRedes.addActionListener(this);
		add( btnInfRedes);
		
		btnCancelar = new JButton ("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		add(btnCancelar);
	}*/
	
	public PanelAgregarRed()
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
		
		lblnombrered = new JLabel("Nombre Red: ");
		lblnombrered.setFont(lblnombrered.getFont().deriveFont(Font.PLAIN));
		add(lblnombrered);
		
		txtnombrered = new JTextField(" ");
		txtnombrered.setFont(txtnombrered.getFont().deriveFont(Font.PLAIN));
		add(txtnombrered);
		
		lblanocreacion = new JLabel("A�o Creaci�n: ");
		lblanocreacion.setFont(lblanocreacion.getFont().deriveFont(Font.PLAIN));
		add(lblanocreacion);
		
		txtanocreacion = new JTextField(" ");
		txtanocreacion.setFont(txtanocreacion.getFont().deriveFont(Font.PLAIN));
		add(txtanocreacion);
		
		lbldireccionR = new JLabel("Direccion: ");
		lbldireccionR.setFont(lbldireccionR.getFont().deriveFont(Font.PLAIN));
		add(lbldireccionR);
		
		txtdirectorR = new JTextField(" ");
		txtdirectorR.setFont(txtdirectorR.getFont().deriveFont(Font.PLAIN));
		add(txtdirectorR);
	
		lblemailcontacto = new JLabel("E-mail de Contacto: ");
		lblemailcontacto.setFont(lblemailcontacto.getFont().deriveFont(Font.PLAIN));
		add(lblemailcontacto);
		
		txtemailcontacto = new JTextField(" ");
		txtemailcontacto.setFont(txtemailcontacto.getFont().deriveFont(Font.PLAIN));
		add(txtemailcontacto);
	
		btnInfRedes = new JButton("Agregar Red");
		btnInfRedes.setActionCommand(AGREGAR_RED);
		btnInfRedes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				crearRed(txtnombrered.getText(), txtanocreacion.getText(), txtdirectorR.getText(), txtemailcontacto.getText());
				JOptionPane.showMessageDialog(null, "se registro la red con �xito");
			}
		});
		add(btnInfRedes);
		
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
    // M�todos
    // -----------------------------------------------------------------

	public String darNombreRed()
	{
		return txtnombrered.getText();
	}
	
	public String darAnoCreacion()
	{
		return txtanocreacion.getText();
	}
	
	public String darDirectorR()
	{
		return txtdirectorR.getText();
	}
	
	public String darEmailContacto()
	{
		return txtemailcontacto.getText();
	}
	
	public boolean crearRed(String nombreRedR, String anoCreacionR, String nombreDirectorR, String emailRedR)
	{
		boolean ok= false;
		try
		{
			if(validarRed())
			{
				System.out.println("\n" + "creo la red");
				principal.agregarRedes(nombreRedR, anoCreacionR, nombreDirectorR, emailRedR);
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

	public boolean validarRed()
	{
		boolean parametersOk = true;
		String nombreRedR = darNombreRed();
		String anoCreacionR = darAnoCreacion();
		String nombreDirectorR = darDirectorR();
		String emailRedR = darEmailContacto();
			
		if( ( nombreRedR.equals( " " ) ) || ( anoCreacionR.equals( " " )) || nombreDirectorR.equals( " " ) || emailRedR.equals( " " ) )
	    {
	        parametersOk = false;
	        JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para registrar el nuevo estudio" );
	    }
		else if(nombreRedR.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre de la red");
		}
		else if(anoCreacionR.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el a�o de creaci�n");
		}
		else if(nombreDirectorR.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el nombre del director");
		}
		else if(emailRedR.equals(""))
		{
			parametersOk = false;
			JOptionPane.showMessageDialog(this, "debe ingresar el e-mail de contacto");
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
					PanelAgregarRed frame = new PanelAgregarRed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}