package vista;

import java.awt.EventQueue;

import controlador.ControladorPrincipal;
import modelo.BD;


public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Creamos el modelo
					BD modelo = BD.getSingleDBInstance("localhost", "personajesdeseries", "root", "");
					//Creamos la vista principal
					VistaPrincipal vp = new VistaPrincipal();
					//Creamos el controlador
					ControladorPrincipal cp = new ControladorPrincipal(modelo,vp);
					//Configuramos el controlador para que controle esta vista
					vp.estableceControlador(cp);
					//Hacemos visible la ventana
					vp.visualiza();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
