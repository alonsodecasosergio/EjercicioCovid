package ObjetosVO;

public class Personas {
	
	private int id;
	private int id_ciudad;
	private String Nombre;
	private String tipo;
	private boolean infectado;
	
	public Personas(int id, int id_ciudad, String nombre, String tipo, boolean infectado) {
		
		this.id = id;
		this.id_ciudad = id_ciudad;
		Nombre = nombre;
		this.tipo = tipo;
		this.infectado = infectado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isInfectado() {
		return infectado;
	}

	public void setInfectado(boolean infectado) {
		this.infectado = infectado;
	}	

}
