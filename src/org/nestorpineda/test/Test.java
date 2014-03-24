package org.nestorpineda.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.nestorpineda.lector.LectorDeEnlaces;

public class Test {

	/**
	 * @param args: args[0] Nombre archivo de entrada
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Falta parametro de archivo de entrada.");
			return;
		}
		// Lector de archivo de texto en formato html
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(args[0]));
			int numLinea = 0; // Numero de línea
			String linea;
			do {
				// Leer una linea del archivo de entrada
				linea = lector.readLine();
				if (linea == null) continue;
				numLinea++;
				// Iteramos sobre el LectorDeEnlaces de la linea actual
				for (String enlace : new LectorDeEnlaces(linea)) {
					System.out.println(numLinea + ": " + enlace);
				}
			} while (linea != null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}
	}
}