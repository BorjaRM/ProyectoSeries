package modelo;

public class Personaje {
	private int idPersonaje;
	private String nombre;
	private String descripcion;
	
	public Personaje(int id, String nom, String des){
		idPersonaje=id;
		nombre=nom;
		descripcion=des;		
	}
	
	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
