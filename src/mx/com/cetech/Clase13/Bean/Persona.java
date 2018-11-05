package mx.com.cetech.Clase13.Bean;

public class Persona {
	
	
	public Persona() {
	}
	
	public Persona(int idPersona, String nombre, String paterno, String materno, String genero, String celular,
			String fechaDeNacimiento) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.genero = genero;
		this.celular = celular;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	private int idPersona;
	private String nombre, paterno, materno, genero, celular, fechaDeNacimiento;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	
	

}
