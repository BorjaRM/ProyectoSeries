package interfacesControlador;

import controlador.ControladorPrincipal;

public interface IVentanaPrincipal {

	//Hace que la ventana sea visible
	public void visualiza();
	
	//Establece el controlador para esta ventana
	public void estableceControlador(ControladorPrincipal controlador);
	
}
