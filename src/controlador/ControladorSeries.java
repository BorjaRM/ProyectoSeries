package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.BD;
import modelo.PersonajeConsultas;
import modelo.Serie;
import modelo.SerieConsultas;
import vista.VistaSeries;

public class ControladorSeries implements ActionListener, ListSelectionListener{
	private VistaSeries vista;
	private BD baseDatos;	
	private HashMap<String,Serie> listadoSeries;
	private String[][] listadoPjYActores;

	
	public ControladorSeries(VistaSeries vs, BD baseDatos){
		vista=vs;
		this.baseDatos=baseDatos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vista.dispose();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting() == false){
			if(vista.getSerieSeleccionada() == null){
				//No se ha seleccionado ninguna serie
	            vista.muestraDatosSerieSeleccionada(null);
			}else{
				String titulo = vista.getSerieSeleccionada();
				vista.muestraDatosSerieSeleccionada(listadoSeries.get(titulo));
				preparaPersonajesyActores(listadoSeries.get(titulo).getTitulo());
			}
		}
	}
	
	public void preparaVistaSeries(){
		//Creamos un objeto SerieConsultas para poder lanzar las consultas relacionadas con esta clase
		SerieConsultas sc = new SerieConsultas(baseDatos);
		//Guardamos el resultado de la consulta en el HashMap creado en esta clase
		listadoSeries = sc.getListadoSeries();
		//Le pasamos el hashmap a la VistaSeries para que rellena la lista
		this.vista.rellenaListaSeries(listadoSeries);
	}
	
	public void preparaPersonajesyActores(String titulo){
		//Creamos un objeto PersonajeConsultas para poder lanzar las consultas relacionadas con esta clase
		PersonajeConsultas pc = new PersonajeConsultas(baseDatos);
		//Guardamos el resultado de la consulta en el HashMap creado en esta clase
		listadoPjYActores = pc.getPersonajeYActor2(titulo);
		//Le pasamos el hashmap a la VistaSeries para que rellena la tabla
		this.vista.muestraPersonajesYActores(listadoPjYActores);

	}

}
