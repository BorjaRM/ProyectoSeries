package interfacesControlador;

import java.util.HashMap;

import controlador.ControladorSeries;
import modelo.Serie;

public interface IVentanaSeries {
	////Hace que la ventana sea visible
	public void visualiza();
	
	//Establece el controlador para esta ventana
	public void estableceControlador(ControladorSeries controlador);
	
	//Muestra en el listado de series las series que hay en la base de datos
	public void rellenaListaSeries(HashMap<String,Serie> series);
	
	//Permite al controlador obtener la serie seleccionada por el usuario
	public String getSerieSeleccionada();
	
	//Permite al controlador actualizar la vista con la informacion de la serie seleccionada
	public void muestraDatosSerieSeleccionada(Serie e);

}
