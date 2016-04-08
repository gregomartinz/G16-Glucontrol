package es.upm.dit.isst.glucosa.model;

import java.util.ArrayList;

public class Usuario {
	public String dni;
	public String correo;
	public String nombre;
	public String genero;
	public String fechaDiagnostico;
	public String fechaNacimiento;
	public ArrayList<String> datos;
	public String password;
	public boolean admin;

	public Usuario(String dni, String correo, String nombre, String genero,
			String fechaDiagnostico, String fechaNacimiento,
			ArrayList<String> datos, String password, boolean admin) {
		super();
		this.dni = dni;
		this.correo = correo;
		this.nombre = nombre;
		this.genero = genero;
		this.fechaDiagnostico = fechaDiagnostico;
		this.fechaNacimiento = fechaNacimiento;
		this.datos = datos;
		this.password = password;
		this.admin = admin;

	}
	public boolean isAdmin(){
		return this.admin;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFechaDiagnostico() {
		return fechaDiagnostico;
	}
	public void setFechaDiagnostico(String fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public ArrayList<String> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", correo=" + correo + ", nombre="
				+ nombre + ", genero=" + genero + ", fechaDiagnostico="
				+ fechaDiagnostico + ", fechaNacimiento=" + fechaNacimiento
				+ ", datos=" + datos + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (datos == null) {
			if (other.datos != null)
				return false;
		} else if (!datos.equals(other.datos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaDiagnostico == null) {
			if (other.fechaDiagnostico != null)
				return false;
		} else if (!fechaDiagnostico.equals(other.fechaDiagnostico))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}
