package org.nestorpineda.test;

import org.nestorpineda.util.ValidarNit;

public class TestNit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String nit1 = "3949123-4";
		String nit2 = "3949123-5";
		String nit3 = "580055-2";
		System.out.println(nit1 + ": " + (ValidarNit.esValido(nit1)?"V�lido": "Inv�lido"));
		System.out.println(nit2 + ": " + (ValidarNit.esValido(nit2)?"V�lido": "Inv�lido"));
		System.out.println(nit3 + ": " + (ValidarNit.esValido(nit3)?"V�lido": "Inv�lido"));
	}

}
