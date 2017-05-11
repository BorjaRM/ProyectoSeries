package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;
import interfacesControlador.IVentanaPrincipal;

import javax.swing.JButton;
import java.awt.GridLayout;

public class VistaPrincipal extends JFrame implements IVentanaPrincipal{

	private JPanel contentPane;
	private JButton btnSeries,btnPersonajes;
	
	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 1, 0));
		
		btnSeries = new JButton("Ver Series");
		btnSeries.setActionCommand("VerSeries");
		contentPane.add(btnSeries);

		btnPersonajes = new JButton("Ver personajes");
		btnPersonajes.setActionCommand("VerPersonajes");
		contentPane.add(btnPersonajes);
	}
	
	/*
	 * Metodo que vuelve visible la ventana
	 */	
	@Override
	public void visualiza(){
		this.setVisible(true);
	}
	
	/*
	 * Metodo que establece el controlador para esta ventana
	 * @param controlador Define el controlador que queremos utilizar para esta ventana 
	 */	
	@Override
	public void estableceControlador(ControladorPrincipal controlador){
		this.btnSeries.addActionListener(controlador);
		this.btnPersonajes.addActionListener(controlador);
	}

}
