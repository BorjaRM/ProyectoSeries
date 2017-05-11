package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaPrincipal;
import vista.VistaSeries;
import modelo.BD;

public class ControladorPrincipal implements ActionListener {
	private VistaPrincipal vista;
	private BD baseDatos;
	
	public ControladorPrincipal(BD modelo, VistaPrincipal vp){
		vista=vp;
		baseDatos=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Comprobamos que boton se ha pulsado para realizar una accion u otra
		switch(e.getActionCommand()){
		case "VerSeries": eligeVerSeries(); break;
		case "VerPersonajes": eligeVerPersonajes(); break;	
		}
	}
	
	public void eligeVerSeries(){
		try{
			//nueva vista
			VistaSeries vs = new VistaSeries();
			//nuevo controlador
			ControladorSeries cs = new ControladorSeries(vs,baseDatos);
			//Configuramos el controlador para que controle esta vista
			vs.estableceControlador(cs);
			//El nuevo controlador se comunica con la vista y el modelo para obtener y mostrar el listado de series
			cs.preparaVistaSeries();
			//Hacemos visible la ventana
			vs.visualiza();	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void eligeVerPersonajes(){
		
	}

}
