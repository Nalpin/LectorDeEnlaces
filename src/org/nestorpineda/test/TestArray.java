package org.nestorpineda.test;

public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] misUsuarios = {"carlos", "mario", "ricardo"};
		AccesosMal accesosMal = new AccesosMal(misUsuarios);
		// Manejo de accesos usando una clase mal implementada
		System.out.println("[AccesosMal]");
		System.out.println(accesosMal);
		misUsuarios[0] = "Pirata";
		System.out.println(accesosMal);
		String[] usuariosHackeados = accesosMal.getAccesos();
		usuariosHackeados[2] = "Hacker";
		System.out.println(accesosMal);
		// Manejo de accesos utilizando copias y no las referencias privadas
		System.out.println("[Accesos]");
		String[] misUsuarios2 = {"carlos", "mario", "ricardo"};
		Accesos accesos = new Accesos(misUsuarios2);
		System.out.println(accesos);
		misUsuarios2[0] = "Pirata";
		System.out.println(accesos);
		usuariosHackeados = accesos.getAccesos();
		usuariosHackeados[2] = "Hacker";
		System.out.println(accesos);
	}

}

class AccesosMal {
	private String[] accesos;
	
	AccesosMal(String[] accesos) {
		this.accesos = accesos;
	}

	public String[] getAccesos() {
		return accesos;
	}

	public void setAccesos(String[] accesos) {
		this.accesos = accesos;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(String usuario : accesos) {
			str.append(usuario);
			str.append(" ");
		}
		return str.toString();
	}
}

class Accesos {
	private String[] accesos;
	
	Accesos(String[] accesos) {
		// La variable de instancia recibe una copia
		this.accesos = accesos.clone();
	}

	public String[] getAccesos() {
		// Devolvemos una copia
		return accesos.clone();
	}

	public void setAccesos(String[] accesos) {
		// La variable de instancia recibe una copia
		this.accesos = accesos.clone();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(String usuario : accesos) {
			str.append(usuario);
			str.append(" ");
		}
		return str.toString();
	}
}