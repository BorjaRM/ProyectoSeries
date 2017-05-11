package modelo;

public class Serie {
	private int idSerie;
	private String titulo;
	private String genero;
	private String fechaLanzamiento;
	private int temporadas;
	
	public Serie(int id, String t, String g, String fl, int temp){
		idSerie=id;
		titulo=t;
		genero=g;
		fechaLanzamiento=fl;
		temporadas=temp;		
	}
	
	public int getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitutlo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(String fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

}
