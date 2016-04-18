package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import Mundo.Egresado;
import Mundo.ElementoExisteException;
import Mundo.SistemaEgresados;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class InterfazEgresado extends JFrame 
{

	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
		
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
	private JFrame frame;
	private JButton btnAgregar;
	private JButton btnExpProfesional;
	private JButton btnInfestudios;
	private JButton btnInfRedes;
	private JButton btnAgregarEmpresa;

	// -----------------------------------------------------------------
    private PanelAgregarEgresado panelAgregarEgresado; 
    private PanelAgregarEstudios panelAgregarEstudios;
    private PanelAgregarExperienciaProfesional panelAgregarExperienciaProfesional;
    private PanelAgregarRed panelAgregarRed;
    private PanelRegistrarEmpresa panelAgregarEmpresa;
    
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEgresado window = new InterfazEgresado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazEgresado( ) 
	{
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 260, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar Egresado");
		btnAgregar.setBounds(48, 34, 149, 23);
		frame.getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PanelAgregarEgresado().setVisible(true);
			}
		});
		
		JButton btnExpProfesional = new JButton("Exp.Profesional");
		btnExpProfesional.setBounds(48,135,149,22);
		frame.getContentPane().add(btnExpProfesional);
		btnExpProfesional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PanelAgregarExperienciaProfesional().setVisible(true);
			}
		});
		
		JButton btnInfestudios = new JButton("Inf.Estudios");
		btnInfestudios.setBounds(48, 68, 149, 22);
		frame.getContentPane().add(btnInfestudios);
		btnInfestudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PanelAgregarEstudios().setVisible(true);
			}
		});
		
		JButton btnInfRedes = new JButton("Inf.Redes");
		btnInfRedes.setBounds(48, 101, 149, 23);
		frame.getContentPane().add(btnInfRedes);
		btnInfRedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PanelAgregarRed().setVisible(true);
			}
		});
		
		JButton btnAgregarEmpresa = new JButton("Registrar Empresa");
		btnAgregarEmpresa.setBounds(48, 168, 149, 25);
		frame.getContentPane().add(btnAgregarEmpresa);
		btnAgregarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PanelRegistrarEmpresa().setVisible(true);
			}
		});
	}
	
	public void dispose()
	{
		super.dispose();
    }
}
