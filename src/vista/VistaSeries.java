package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorSeries;
import interfacesControlador.IVentanaSeries;
import modelo.Serie;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.HashMap;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

public class VistaSeries extends JFrame implements IVentanaSeries{

	private JPanel contentPane;
	private JTable table;
	private JList <String>list;
	private JButton btnVolver;
	private JPanel panel;
	private JLabel lblGenero;
	private JLabel lblTemporadas;
	private JLabel lblFLanzamiento;

	/**
	 * Create the frame.
	 */
	public VistaSeries() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		JLabel label = new JLabel("Genero");
		horizontalBox.add(label);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		JLabel label_1 = new JLabel("Temporadas");
		horizontalBox.add(label_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);
		JLabel label_2 = new JLabel("Fecha Lanzamiento");
		horizontalBox.add(label_2);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel.add(horizontalBox_1);
	
		lblGenero = new JLabel("");
		horizontalBox_1.add(lblGenero);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_2);
		
		lblTemporadas = new JLabel("");
		horizontalBox_1.add(lblTemporadas);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_3);
		
		lblFLanzamiento = new JLabel("");
		horizontalBox_1.add(lblFLanzamiento);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		table = new JTable();
		scrollPane_1.setViewportView(table);
		contentPane.add(scrollPane_1);
		
		JPanel botonera = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonera.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(botonera);
		
		btnVolver = new JButton("Volver");
		botonera.add(btnVolver);
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
	public void estableceControlador(ControladorSeries controlador) {
		this.list.addListSelectionListener(controlador);
		this.btnVolver.addActionListener(controlador);
	}

	/*
	 * Metodo que obtiene los titulos de las series y los pasa a la lista
	 * @param series HashMap que contiene la informacion sobre las series obtenidas de la base de datos
	 */
	@Override
	public void rellenaListaSeries(HashMap<String, Serie> series) {
		if(series!=null){
			//Creamos un modelo por defecto
			DefaultListModel listModel = new DefaultListModel();
			//Añadimos el titulo de las series
			for(String serie: series.keySet()){
				listModel.addElement(serie.toString());
			}
			//Añadimos el modelo por defecto a la lista
			list.setModel(listModel);
		}
	}

	/*
	 * Metodo que devuelve el nombre del item seleccionado en la lista
	 * @return titulo de la serie seleccionada
	 */
	@Override
	public String getSerieSeleccionada() {
		return list.getSelectedValue();
	}

	/*
	 * Metodo que recibe una serie y muestra su informacion mediante labels
	 * @param s Serie para la que se quiere mostrar la informacion
	 */
	@Override
	public void muestraDatosSerieSeleccionada(Serie s) {
		if(s!=null){
			lblGenero.setText(s.getGenero()); 
			lblTemporadas.setText(String.valueOf(s.getTemporadas())); 
			lblFLanzamiento.setText(s.getFechaLanzamiento()); 
		}else{
			lblGenero.setText(""); 
			lblTemporadas.setText(""); 
			lblFLanzamiento.setText("");
		}		
	}
	
	public void muestraPersonajesYActores(String[][] datosTabla){
		DefaultTableModel dtm = new DefaultTableModel();
		String[] cabecero = {"Nombre personaje","Nombre actor"};
		String[] fila = new String[2];
		
		//añadimos el nombre de las columnas a la tabla
		for(int i=0;i<cabecero.length;i++){
			dtm.addColumn(cabecero[i]);
		}
		//añadimos cada fila de datos a la tabla
		for(int i=0;i<datosTabla.length;i++){
			fila[0] =  datosTabla[i][0];
			fila[1] =  datosTabla[i][1];
			dtm.addRow(fila);
		}		
		table.setModel(dtm);
	}

}


