package net.abcdroid.roboguicesqlite.dbo;

public class PersonaDbo {

	private String dni;
	private String apPaterno;
	private String apMaterno;
	private String nombres;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	@Override
	public String toString() {
		return "PersonaDbo [dni=" + dni + ", apPaterno=" + apPaterno
				+ ", apMaterno=" + apMaterno + ", nombres=" + nombres + "]";
	}
}