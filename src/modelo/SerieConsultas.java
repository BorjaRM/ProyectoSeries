package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SerieConsultas {
	BD bd;
	
	public SerieConsultas(BD bd){
		this.bd=bd;
	}
	
	public HashMap<String,Serie> getListadoSeries(){
		HashMap<String,Serie> listadoSeries = new HashMap<String,Serie>();
		String titulo,genero,fechaLanzamiento;
		int id,temporadas;
		
		try{
			Statement stmt = this.bd.getConexion().createStatement();
			ResultSet resultadoConsulta = stmt.executeQuery("SELECT * FROM SERIE");
			//Transformamos el resultset en un HashMap
			while(resultadoConsulta.next()){
				//Vamos obteniendo los atributos de la consulta tupla por tupla
				id=resultadoConsulta.getInt("idSerie");
				titulo=resultadoConsulta.getString("titulo");
				genero=resultadoConsulta.getString("genero");
				fechaLanzamiento=resultadoConsulta.getString("fecha_lanzamiento");
				temporadas=resultadoConsulta.getInt("temporadas");
				//Creamos un objeto Serie y lo añadimos al HashMap
				listadoSeries.put(titulo, new Serie(id,titulo,genero,fechaLanzamiento,temporadas));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return listadoSeries;		
	}

}
