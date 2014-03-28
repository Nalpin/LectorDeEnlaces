package org.nestorpineda.util;
// basado en codigo impartido en kinal por Edwin Tumax

public class ValidarNit {
	public static boolean esValido(String nit) {
		// Quitar guiones de la entrada
		nit = nit.replaceAll("-", "").toUpperCase();
		// Implementa la verificacion de Modulo 11
		int suma = 0;
		for (int i = 0; i < nit.length() - 1; i++) {
			suma += Integer.parseInt(nit.substring(i, i + 1)) * (nit.length() - i);
		}
		int modulo11 = (11 - (suma % 11)) % 11;
		// digito verificador es K si el modulo11 es 10, sino es igual al modulo11
		char digito = (modulo11 == 10)? 'K' : Integer.valueOf(modulo11).toString().charAt(0);
		// El nit es valido si el digito verificador coincide
		return digito == nit.charAt(nit.length() - 1);
	}

}
