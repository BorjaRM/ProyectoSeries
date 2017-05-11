package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PersonajeConsultas {
	BD bd;
	
	public PersonajeConsultas(BD bd){
		this.bd=bd;
	}
	
	public HashMap<String,String> getPersonajeYActor(String titulo){
		HashMap<String,String> pjActor = new HashMap<String,String>();
		String actor,personaje;
		
		try{
			PreparedStatement stmt = this.bd.getConexion().prepareStatement(
					"SELECT personaje.nombre AS personaje, concat(actor.nombre,' ',actor.apellidos) AS nombre_completo, titulo "
					+ "FROM personaje INNER JOIN actor ON personaje.idActor=actor.idActor "
					+ "INNER JOIN serie ON personaje.idSerie=serie.idSerie AND serie.titulo = '?';");
			stmt.setString(0, titulo);
			ResultSet resultadoConsulta = stmt.executeQuery(titulo);
			//Transformamos el resultset en un HashMap
			while(resultadoConsulta.next()){
				//Vamos obteniendo los atributos de la consulta tupla por tupla
				personaje=resultadoConsulta.getString("personaje");
				actor=resultadoConsulta.getString("nombre_completo");
				//añadimos al HashMap
				pjActor.put(personaje, actor);
			}
			resultadoConsulta.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pjActor;
	}
	
	public String[][] getPersonajeYActor2(String titulo){
		String[][] pjActor = null;
		String actor,personaje;
		
		try{
			//Calculamos el numero total de resultados
			int totalResultados=0;
			String sql = "SELECT count(*) AS total FROM personaje INNER JOIN actor ON personaje.idActor=actor.idActor "
					+ "INNER JOIN serie ON personaje.idSerie=serie.idSerie AND serie.titulo = ?;";
			PreparedStatement st1 = this.bd.getConexion().prepareStatement(sql);		
			st1.setString(1, titulo);
			ResultSet resultadoConsulta1 = st1.executeQuery();
			while (resultadoConsulta1.next()){
				totalResultados = resultadoConsulta1.getInt("total");
			 }
			resultadoConsulta1.close();

			//creamos la matriz
			pjActor = new String[totalResultados][2];
		
			//obtenemos los datos para rellena la matriz
			PreparedStatement stmt = this.bd.getConexion().prepareStatement(
					"SELECT personaje.nombre AS personaje, concat(actor.nombre,' ',actor.apellidos) AS nombre_completo, titulo "
					+ "FROM personaje INNER JOIN actor ON personaje.idActor=actor.idActor "
					+ "INNER JOIN serie ON personaje.idSerie=serie.idSerie AND serie.titulo = ?;");
			stmt.setString(1,titulo);
			ResultSet resultadoConsulta = stmt.executeQuery();
			//Transformamos el resultset en una matriz
			int contador=0;
			while(resultadoConsulta.next()){
				//Vamos obteniendo los atributos de la consulta tupla por tupla
				personaje=resultadoConsulta.getString("personaje");
				actor=resultadoConsulta.getString("nombre_completo");
				//añadimos a la matriz
				pjActor[contador][0] = personaje;
				pjActor[contador][1] = actor;
				contador++;
			}
			resultadoConsulta.close();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(titulo);
		}
		return pjActor;
	}
}
